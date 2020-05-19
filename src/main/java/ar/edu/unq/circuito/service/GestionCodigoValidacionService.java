package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.CodigoDeCuentaDeUsuario;
import ar.edu.unq.circuito.repo.CodigoDeCuentaDeUsuarioRepository;
import ar.edu.unq.circuito.repo.UsuarioRepository;
import ar.edu.unq.circuito.util.GeneradorDeCodigo;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class GestionCodigoValidacionService {
    @Autowired
    private CodigoDeCuentaDeUsuarioRepository codigoDeCuentaDeUsuarioRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public boolean validarCodigo(String codigo, long usuarioId) {
        if ( ! usuarioRepository.existsById(usuarioId)) {
            throw new NoSuchElementException("El id de usuario no existe");
        }
        CodigoDeCuentaDeUsuario codigoDeCuentaDeUsuario =
                codigoDeCuentaDeUsuarioRepository.findByUsuarioId(usuarioId).get();//orElseThrow(()-> {throw new IllegalArgumentException("el usuario no tiene un codigo generado");});
                String codin = codigoDeCuentaDeUsuario.getCodigo();
        return codigoDeCuentaDeUsuario.getCodigo().contentEquals(codigo);
    }

    public String generarCodigoValidacion(long usuarioId) {
        if ( ! usuarioRepository.existsById(usuarioId)) {
            throw new NoSuchElementException("El id de usuario no existe");
        }
        String codigo = GeneradorDeCodigo.generarCodigo();
        
        CodigoDeCuentaDeUsuario codigoDeCuentaDeUsuario = new CodigoDeCuentaDeUsuario();
        codigoDeCuentaDeUsuario.setCodigo(codigo);
        codigoDeCuentaDeUsuario.setUsuarioId(usuarioId);
        codigoDeCuentaDeUsuarioRepository.save(codigoDeCuentaDeUsuario);
        return codigo;
    }
    
}
