package ar.edu.unq.circuito.service;

import ar.edu.unq.circuito.util.RecitalBuilder;
import ar.edu.unq.circuito.model.Genero;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

@Service
public class RecitalServiceImpl implements RecitalService {

    @Autowired
    private RecitalRepository recitalRepository;

    @Override
    public void guardar(Recital recital) {
        // prop. guarda el recital a la base de datos
        recitalRepository.save(recital);
    }

    @Override
    public List<Recital> buscarTodos() {
        // prop. retorna todos los recitales de la base de datos
        return recitalRepository.findAll();
    }

    @Override
    public List<Recital> filterGenero(String genero) {
        // prop. retorna todos los recitales de dicho genero
        return recitalRepository.findByGeneros(genero);
    }

    @Override
    public void cargarDatos() {
        
        recitalRepository.deleteAllInBatch();
        
        Recital recitalUno = RecitalBuilder
                .conNombre("Convencion de Batmans")
                .conDescripcion("MAÑACO se precenta con su nueva formacion en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList("MAÑACO","ETILIKO","SinFronteras"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.METAL,Genero.PUNK))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMyXyrm9xL_dEbm3gZVD_4wru7ITpJAWxgEZYbQcDfR4WvKsrp&usqp=CAU")
                .conPrecio(0).build();
        recitalRepository.save(recitalUno);   
        
    }

}
