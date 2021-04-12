package tn.esprit.spring.mail;

import javax.mail.MessagingException;

import org.springframework.mail.MailException;
import tn.esprit.spring.Oussama.reclamation;


public interface MailService {

	void Send(reclamation Reclamtion) throws MailException;

	void sendWithAttachment(reclamation Reclamtion, String attachement) throws MailException, MessagingException;

}
