package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.builder.RecitalBuilder;
import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class RecitalServiceTest extends CircuitoDelUnderBackendApplicationTests {
    
    @Autowired
    RecitalService recitalService;
    
    @Autowired
    RecitalRepository recitalRepository;
    
    @Test
    public void buscarTodos_conRecitalenEnLaBaseDeDatos_RetornaDosRecitales(){
        Recital recitalPersistidoUno = RecitalBuilder.conNombre("ElRecintoRock").build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("Convencion de Batmans ").build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("El rotage").build(em);
        
        List<Recital> recitalesrecuperados = recitalService.buscarTodos();
        assertThat(recitalesrecuperados).size().isEqualTo(3);
    }
    
    @Test
    public void BuscarPorId_conRecitalenPersistido_RetornaRecital(){
        Recital recitalPersistido = RecitalBuilder.conNombre("ElRecintoRock").build(em);
        
        Recital recitalRecuperado = recitalService.buscarPorId(recitalPersistido.getId());
        assertThat(recitalRecuperado).extracting("nombre").isEqualTo(recitalPersistido.getNombre());
    }
    
    @Test
    public void buscarPorGenerosRock_conRecitalenPersistido_RetornaDosRecitales(){
    	Banda banda = BandaBuilder.conNombre("MAÑACO").conGeneros(Arrays.asList(new Genero("ROCK"))).build(em);
    	Banda bandaDos = BandaBuilder.conNombre("Demoledor").conGeneros(Arrays.asList(new Genero("METAL"), new Genero("PUNK"))).build(em);
    	Banda bandaTres = BandaBuilder.conNombre("Sin Fronteras").conGeneros(Arrays.asList(new Genero("ROCK"), new Genero("METAL"), new Genero("PUNK"))).build(em);
        
        Recital recitalPersistidoUno = RecitalBuilder.conNombre("Mañaco").conBandas(Arrays.asList(banda)).build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("Festi metal").conBandas(Arrays.asList(bandaDos)).build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("Sin fronteras").conBandas(Arrays.asList(bandaTres)).build(em);
        
        List<Recital> recitalesrecuperados = recitalService.filterGenero("Rock");
        assertThat(recitalesrecuperados).size().isEqualTo(2);
    }
}
