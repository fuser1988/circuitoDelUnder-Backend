package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.Usuario;

import java.io.File;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmailService {
	
	private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    void enviarCodigoDeValidacion(String codigo, Usuario usuario) {
    	MimeMessage mailMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mailMessage,true);
			helper.setTo(usuario.getEmail());
	        helper.setSubject("Código De Validación");
	        helper.setText(
	        		"<html>"
	        			+ "<body>"
	        				+ "<div>Sr Usuario,"
	        	             	+ "<div>Su código de validación es:</div>"
	        	             	+ "<div><strong>Algo:</strong></div>"
	        	                + "<div>Gracias</div>"
	        	                + "Circuito del Under"
	        	                + "<img src= 'https://raw.githubusercontent.com/fuser1988/circuitoDelUnder-Documentacion/master/Circuito-del-under.png'/>"
	        	                + "</div></body>"
	        	         + "</html>", true);

	        javaMailSender.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }

	public void sendMail() {
		MimeMessage mailMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(mailMessage,true);
			helper.setTo(""); // algun mail
	        helper.setSubject("Código De Validación");
	        helper.setText(
	        		"<html>"
	        			+ "<body>"
	        				+ "<div>Sr Usuario,"
	        	             	+ "<div>Su código de validación es:</div>"
	        	             	+ "<div><strong>Algo:</strong></div>"
	        	                + "<div>Gracias</div>"
	        	                + "Circuito del Under"
	        	                + "<img src= 'https://raw.githubusercontent.com/fuser1988/circuitoDelUnder-Documentacion/master/Circuito-del-under.png'/>"
	        	                + "</div></body>"
	        	         + "</html>", true);
	        javaMailSender.send(mailMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
		
	}
    
}
