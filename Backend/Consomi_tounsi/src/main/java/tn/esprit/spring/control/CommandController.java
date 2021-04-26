package tn.esprit.spring.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

import antlr.debug.MessageAdapter;
import tn.esprit.spring.entity.Command;
import tn.esprit.spring.entity.CommandItem;
import tn.esprit.spring.entity.PaymentType;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.payload.CmdItemReq;
import tn.esprit.spring.payload.CommandReq;
import tn.esprit.spring.payload.MessageResponse;
import tn.esprit.spring.repository.CommandItemRepository;
import tn.esprit.spring.repository.CommandRepository;
import tn.esprit.spring.repository.ProductRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.request.ChargeRequest;
import tn.esprit.spring.security.services.UserDetailsImpl;
import tn.esprit.spring.service.StripeService;
import tn.esprit.spring.service.pdfService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/command")
public class CommandController {
	
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommandRepository commandRepository;
	@Autowired
	CommandItemRepository commandItemRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired 
	pdfService pdfService;
	@Autowired
    StripeService paymentsService;

	
	@Autowired
	private JavaMailSender javaMailSender;
	@GetMapping("/all")
	public ResponseEntity<?> getAllCommands( )
	{
		UserDetails userDetails =
				(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Optional<User> user = userRepository.findById(((UserDetailsImpl)userDetails).getId());
		return new ResponseEntity<>( user.get().getCommands(),  HttpStatus.OK);
	}
	
	@GetMapping("/cancel/{id}")
	public ResponseEntity<?> cancelCommand( @PathVariable int id)
	{
		Optional<Command> command = commandRepository.findById(id);
		if(command.isPresent())
		{
			long diff = new Date().getTime() - command.get().getDate().getTime();
			float diffDays = diff / (1000 * 60 * 60 * 24);
			if(diffDays <= 1f && command.get().getCanceled() == false)
			{
				command.get().setCanceled(true);
				for(CommandItem item : command.get().getItems())
				{
					Product p = item.getProduct();
					int newStock = p.getStocks().getStock_remaining_quantity() + item.getQuantity();
					p.getStocks().setStock_remaining_quantity(newStock);
				}
				commandRepository.save(command.get());
				
				
				return ResponseEntity.ok().body(new MessageResponse("Command id " + id + " canceled"));
			}
			else
			{
				return ResponseEntity.badRequest().body(new MessageResponse("Cancling this command is not possible"));
			}
			
		}
		else
		{
			return ResponseEntity.badRequest().body(new MessageResponse("Command id " + id + " not found"));
		}
	}
	@GetMapping("/generate/{id}")
	public void generateCommand( @PathVariable int id, HttpServletResponse response) throws IOException, DocumentException
	{
		Optional<Command> command = commandRepository.findById(id);
		if(command.isPresent())
		{
			Path file = Paths.get(pdfService.generatePdf(command).getAbsolutePath());
            if (Files.exists(file)) {
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition",
                        "attachment; filename=" + file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
		}
		else
		{
			response.sendError(505, "Command id " + id + " not found");
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addCommand( @RequestBody CommandReq cmdReq)
	{
		UserDetails userDetails =
				(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<CommandItem> items = new ArrayList<>();
		Command command = new Command();
		double total = 0;
		long id = 0;
		boolean confirmed = true;
		for(CmdItemReq item : cmdReq.getItems())
		{
			CommandItem i = new CommandItem();
			Product p = productRepository.findProductByid(item.getIdProd());
			if(p.getStocks().getStock_remaining_quantity() < item.getQuantity())
			{
				id = p.getId();
				confirmed = false;
				break;
			}
			double t = item.getQuantity() * p.getProduct_price();
			i.setCommand(command);
			i.setProduct(p);
			int newStock = p.getStocks().getStock_remaining_quantity() - item.getQuantity();
			p.getStocks().setStock_remaining_quantity(newStock);
			i.setQuantity(item.getQuantity());
			i.setTotal(t);
			items.add(i);
			total += t;
		}
		if(confirmed)
		{
			command.setItems(items);
			Optional<User> user = userRepository.findById(((UserDetailsImpl)userDetails).getId());
			command.setCustomer(user.get());
			PaymentType type = Enum.valueOf(PaymentType.class, cmdReq.getPaymentType());
			command.setPaymentType(type);
			command.setDate(new Date());
			command.setTotal(total);
			commandRepository.save(command);
			
			if(type == PaymentType.Online)
			{
				ChargeRequest chargeRequest = new ChargeRequest();
				chargeRequest.setDescription("Example charge");
		        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
		        chargeRequest.setStripeEmail("liwa.haouari1@esprit.tn");
		        chargeRequest.setAmount(total*100);
		        try {
					chargeRequest.setStripeToken(paymentsService.createCard().getId());
					Charge charge = paymentsService.charge(chargeRequest);
					
				} catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException
						| APIException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
	        
			
			
			
			
			MimeMessage message = javaMailSender.createMimeMessage();
		    try {
		        MimeMessageHelper helper = new MimeMessageHelper(message, true);
		        helper.setFrom("liwa71070@gmail.com");
		        helper.setTo(user.get().getEmail());
		        helper.setSubject("Command Confirmed");
		        helper.setText("Hello, \n Here attached your bill");
		        byte[] content = Files.readAllBytes(Paths.get(pdfService.generatePdf(Optional.of(command)).getAbsolutePath()));
		        helper.addAttachment("Bill.pdf", new ByteArrayResource(content));
		        javaMailSender.send(message);
		    } catch (MessagingException | IOException | com.itextpdf.text.DocumentException e) {

		        e.printStackTrace();
		    }
			
			
			
			
			
			return ResponseEntity.ok().body(new MessageResponse("Command added"));	
		}
		else
		{
			return ResponseEntity.badRequest().body(new MessageResponse("Check quantity for item : " + id));	
		}
		
		
	}

}
