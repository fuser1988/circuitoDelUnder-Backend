package ar.edu.unq.circuito.service;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.builder.IniciatiavaRecitalBuilder;
import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;
import ar.edu.unq.circuito.vo.IniciativaRecitalVo;

public class IniciativaRecitalTest extends CircuitoDelUnderBackendApplicationTests {

	@Autowired
    IniciativaRecitalService iniciativaService;

    @Autowired
    IniciativaRecitalRepository iniciativaRepository;
    
    @Test
    public void buscarTodos_conIniciativaRecitalesenEnLaBaseDeDatos_RetornaTresiniciativaRecitales() {
    	Banda banda1 = BandaBuilder.conNombre("La Renga").build(em);
        Banda banda2 = BandaBuilder.conNombre("Desorbitados").build(em);
        Banda banda3 = BandaBuilder.conNombre("Demoledor").build(em);
        
    	IniciativaRecital iniciativaRecitalPersistidoUno = IniciatiavaRecitalBuilder.conDescripcion("ElRecintoRock").conBanda(banda1).build(em);
        IniciativaRecital iniciativaRecitalPersistidoDos = IniciatiavaRecitalBuilder.conDescripcion("Convencion de Batmans ").conBanda(banda2).build(em);
        IniciativaRecital iniciativaRecitalPersistidoTres = IniciatiavaRecitalBuilder.conDescripcion("El rotage").conBanda(banda3).build(em);

        Pageable paging = PageRequest.of(0, 2);
        Page<IniciativaRecitalVo> iniciativaRecitalesrecuperados = iniciativaService.buscarTodos(paging);
        
        assertThat(iniciativaRecitalesrecuperados.getTotalElements()).isEqualTo(3);
        assertThat(iniciativaRecitalesrecuperados.getNumberOfElements()).isEqualTo(2);
    }

}
