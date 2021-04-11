package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import tn.esprit.spring.security.services.UserDetailsImpl;

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
	
	@PostMapping("/add")
	public ResponseEntity<?> authenticateUser( @RequestBody CommandReq cmdReq)
	{
		UserDetails userDetails =
				(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<CommandItem> items = new ArrayList<>();
		Command command = new Command();
		double total = 0;
		for(CmdItemReq item : cmdReq.getItems())
		{
			CommandItem i = new CommandItem();
			Product p = productRepository.findProductByid(item.getIdProd());
			double t = item.getQuantity() * p.getProduct_price();
			i.setCommand(command);
			i.setProduct(p);
			i.setQuantity(item.getQuantity());
			i.setTotal(t);
			items.add(i);
			total += t;
		}
		command.setItems(items);
		Optional<User> user = userRepository.findById(((UserDetailsImpl)userDetails).getId());
		command.setCustomer(user.get());
		PaymentType type = Enum.valueOf(PaymentType.class, cmdReq.getPaymentType());
		command.setPaymentType(type);
		command.setDate(new Date());
		command.setTotal(total);
		commandRepository.save(command);
		return ResponseEntity.ok().body(new MessageResponse("Command added"));
		
	}

}
