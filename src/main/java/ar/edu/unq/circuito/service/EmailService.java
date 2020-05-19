package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.Usuario;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    	SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(usuario.getEmail());
        mailMessage.setSubject("Codigo De Validación");
        mailMessage.setText("El Codigo de validación es: " + codigo);

        javaMailSender.send(mailMessage);
    }

}
