package ar.edu.unq.circuito.util;

import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalRepository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private RecitalRepository recitalRepository;

    @Autowired
    public DatabaseLoader(RecitalRepository recitalRepository) {
        this.recitalRepository = recitalRepository;
    }

//    @Override
    public void run(String... args) throws Exception {

        recitalRepository.deleteAllInBatch();

        Recital recitalUno = RecitalBuilderForLoader
                .conNombre("Convención de Batmans")
                .conDescripcion("MAÑACO se presenta con su nueva formación en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList("MAÑACO", "ETILIKO", "Sin Fronteras"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.METAL, Genero.PUNK))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("Alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMyXyrm9xL_dEbm3gZVD_4wru7ITpJAWxgEZYbQcDfR4WvKsrp&usqp=CAU")
                .conPrecio(0).build();

        Recital recitalDos = RecitalBuilderForLoader
                .conNombre("Aluminosis")
                .conDescripcion("Aluminosis se presenta con su nueva formación en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList("Aluminosis", "ETILIKO"))
                .conGeneros(Arrays.asList(Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://scontent.faep4-1.fna.fbcdn.net/v/t1.0-9/432222_358355290852913_1938838162_n.jpg?_nc_cat=110&_nc_sid=6e5ad9&_nc_ohc=cNmNhzMwNrEAX9x_hEE&_nc_ht=scontent.faep4-1.fna&oh=846aa6f4e95ac877a3014ba43251889c&oe=5ED3EDDCjpg")
                .conPrecio(0).build();

        Recital recitalTres = RecitalBuilderForLoader
                .conNombre("Lolapeluza")
                .conDescripcion("Potencial Hardcore se presenta al Lolapeluza con todo su rock punk no te lo podes perder")
                .conBandas(Arrays.asList("Potencial", "ETILIKO"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.METAL, Genero.HARDCORE, Genero.PUNK, Genero.PUNK_ROCK))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("San Isidro")
                .conDireccion("Bernabe marquez 800")
                .conLugar("Hipódromo de San Isidro")
                .conImagen("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTaKkBYrBRb131SvqD4Nfw000qaBFtvL5L1WOvL2K7vStRzKtss&usqp=CAU")
                .conPrecio(0).build();

        Recital recitalCuatro = RecitalBuilderForLoader
                .conNombre("REGGAE for ever")
                .conDescripcion("DESORBITADOS se presenta para festejar su aniversario junto a los GONDWANA, en el Club Tucumán")
                .conBandas(Arrays.asList("DESORBITADOS", "GONDWANA"))
                .conGeneros(Arrays.asList(Genero.METAL, Genero.REGGAE))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("Andres baranda 941")
                .conLugar("Club Tucuman")
                .conImagen("https://pxb.cdn.0221.com.ar/0221/022019/1549635228344.jpg?x=18&y=95&width=1463&height=732&rotate=0&scaleX=1&scaleY=1&ow=1500&oh=964&&cw=1920&ch=950")
                .conPrecio(0).build();

        Recital recitalCinco = RecitalBuilderForLoader
                .conNombre("Escuela de Blues")
                .conDescripcion("Hoy una noche de puro rock y Blues en La Barra. Tenemos show en vivo de AMNECIA, FORASTEROS, La Mississippi y ConurbanoBlues. Los esperamos! Las mejores noches de rock están en La Barra")
                .conBandas(Arrays.asList("AMNECIA", "FORASTEROS", "LaMississippi", "ConurbanoBlues"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("almirante brown 662")
                .conLugar("La Barra")
                .conImagen("https://pxb.cdn.elchubut.com.ar/chubut/022020/1582235138036/Hoy%20terapia%2001.jpeg")
                .conPrecio(0).build();

        Recital recitalSeis = RecitalBuilderForLoader
                .conNombre("Furias del metal")
                .conDescripcion("Hoy Noche de Metal Argento en La caldera. Se presenta Demoledor juto a Furias del metal.Los esperamos! Las mejores noches de rock están en La caldera")
                .conBandas(Arrays.asList("Furias del metal", "Demoledor"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.METAL, Genero.NEW_METAL))
                .conFecha(LocalDate.of(2020, 6, 22))
                .conHora(LocalTime.of(21, 00, 00))
                .conLocalidad("Avellaneda")
                .conDireccion("Mitre 2250")
                .conLugar("La caldera")
                .conImagen("http://cdn-d15c.kxcdn.com/contenidos/201904/2a53ef1d-6e6c-4b34-bc65-3f85e202f217.png")
                .conPrecio(0).build();

        Recital recitalSiete = RecitalBuilderForLoader
                .conNombre("Las ex")
                .conDescripcion("Hoy una noche de a puro Punk Rock en el Salon Pueyrredón. Las ex presentan su nuevo disco en casa. No te lo podes perder! Las mejores noches de rock están en Salon Pueyrredón")
                .conBandas(Arrays.asList("AMNECIA", "FORASTEROS", "LaMississippi", "ConurbanoBlues"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.PUNK,Genero.PUNK_ROCK))
                .conFecha(LocalDate.of(2020, 8, 10))
                .conHora(LocalTime.of(20, 30, 00))
                .conLocalidad("Palermo")
                .conDireccion("Av. Santafe 2585")
                .conLugar("Salon Pueyrredón")
                .conImagen("https://video-images.vice.com/_uncategorized/1539281513314-Paltax.jpeg")
                .conPrecio(0).build();

        Recital recitalOcho = RecitalBuilderForLoader
                .conNombre("Don Cabot")
                .conDescripcion("Hoy una noche de a Rock and Roll  y blus en El faro. Gandes exponentes del rockandroll local se Presentan en El faro tu lugar")
                .conBandas(Arrays.asList("Don Cabot", "Piojosos", "LaMississippi"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES,Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2018, 7, 16))
                .conHora(LocalTime.of(23, 15, 00))
                .conLocalidad("Lanus")
                .conDireccion("Ortusar 6582")
                .conLugar("El faro")
                .conImagen("https://lh3.googleusercontent.com/proxy/Z_w7AOCOJdYNkYvBfzioLGDcGuE5bFzN-0PPkriGhbJaUufICCpsTFSSkHU8jB0DeRNfnxEOInQSALDGbePokayH13Zqr0sfGM0brntXvCv25Q")
                .conPrecio(0).build();

        Recital recitalNueve = RecitalBuilderForLoader
                .conNombre("Recitales en resistencia")
                .conDescripcion("Una nueva ediccion de Recitales en recistencia se llevara a cabo en el complejo cultural Maria Ocampo.No te lo podes perder.Entrada totalmente gratuita.")
                .conBandas(Arrays.asList("MAÑACO", "KONTRA VIOLENCIA", "Don Cabot", "ETILIKO","Sin fronteras","Desahogo"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.PUNK, Genero.PUNK_ROCK, Genero.HARDCORE_PUNK, Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2020, 12, 16))
                .conHora(LocalTime.of(16, 00, 00))
                .conLocalidad("Banfield")
                .conDireccion("Rio bamba 2255")
                .conLugar("Centro cultural Maria Campo")
                .conImagen("https://scontent.faep4-1.fna.fbcdn.net/v/t1.0-9/13315693_1728087494074616_9080128304275698378_n.png?_nc_cat=108&_nc_sid=6e5ad9&_nc_ohc=Var41vw7kWEAX8PPKQ_&_nc_ht=scontent.faep4-1.fna&oh=64c7f0ea7b3815e2c75025437dd53a44&oe=5ED1AD79")
                .conPrecio(0).build();

        Recital recitalDiez = RecitalBuilderForLoader
                .conNombre("Solventes de Todo")
                .conDescripcion("La legendaria banda del corurbano vuelve a los ecenarios de la mano con nuevo materia y vos no te lo podes perder.")
                .conBandas(Arrays.asList("Solventes de Todo","La mocosa"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.METAL, Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2020, 6, 16))
                .conHora(LocalTime.of(20, 30, 00))
                .conLocalidad("Solano")
                .conDireccion("San martin 2258")
                .conLugar("Sudaka")
                .conImagen("http://entreriosahora.com/wp-content/uploads/2019/06/rock-759x500.jpg")
                .conPrecio(0).build();

        Recital recitalOnce = RecitalBuilderForLoader
                .conNombre("La tia Mary")
                .conDescripcion("Vuelve La tia Mary al barrio que los vio nacer, se presenta en festival solidario por el merendero las comadrejas junto a bandas amigas. ")
                .conBandas(Arrays.asList("La tia Mary", "FORASTEROS", "LaMississippi", "ConurbanoBlues","MAÑACO"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES, Genero.ROCK_AND_ROLL, Genero.NEW_METAL, Genero.REGGAE))
                .conFecha(LocalDate.of(2020, 8, 20))
                .conHora(LocalTime.of(14, 00, 00))
                .conLocalidad("Lanus")
                .conDireccion("Garatica 2158")
                .conLugar("Plaza lagarde")
                .conImagen("https://3.bp.blogspot.com/-bsRZkKNAB50/UaOhvlD_FbI/AAAAAAAAADM/5IAAXTrJfs4/s1600/lavarropas.jpg")
                .conPrecio(0).build();

        Recital recitalDoce = RecitalBuilderForLoader
                .conNombre("Incognitos de la noche")
                .conDescripcion("Hoy una noche de a puro rock en La Barra. Tenemos el show en vivo de Incognitos de la noche, FORASTEROS, La Mississippi y Conurbano Blues. Los esperamos! Las mejores noches de rock están en La Barra")
                .conBandas(Arrays.asList("Incognitos de la noche", "FORASTEROS", "LaMississippi", "ConurbanoBlues"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES, Genero.HARD_ROCK, Genero.ELECTRONICO))
                .conFecha(LocalDate.of(2020, 05, 15))
                .conHora(LocalTime.of(21, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("almirante brown 662")
                .conLugar("La Barra")
                .conImagen("https://rocktambulos.com/wp-content/uploads/DSC_0431_MV-1132x509.jpg")
                .conPrecio(0).build();

        Recital recitalTrece = RecitalBuilderForLoader
                .conNombre("Silencio del vacio")
                .conDescripcion("La legendaria banda de Valenti Alsina presenta su nuevo disco tocando en vivo para todos su seguidores. Entrada libre y gratuita")
                .conBandas(Arrays.asList("Silencio del vacio", "La Katana"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES, Genero.HARD_ROCK))
                .conFecha(LocalDate.of(2020, 10, 11))
                .conHora(LocalTime.of(20, 00, 00))
                .conLocalidad("Avellaneda")
                .conDireccion("Mitre 2245")
                .conLugar("El Catar")
                .conImagen("https://pm1.narvii.com/6730/a823645baba51e9ba2c90d20579fb0f1daa0b184v2_hq.jpg")
                .conPrecio(0).build();
        
        Recital recitalCatorce = RecitalBuilderForLoader
                .conNombre("Volátil")
                .conDescripcion("Volátil se presenta junto a grandes colegas del under local. No te lo podes perder")
                .conBandas(Arrays.asList("Camus", "Los de siempre"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2020, 9, 21))
                .conHora(LocalTime.of(23, 00, 00))
                .conLocalidad("Burzaco")
                .conDireccion("Pedro moran 6622")
                .conLugar("El Amparo")
                .conImagen("http://03442.com.ar/noticias/wp-content/uploads/2016/08/VOLATIL-ROCK-EN-BS-AS-1-e1471890391969.jpg")
                .conPrecio(0).build();

        Recital recitalQuince = RecitalBuilderForLoader
                .conNombre("Festival musical Todos por Juan")
                .conDescripcion("Gran festival musical 'Todos Por Juan' participa de esta campaña solidaria y apoya el rock independiente. Entrada un alimento no precedero")
                .conBandas(Arrays.asList("Dueños de la nada", "Demoledor", "La Mississippi", "Conurbano Blues", "Un poco de pan"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES, Genero.METAL, Genero.ROCK_AND_ROLL, Genero.HARD_ROCK))
                .conFecha(LocalDate.of(2020, 06, 22))
                .conHora(LocalTime.of(16, 30, 00))
                .conLocalidad("Lomas de Zamora")
                .conDireccion("Almirante brown 2258")
                .conLugar("Plaza Cerrano")
                .conImagen("https://blogmedia.evbstatic.com/wp-content/uploads/wpmulti/sites/31/2016/04/15130500/1dondeescucharmusicaenvivoenbuenosaires.jpg")
                .conPrecio(0).build();

        Recital recitalDieciSeis = RecitalBuilderForLoader
                .conNombre("Dementes")
                .conDescripcion("Hoy una noche de a puro rock y blues la Terraza. Tenemos show en vivo de Dementes, El concilio, La pavada, Ojos turbios. Los esperamos! Las mejores noches de rock están en La terraza")                .conBandas(Arrays.asList("Dementes", "El concilio", "La pavada", "Ojos turbios"))
                .conGeneros(Arrays.asList(Genero.ROCK, Genero.BLUES, Genero.METAL, Genero.NEW_METAL, Genero.ROCK_AND_ROLL))
                .conFecha(LocalDate.of(2020, 11, 20))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Berazategui")
                .conDireccion("Rocha 662")
                .conLugar("La Terraza")
                .conImagen("https://www.inforegion.com.ar/wp-content/uploads/2019/08/banda1200.jpg")
                .conPrecio(0).build();


        recitalRepository.save(recitalUno);
        recitalRepository.save(recitalDos);
        recitalRepository.save(recitalTres);
        recitalRepository.save(recitalCuatro);
        recitalRepository.save(recitalCinco);
        recitalRepository.save(recitalSeis);
        recitalRepository.save(recitalSiete);
        recitalRepository.save(recitalOcho);
        recitalRepository.save(recitalNueve);
        recitalRepository.save(recitalDiez);
        recitalRepository.save(recitalOnce);
        recitalRepository.save(recitalDoce);
        recitalRepository.save(recitalTrece);
        recitalRepository.save(recitalCatorce);
        recitalRepository.save(recitalQuince);
        recitalRepository.save(recitalDieciSeis);

    }

}
