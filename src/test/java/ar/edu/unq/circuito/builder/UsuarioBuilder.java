package ar.edu.unq.circuito.builder;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.model.TipoUsuario;
import com.somospnt.test.builder.AbstractPersistenceBuilder;

public class UsuarioBuilder extends AbstractPersistenceBuilder<Usuario> {

    private UsuarioBuilder() {

        instance = new Usuario();
        instance.setNombre("El Usuario");
        instance.setTipoUsuario(TipoUsuario.REGISTRADO_SIN_CONFIRMACION);
        instance.setEmail("unMail@gmail.com");
        instance.setReferenciaId(13135151);
        
    }

    public static UsuarioBuilder conNombre(String nombre) {
        UsuarioBuilder builder = new UsuarioBuilder();
        builder.instance.setNombre(nombre);
        return builder;
    }
    
    public UsuarioBuilder conTipoUsuario(TipoUsuario tipoUsuario) {
        instance.setTipoUsuario(tipoUsuario);
        return this;
    }
    
    public UsuarioBuilder conEmail(String email) {
        instance.setEmail(email);
        return this;
    }
    
    public UsuarioBuilder conReferenciaId(long referenciaId) {
        instance.setReferenciaId(referenciaId);
        return this;
    }
    
    public UsuarioBuilder conBanda(Banda banda) {
        instance.setBanda(banda);
        return this;
    }

}