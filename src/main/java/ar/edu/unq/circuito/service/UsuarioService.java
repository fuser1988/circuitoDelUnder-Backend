package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.model.TipoUsuario;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.repo.UsuarioRepository;
import ar.edu.unq.circuito.vo.ReferenciaUsuarioVo;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private GestionCodigoValidacionService gestionCodigoValidacionService;
    @Autowired
    private EmailService emailService;

    public Usuario validarCodigoDeUsuario(String codigo, long usuarioId) {
        boolean esCodigoValido = gestionCodigoValidacionService.validarCodigo(codigo, usuarioId);
        Usuario usuario = usuarioRepository.findById(usuarioId).get();
        if (esCodigoValido) {
            usuario.setTipoUsuario(TipoUsuario.REGISTRADO_SIN_BANDA);
        }
        return usuario;
    }

    public Usuario buscarUsuarioPorReferenciaId(long referenciaId) {
        return usuarioRepository.findByReferenciaId(referenciaId).get();
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario identificarUsuarioPorReferencia(ReferenciaUsuarioVo referenciaUsuarioVo) {
        return usuarioRepository.findByReferenciaId(referenciaUsuarioVo.getReferenciaId())
                .orElseGet(() -> {
                    Usuario usuario = new Usuario();
                    usuario.setReferenciaId(referenciaUsuarioVo.getReferenciaId());
                    usuario.setEmail(referenciaUsuarioVo.getEmail());
                    usuario.setNombre(referenciaUsuarioVo.getNombre());
                    usuario.setTipoUsuario(TipoUsuario.REGISTRADO_SIN_CONFIRMACION);
                    usuarioRepository.save(usuario);
                    String codigo = gestionCodigoValidacionService.generarCodigoValidacion(usuario.getId());

                    emailService.enviarCodigoDeValidacion(codigo, usuario);
                    return usuario;
                });

    }

}
