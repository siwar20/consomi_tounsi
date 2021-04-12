package tn.esprit.spring.mail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Oussama.reclamation;


@Service
public class MailServiceImpl implements MailService {
	@Autowired
	public void MailingServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	private JavaMailSender javaMailSender;

	
	@Override
	public void Send(reclamation Reclamtion) throws MailException {

		/*
		 * This JavaMailSender Interface is used to send Mail in Spring Boot.
		 * This JavaMailSender extends the MailSender Interface which contains
		 * send() function. SimpleMailMessage Object is required because send()
		 * function uses object of SimpleMailMessage as a Parameter
		 */

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(Reclamtion.getEmail());
		mail.setTo("dari@gmail.com");
		mail.setSubject("Test Mail");
		mail.setText("test test test");

		/*
		 * This send() contains an Object of SimpleMailMessage as an Parameter
		 */
		javaMailSender.send(mail);
	}
	
	
	/**
	 * This fucntion is used to send mail that contains a attachment.
	 * 
	 * @param
	 * @throws MessagingException
	 */
	@Override
	public void sendWithAttachment(reclamation Reclamtion,String attachement) throws MailException, MessagingException {

		
		//
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	
		//
		helper.setTo(Reclamtion.getEmail());
		helper.setSubject("Claim /");
		//helper.setText(messaage);
		helper.setText("hello "+Reclamtion.getEmail()+" here is your Claim Details");

		//
		
		File file = new File("C:\\Users\\Oussema\\reclamation\\"+ attachement);
		helper.addAttachment(file.getName(), file);

		javaMailSender.send(mimeMessage);
	}

}
