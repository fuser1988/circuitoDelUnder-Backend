package ar.edu.unq.circuito.builder.loader;

import ar.edu.unq.circuito.util.RecitalBuilder;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private RecitalRepository recitalRepository;

    @Autowired
    public DatabaseLoader(RecitalRepository recitalRepository) {
        this.recitalRepository = recitalRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.err.println("========================================="); 
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
