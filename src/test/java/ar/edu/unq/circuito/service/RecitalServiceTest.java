package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.CircuitoDelUnderBackendApplicationTests;
import ar.edu.unq.circuito.builder.BandaBuilder;
import ar.edu.unq.circuito.builder.RecitalBuilder;
import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.model.Ubicacion;
import ar.edu.unq.circuito.repo.RecitalRepository;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class RecitalServiceTest extends CircuitoDelUnderBackendApplicationTests {

    @Autowired
    RecitalService recitalService;

    @Autowired
    RecitalRepository recitalRepository;

    @Test
    public void buscarTodos_conRecitalenEnLaBaseDeDatos_RetornaTrsRecitales() {
        Recital recitalPersistidoUno = RecitalBuilder.conNombre("ElRecintoRock").build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("Convencion de Batmans ").build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("El rotage").build(em);

        Pageable paging = PageRequest.of(0, 2);
        Page<Recital> recitalesrecuperados = recitalService.buscarTodos(paging);
        
        assertThat(recitalesrecuperados.getTotalElements()).isEqualTo(3);
    }

    @Test
    public void BuscarPorId_conRecitalenPersistido_RetornaRecital() {
        Recital recitalPersistido = RecitalBuilder.conNombre("ElRecintoRock").build(em);

        Recital recitalRecuperado = recitalService.buscarPorId(recitalPersistido.getId());
        assertThat(recitalRecuperado).extracting("nombre").isEqualTo(recitalPersistido.getNombre());
    }

    @Test
    public void buscarPorGenerosRock_conRecitalenPersistido_RetornaDosRecitales() {
        Banda banda = BandaBuilder.conNombre("MAÑACO").conGeneros(Arrays.asList(new Genero("ROCK"))).build(em);
        Banda bandaDos = BandaBuilder.conNombre("Demoledor").conGeneros(Arrays.asList(new Genero("METAL"), new Genero("PUNK"))).build(em);
        Banda bandaTres = BandaBuilder.conNombre("Sin Fronteras").conGeneros(Arrays.asList(new Genero("ROCK"), new Genero("METAL"), new Genero("PUNK"))).build(em);

        Recital recitalPersistidoUno = RecitalBuilder.conNombre("Mañaco").conBandas(Arrays.asList(banda)).build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("Festi metal").conBandas(Arrays.asList(bandaDos)).build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("Sin fronteras").conBandas(Arrays.asList(bandaTres)).build(em);

        Pageable paging = PageRequest.of(0, 2);
        Page<Recital> recitalesrecuperados = recitalService.filterGenero("Rock",paging);
        
        assertThat(recitalesrecuperados.getTotalElements()).isEqualTo(2);
    }
    
    @Test
    public void buscaPorCoordenadasEstacionQuilmes_conRecitalenPersistido_RetornaPrimeroElQueEstaEnLaBarra() {
        Banda banda = BandaBuilder.conNombre("MAÑACO").conGeneros(Arrays.asList(new Genero("ROCK"))).build(em);
        Banda bandaDos = BandaBuilder.conNombre("Demoledor").conGeneros(Arrays.asList(new Genero("METAL"), new Genero("PUNK"))).build(em);
        Banda bandaTres = BandaBuilder.conNombre("Sin Fronteras").conGeneros(Arrays.asList(new Genero("ROCK"), new Genero("METAL"), new Genero("PUNK"))).build(em);

        Recital recitalPersistidoUno = RecitalBuilder.conNombre("Mañaco").conBandas(Arrays.asList(banda))
        		.conLugar("La Barra").conUbicacion(new Ubicacion(-34.722511, -58.255382)).build(em);
        Recital recitalPersistidoDos = RecitalBuilder.conNombre("Festi metal").conBandas(Arrays.asList(bandaDos))
        		.conLugar("Hipódromo de San Isidro").conUbicacion(new Ubicacion(-34.481620, -58.522587)).build(em);
        Recital recitalPersistidoTres = RecitalBuilder.conNombre("Sin fronteras").conBandas(Arrays.asList(bandaTres))
        		.conLugar("Sudaka").conUbicacion(new Ubicacion(-34.769387, -58.316998)).build(em);

        Pageable paging = PageRequest.of(0, 3);
        Page<Recital> recitalesrecuperados = recitalService.filterUbicacion(-35.401167, -57.171079,paging);
        
        assertThat(recitalesrecuperados.getTotalElements()).isEqualTo(3);
        assertThat(recitalesrecuperados.getContent().get(0).getLugar()).isEqualTo("La Barra");
    }
}
