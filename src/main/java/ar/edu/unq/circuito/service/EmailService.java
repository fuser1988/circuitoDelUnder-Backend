package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.Usuario;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    void enviarCodigoDeValidacion(String codigo, Usuario usuario) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setTo(usuario.getEmail());
            helper.setSubject("Código De Validación");
            helper.setText(
                    "<html>"
                    + "<body>"
                    + "<div>"
                    + "<div> Bienvenido" + usuario.getNombre() + "</div>"
                    + "<div>Tu código de validación es:</div>"
                    + "<div><strong>" + codigo + "</strong></div>"
                    + "<img src= 'https://raw.githubusercontent.com/fuser1988/circuitoDelUnder-Documentacion/master/Circuito-del-under.png'/>"
                    + "</div>"
                    + "<div>Circuito del Under</div>"
                    + "<div>Gracias</div>"
                    + "</body>"
                    + "</html>", true);

            javaMailSender.send(mailMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
