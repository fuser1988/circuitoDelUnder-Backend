package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EmailService {

    void enviarCodigoDeValidacion(String codigo, Usuario usuario) {
        System.out.println(codigo);
    }
    
}
