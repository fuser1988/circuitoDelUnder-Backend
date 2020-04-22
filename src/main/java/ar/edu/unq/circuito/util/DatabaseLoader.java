package ar.edu.unq.circuito.util;

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
public class DatabaseLoader {//implements CommandLineRunner {

    private RecitalRepository recitalRepository;

    @Autowired
    public DatabaseLoader(RecitalRepository recitalRepository) {
        this.recitalRepository = recitalRepository;
    }

//    @Override
    public void run(String... args) throws Exception {

        recitalRepository.deleteAllInBatch();

        Recital recitalUno = RecitalBuilderForLoader
                .conNombre("Convencion de Batmans")
                .conDescripcion("MAÑACO se precenta con su nueva formacion en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList("MAÑACO", "ETILIKO", "SinFronteras"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.METAL, Genero.PUNK))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMyXyrm9xL_dEbm3gZVD_4wru7ITpJAWxgEZYbQcDfR4WvKsrp&usqp=CAU")
                .conPrecio(0).build();

        Recital recitalDos = RecitalBuilderForLoader
                .conNombre("Aluminosis")
                .conDescripcion("Aluminosis se precenta con su nueva formacion en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList("Aluminosis", "ETILIKO"))
                .conGeneros(Arrays.asList(Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://4.bp.blogspot.com/_GwJ0Eb4YMaY/StxTOJ2h9jI/AAAAAAAAG8I/UIgeMb6bfxs/s320/3filesnegre.jpg")
                .conPrecio(0).build();

        Recital recitalTres = RecitalBuilderForLoader
                .conNombre("Lollapalooza")
                .conDescripcion("Potencial Hardcore se presenta al Lollapalooza con todo su rock punk no te lo podes perder")
                .conBandas(Arrays.asList("PotencialHardcore", "ETILIKO"))
                .conGeneros(Arrays.asList(Genero.METAL, Genero.PUNK, Genero.PUNK_ROCK))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("San Isidro")
                .conDireccion("bernabe marquez 800")
                .conLugar("Hipódromo de San Isidro")
                .conImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTaKkBYrBRb131SvqD4Nfw000qaBFtvL5L1WOvL2K7vStRzKtss&usqp=CAU")
                .conPrecio(0).build();

        Recital recitalCuatro = RecitalBuilderForLoader
                .conNombre("REGGAE for ever")
                .conDescripcion("DESORBITADOS se presenta para festejar su aniversario junto a los GONDWANA, en el Club Tucuman")
                .conBandas(Arrays.asList("DESORBITADOS", "GONDWANA"))
                .conGeneros(Arrays.asList(Genero.REGGAE))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("andres baranda 941")
                .conLugar("Club Tucuman")
                .conImagen("https://pxb.cdn.0221.com.ar/0221/022019/1549635228344.jpg?x=18&y=95&width=1463&height=732&rotate=0&scaleX=1&scaleY=1&ow=1500&oh=964&&cw=1920&ch=950")
                .conPrecio(70).build();

        Recital recitalCinco = RecitalBuilderForLoader
                .conNombre("Escuela de Bluz")
                .conDescripcion("Hoy una noche de a puro rock y blus en La Barra. Tenemos show en vivo de AMNECIA, FORASTEROS, LaMississippi y ConurbanoBlues. Los esperamos! Las mejores noches de rock están en La Barra")
                .conBandas(Arrays.asList("AMNECIA", "FORASTEROS", "LaMississippi", "ConurbanoBlues"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUZ))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("almirante brown 662")
                .conLugar("La Barra")
                .conImagen("https://pxb.cdn.elchubut.com.ar/chubut/022020/1582235138036/Hoy%20terapia%2001.jpeg")
                .conPrecio(120).build();

        recitalRepository.save(recitalUno);
        recitalRepository.save(recitalDos);
        recitalRepository.save(recitalTres);
        recitalRepository.save(recitalCuatro);
        recitalRepository.save(recitalCinco);

    }

}
