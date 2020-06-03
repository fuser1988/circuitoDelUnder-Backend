package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.builder.UsuarioBuilder;
import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.TipoUsuario;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.vo.ReferenciaUsuarioVo;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class UsuarioServiiceTest extends CircuitoDelUnderBackendApplicationTests {

    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    GestionCodigoValidacionService gestionCodigoValidacionService;
    
    @MockBean
    EmailService emailService;
    
    @Test
    public void identificarUsuarioPorReferencia_conReferenciaDeUsuarioQueEntraPorPrimeraVez_RetornaUsuarioRegistradoSinValidar() {

        long idReferenciaNoRegistrado = 213465;
        ReferenciaUsuarioVo referenciaUsuarioVo = new ReferenciaUsuarioVo();
        referenciaUsuarioVo.setReferenciaId(idReferenciaNoRegistrado);
        referenciaUsuarioVo.setNombre("Juan carlso");
        referenciaUsuarioVo.setEmail("sergioluke35@gmail.com");
        Usuario usuario = usuarioService.identificarUsuarioPorReferencia(referenciaUsuarioVo);
        assertThat(usuario).hasFieldOrPropertyWithValue("tipoUsuario", TipoUsuario.REGISTRADO_SIN_CONFIRMACION);
    }

    @Test
    public void identificarUsuarioPorReferencia_conCuentaNoValidada_RetornaUsuarioRegistradoSinValidar() {
        long idReferenciaRegistradoNoValidado = 213465;
        Usuario usuario = UsuarioBuilder.conNombre("juan carlos").conReferenciaId(idReferenciaRegistradoNoValidado).build(em);
        
        ReferenciaUsuarioVo referenciaUsuarioVo = new ReferenciaUsuarioVo();
        referenciaUsuarioVo.setReferenciaId(idReferenciaRegistradoNoValidado);
        referenciaUsuarioVo.setNombre("Juan carlso");
        referenciaUsuarioVo.setEmail("juanCarlos@gmail.com");
        
        Usuario usuarioRecuperado = usuarioService.identificarUsuarioPorReferencia(referenciaUsuarioVo);
        assertThat(usuarioRecuperado).hasFieldOrPropertyWithValue("tipoUsuario", TipoUsuario.REGISTRADO_SIN_CONFIRMACION);
    }
    
    @Test
    public void identificarUsuarioPorReferencia_conCuentaValidada_RetornaUsuarioRegistradoValidado() {
        long idReferenciaRegistradoValidado = 213465;
        Usuario usuario = UsuarioBuilder.conNombre("juan carlos").conReferenciaId(idReferenciaRegistradoValidado).conTipoUsuario(TipoUsuario.REGISTRADO_SIN_BANDA).build(em);
        
        ReferenciaUsuarioVo referenciaUsuarioVo = new ReferenciaUsuarioVo();
        referenciaUsuarioVo.setReferenciaId(idReferenciaRegistradoValidado);
        referenciaUsuarioVo.setNombre("Juan carlso");
        referenciaUsuarioVo.setEmail("juanCarlos@gmail.com");
        
        Usuario usuarioRecuperado = usuarioService.identificarUsuarioPorReferencia(referenciaUsuarioVo);
        assertThat(usuarioRecuperado).hasFieldOrPropertyWithValue("tipoUsuario", TipoUsuario.REGISTRADO_SIN_BANDA);
    }
    
    @Test
    public void identificarUsuarioPorReferencia_conCuentaValidadaConBanda_RetornaUsuarioRegistradoValidadoConBanda() {
        long idReferenciaRegistradoValidado = 213465;
        Usuario usuario = UsuarioBuilder.conNombre("juan carlos").conReferenciaId(idReferenciaRegistradoValidado).conTipoUsuario(TipoUsuario.REGISTRADO_CON_BANDA).build(em);
        Banda banda = BandaBuilder.conNombre("los Marones").conUsuario(usuario).build(em);
        
        ReferenciaUsuarioVo referenciaUsuarioVo = new ReferenciaUsuarioVo();
        referenciaUsuarioVo.setReferenciaId(idReferenciaRegistradoValidado);
        referenciaUsuarioVo.setNombre("Juan carlso");
        referenciaUsuarioVo.setEmail("juanCarlos@gmail.com");
        
        Usuario usuarioRecuperado = usuarioService.identificarUsuarioPorReferencia(referenciaUsuarioVo);
        assertThat(usuarioRecuperado).hasFieldOrPropertyWithValue("tipoUsuario", TipoUsuario.REGISTRADO_CON_BANDA);
        assertThat(usuarioRecuperado.getBanda().getId()).isEqualTo(banda.getId());
    }

    @Test
    public void validarCodigoDeUsuario_conCodigoValido_RetornaUsuarioRegistradoYValidado() {
        long idReferenciaRegistrado = 213465;
        Usuario usuario = UsuarioBuilder.conNombre("juan carlos").conReferenciaId(idReferenciaRegistrado).conTipoUsuario(TipoUsuario.REGISTRADO_SIN_CONFIRMACION).build(em);
        
        String codigoAValidar = gestionCodigoValidacionService.generarCodigoValidacion(usuario.getId());

        Usuario usuarioRecuperado = usuarioService.validarCodigoDeUsuario(codigoAValidar, usuario.getId());
        assertThat(usuarioRecuperado).hasFieldOrPropertyWithValue("tipoUsuario", TipoUsuario.REGISTRADO_SIN_BANDA);
    }
    
    @Test
    public void validarCodigoDeUsuario_conCodigoNoValido_RetornaUsuarioRegistradoSinConfirmacion() {
        long idReferenciaRegistrado = 213465;
        Usuario usuario = UsuarioBuilder.conNombre("juan carlos").conReferenciaId(idReferenciaRegistrado).conTipoUsuario(TipoUsuario.REGISTRADO_SIN_CONFIRMACION).build(em);
        
        gestionCodigoValidacionService.generarCodigoValidacion(usuario.getId());
        String codigoInvalido = "sdfjsdifjspoidufpodfiji";
        Usuario usuarioRecuperado = usuarioService.validarCodigoDeUsuario(codigoInvalido, usuario.getId());
        assertThat(usuarioRecuperado).hasFieldOrPropertyWithValue("tipoUsuario", TipoUsuario.REGISTRADO_SIN_CONFIRMACION);
    }
}
