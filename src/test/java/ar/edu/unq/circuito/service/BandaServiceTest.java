package ar.edu.unq.circuito.service;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.model.Banda;

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
}
