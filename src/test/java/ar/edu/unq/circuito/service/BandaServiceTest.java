package ar.edu.unq.circuito.service;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.builder.UsuarioBuilder;
import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.TipoUsuario;
import ar.edu.unq.circuito.model.Usuario;
import ar.edu.unq.circuito.vo.BandaVo;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BandaServiceTest extends CircuitoDelUnderBackendApplicationTests {

    @Autowired
    BandaService bandaService;

    @Test
    public void buscarTodos_lasBandasEnLaBaseDeDatos_RetornaTresBandas() {
        Banda banda1 = BandaBuilder.conNombre("La Renga").build(em);
        Banda banda2 = BandaBuilder.conNombre("Desorbitados").build(em);
        Banda banda3 = BandaBuilder.conNombre("Demoledor").build(em);

        List<Banda> bandasrecuperados = bandaService.buscarTodos();
        assertThat(bandasrecuperados).size().isEqualTo(3);
    }
    
    @Test
    public void guaradarBandaNueva_conUsuarioExistente_RetornaBandaCreada() {
        Usuario usuario = UsuarioBuilder.conNombre("Felipe").conTipoUsuario(TipoUsuario.REGISTRADO_SIN_BANDA).build(em);
        
        BandaVo bandaVo = new BandaVo();
        bandaVo.setNombre("MAÑACO");
        bandaVo.setGeneros(Arrays.asList("HARDCORE"));
        bandaVo.setImagen("https://unaImagen.com");
        bandaVo.setInfo("Mañaco es una banda de zona sur que surgio a finales del 2014");
        bandaVo.setMaterial(Arrays.asList());
        bandaVo.setUsuarioId(usuario.getId());

        Banda bandaCreada = bandaService.guardarBandaNueva(bandaVo);
        assertThat(bandaCreada.getUsuario().getId()).isEqualTo(usuario.getId());
    }
    
    @Test
    public void guaradarBandaNueva_conUsuarioInexistente_RetornaUnaExcepcion() {
        long usuarioIdInexistente = 999999;
        BandaVo bandaVo = new BandaVo();
        bandaVo.setNombre("MAÑACO");
        bandaVo.setGeneros(Arrays.asList("HARDCORE"));
        bandaVo.setImagen("https://unaImagen.com");
        bandaVo.setInfo("Mañaco es una banda de zona sur que surgio a finales del 2014");
        bandaVo.setMaterial(Arrays.asList());
        bandaVo.setUsuarioId(usuarioIdInexistente);
        
        assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(()
                -> bandaService.guardarBandaNueva(bandaVo))
                .withMessage("El id de usuario no existe");
         
    }
}
