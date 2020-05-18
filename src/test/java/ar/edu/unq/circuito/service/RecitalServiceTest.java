package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.builder.RecitalBuilder;
import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;

import java.util.ArrayList;
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
        
        Recital recitalRecuperado = recitalService.BuscarPorId(recitalPersistido.getId());
        assertThat(recitalRecuperado).extracting("nombre").isEqualTo(recitalPersistido.getNombre());
    }
    
    @Test
    public void buscarPorGenerosRock_conRecitalenPersistido_RetornaDosRecitales(){
    	Banda banda = new Banda();
    	Banda laRenga = new Banda();
    	
    	banda.setNombre("El Banda");
    	banda.setGeneros(Arrays.asList(Genero.METAL, Genero.PUNK));
    	banda.setImagen("www.UnaUmagen.com/imagen");
    	banda.setInfo("somos una banda del sur de Buenos aires, hacemos metal");
    	
    	laRenga.setNombre("La Renga");
    	laRenga.setGeneros(Arrays.asList(Genero.ROCK));
    	laRenga.setImagen("https://www.larenga.com/images/logo.png");
    	laRenga.setInfo("https://www.larenga.com");

    	List<Banda> bandas = new ArrayList<>();
    	bandas.add(banda);
    	
    	List<Banda> lasRengas = new ArrayList<>();
    	lasRengas.add(laRenga);
    	
    	List<Banda> lasBandas = new ArrayList<>();
    	lasBandas.add(laRenga);
    	lasBandas.add(banda);
    	
    	/*
    	Recital recitalPersistidoUno = RecitalBuilder.conNombre("").build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("").build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("").build(em);
        */
    	//Recital recitalPersistidoUno = RecitalBuilder.conBandas(banda).build(em);
        /*Recital recitalPersistidoDos = RecitalBuilder.conBandas(Arrays.asList(banda)).build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conBandas(Arrays.asList(laRenga)).build(em);
        */
        List<Recital> recitalesrecuperados = recitalService.filterGenero("Rock");
        assertThat(recitalesrecuperados).size().isEqualTo(2);
    }
}
