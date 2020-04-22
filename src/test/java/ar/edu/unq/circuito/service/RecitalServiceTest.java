package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.RecitalBuilder;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;
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
//        recitalRepository.deleteAll();
        Recital recitalPersistidoUno = RecitalBuilder.conNombre("ElRecintoRock").build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("Convencion de Batmans ").build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("El rotage").build(em);
        
        List<Recital> recitalesrecuperados = recitalService.buscarTodos();
        assertThat(recitalesrecuperados).size().isEqualTo(3);
    }
}
