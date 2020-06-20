package ar.edu.unq.circuito.service;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.IniciatiavaRecitalBuilder;
import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;

public class IniciativaRecitalTest extends CircuitoDelUnderBackendApplicationTests {

	@Autowired
    IniciativaRecitalService iniciativaService;

    @Autowired
    IniciativaRecitalRepository iniciativaRepository;
    
    @Test
    public void buscarTodos_conIniciativaRecitalesenEnLaBaseDeDatos_RetornaTresiniciativaRecitales() {
        IniciativaRecital iniciativaRecitalPersistidoUno = IniciatiavaRecitalBuilder.conNombre("ElRecintoRock").build(em);
        IniciativaRecital iniciativaRecitalPersistidoDos = IniciatiavaRecitalBuilder.conNombre("Convencion de Batmans ").build(em);
        IniciativaRecital iniciativaRecitalPersistidoTres = IniciatiavaRecitalBuilder.conNombre("El rotage").build(em);

        Pageable paging = PageRequest.of(0, 2);
        Page<IniciativaRecital> iniciativaRecitalesrecuperados = iniciativaService.buscarTodos(paging);
        
        assertThat(iniciativaRecitalesrecuperados.getTotalElements()).isEqualTo(3);
    }

}
