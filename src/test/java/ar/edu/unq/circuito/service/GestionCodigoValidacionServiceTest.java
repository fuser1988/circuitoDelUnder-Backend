package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.UsuarioBuilder;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.repo.RecitalRepository;
import java.util.NoSuchElementException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GestionCodigoValidacionServiceTest extends CircuitoDelUnderBackendApplicationTests {

    @Autowired
    RecitalService recitalService;

    @Autowired
    RecitalRepository recitalRepository;

    @Autowired
    GestionCodigoValidacionService gestionCodigoValidacionService;

    @Test
    public void generarCodigoValidacion_conUsuarioIdExistente_RetornaUnCodigoDeValidacion() {
        Usuario usuario = UsuarioBuilder.conNombre("Roberto Carlos").build(em);
        String codigo = gestionCodigoValidacionService.generarCodigoValidacion(usuario.getId());
        assertThat(codigo).isNotNull();
    }

    @Test
    public void generarCodigoValidacion_conUsuarioIdInexistente_RetornaUnaExcepcion() {
        final long usuarioIsInexistente = 99999;
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(()
                -> gestionCodigoValidacionService.generarCodigoValidacion(usuarioIsInexistente))
                .withMessage("El id de usuario no existe");
    }

    @Test
    public void validarCodigo_conCodigoValido_RetornaTrue() {
        Usuario usuario = UsuarioBuilder.conNombre("Roberto Carlos").build(em);
        String codigo = gestionCodigoValidacionService.generarCodigoValidacion(usuario.getId());
        assertThat(gestionCodigoValidacionService.validarCodigo(codigo, usuario.getId())).isTrue();
    }

    @Test
    public void validarCodigo_conCodigoInvalido_retornaFale() {
        Usuario usuario = UsuarioBuilder.conNombre("Roberto Carlos").build(em);
        String codigo = gestionCodigoValidacionService.generarCodigoValidacion(usuario.getId());
        final String codigoInvalido = "38fhjsbn348rewhljkn348i239";
        boolean esValido = gestionCodigoValidacionService.validarCodigo(codigoInvalido, usuario.getId());
        assertThat(esValido).isFalse();
    }

    @Test
    public void validarCodigo_conUsuarioSinCodigoGenerado_LanzaExepcion() {
        Usuario usuario = UsuarioBuilder.conNombre("Roberto Carlos").build(em);
        final String codigoInvalido = "38fhjsbn348rewhljkn348i239";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()
                -> gestionCodigoValidacionService.validarCodigo(codigoInvalido, usuario.getId()))
                .withMessage("el usuario no tiene un codigo generado");
    }

    @Test
    public void validarCodigo_conUsuarioInexistente_RetornaExcepcion() {
        final long usuarioIsInexistente = 99999;
        final String codigo = "38fhjsbn348rewhljkn348i239";
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(()
                -> gestionCodigoValidacionService.validarCodigo(codigo, usuarioIsInexistente))
                .withMessage("El id de usuario no existe");
    }
}
