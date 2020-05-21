package ar.edu.unq.circuito.util;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Material;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.model.TipoMaterial;
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

    public void run(String... args) throws Exception {
    	
        Material videoEtiliko = new Material();
    	videoEtiliko.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
    	videoEtiliko.setUrl("https://www.youtube.com/embed/Qmb1pGtgj8I?list=PLHL_xXZsGfMY9V4VjjsHqNofLS55hyCbH");
    	videoEtiliko.setComentario("Video del tema Su Falso Mundo del álbun No hay agua");
    	
        Material videoLaRenga = new Material();
    	videoLaRenga.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
    	videoLaRenga.setUrl("https://www.youtube.com/embed/rEETm_4BPDc");
    	videoLaRenga.setComentario("Video del tema Corazón Fugitivo del albun Pesados Vestigios");

    	Material albunRenga = new Material();
    	albunRenga.setTipoMaterial(TipoMaterial.TIPO_ALBUM);
    	albunRenga.setUrl("https://open.spotify.com/album/1LcPYKYAui0A4MNHbbdnvS");
    	albunRenga.setComentario("Albun Trueno Tierra en Spotify");

    	Banda banda = BandaBuilderForLoader.conNombre("MAÑACO").conInfo("").conImagen("").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda elBanda = BandaBuilderForLoader.conNombre("El Banda").conInfo("somos una banda del sur de Buenos aires, hacemos metal").conImagen("https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg").conGeneros(Arrays.asList(new Genero("METAL"))).conMaterial(null).build();
        Banda aluminosis = BandaBuilderForLoader.conNombre("Aluminosis").conInfo("somos una banda española, hacemos rock").conImagen("https://a4-images.myspacecdn.com/images02/8/08beda0e2bd4463c833321ee33ce402e/full.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda etiliko = BandaBuilderForLoader.conNombre("ETILIKO").conInfo("somos un grupo punk procedente de Salvatierra, País Vasco").conImagen("https://i.ytimg.com/vi/ct9Sz6PbCFE/hqdefault.jpg").conGeneros(Arrays.asList(new Genero("PUNK"))).conMaterial(Arrays.asList(videoEtiliko)).build();
        Banda potencial = BandaBuilderForLoader.conNombre("Potencial Hardcore").conInfo("somos una banda de Madrid, hacemos punk").conImagen("http://www.potencialhardcore.org/WebRoot/StoreES2/Shops/64798605/Styles/Fold[7]/logo.jpg").conGeneros(Arrays.asList(new Genero("PUNK"))).conMaterial(null).build();
        Banda desorbitados = BandaBuilderForLoader.conNombre("DESORBITADOS").conInfo("Desorbitados, una gran banda de reggae, algo diferente para los tiempos que corren").conImagen("https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg").conGeneros(Arrays.asList(new Genero("REGGAE"))).conMaterial(null).build();
        Banda gondwana = BandaBuilderForLoader.conNombre("GONDWANA").conInfo("Gondwana es un grupo musical de reggae chileno").conImagen("https://sites.google.com/site/reggaeenchile/_/rsrc/1370535858801/gondwana/gondwana.jpg").conGeneros(Arrays.asList(new Genero("REGGAE"))).conMaterial(null).build();
        Banda amnecia = BandaBuilderForLoader.conNombre("AMNECIA").conInfo("banda de blues").conImagen("http://www.amnesiabluesband.com/_Media/hailstone-front-cover_med-4.jpeg").conGeneros(Arrays.asList(new Genero("BLUES"))).conMaterial(null).build();
        Banda forasteros = BandaBuilderForLoader.conNombre("FORASTEROS").conInfo("somos un grupo olavarriense").conImagen("http://7400noticias.com.ar/wp-content/uploads/2015/09/forasteros3.jpg").conGeneros(Arrays.asList(new Genero("METAL"), new Genero("BLUES"))).conMaterial(null).build();
        Banda laMississippi = BandaBuilderForLoader.conNombre("La Mississippi").conInfo("La Mississippi Blues Band es una banda de blues rock argentino").conImagen("http://www.lamississippi.com.ar/home/wp-content/uploads/2017/11/DSC_4803-copy-uai-1032x691.jpg").conGeneros(Arrays.asList(new Genero("BLUES"))).conMaterial(null).build();
        Banda demoledor = BandaBuilderForLoader.conNombre("Demoledor").conInfo("somos una banda metalera de Florencio Varela").conImagen("https://www.alta-fruta.net/applications/sslimageproxy/interface/image.php?url=http://cayu.com.ar/wp-content/uploads/2014/12/11.jpg").conGeneros(Arrays.asList(new Genero("METAL"))).conMaterial(null).build();
        Banda donCabot = BandaBuilderForLoader.conNombre("Don Cabot").conInfo("es una banda de barrio que se formó en un espontaneo junte de músicos en busca de un espacio en la ruta del rock").conImagen("https://pbs.twimg.com/profile_images/778377437801541632/_FL9yvP3_400x400.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda laMocosa = BandaBuilderForLoader.conNombre(" La Mocosa").conInfo("La Mocosa es una banda de rock independiente formada en Buenos Aires durante el año 2000").conImagen("https://revistamutt.com/wp-content/uploads/2017/06/Gjira-7-1024x683.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda laKatana = BandaBuilderForLoader.conNombre("La Katana").conInfo("banda de rock").conImagen("https://i.ytimg.com/vi/WDe_VkCZEIs/maxresdefault.jpg").conGeneros(Arrays.asList(new Genero("METAL"))).conMaterial(null).build();
        Banda camus = BandaBuilderForLoader.conNombre("Camus").conInfo("somos una banda del sur de Buenos aires, hacemos rock").conImagen("http://www.laizquierdadiario.com/IMG/arton3346.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda dementes = BandaBuilderForLoader.conNombre("Dementes").conInfo("somos una banda de rock").conImagen("http://dementesska.es/wp-content/uploads/2016/01/footer-logo.png").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();  
        Banda laRenga = BandaBuilderForLoader.conNombre("La Renga").conInfo("somos una banda del sur de Buenos aires, hacemos metal").conImagen("https://www.larenga.com/images/logo.png").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(Arrays.asList(videoLaRenga, albunRenga)).build();
        
        //ConurbanoBlues
        //Furias del metal
        //ConurbanoBlues
        //Piojosos
        //KONTRA VIOLENCIA
        //Sin fronteras
        //Desahogo
        //Solventes de Todo 
        //La mocosa
        //La tia Mary
        //ConurbanoBlues
        //Incognitos de la noche
        //Silencio del vacio
        //Los de siempre
        // Dueños de la nada
        //Un poco de pan
        //El concilio
        //La pavada
        //Ojos turbios
        
        recitalRepository.deleteAllInBatch();
        
        Recital recitalUno = RecitalBuilderForLoader
                .conNombre("Convención de Batmans")
                .conDescripcion("MAÑACO se presenta con su nueva formación en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList(banda, elBanda))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("Alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://depositosonoro.com/wp-content/uploads/2019/04/55478027_1689594917851261_4586995436853657600_o.jpg")
                .conPrecio(0).build();

        Recital recitalDos = RecitalBuilderForLoader
                .conNombre("Aluminosis")
                .conDescripcion("Aluminosis se presenta con su nueva formación en El bar del fondo no te lo pierdas")
                .conBandas(Arrays.asList(aluminosis, etiliko))
                .conFecha(LocalDate.of(2018, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://vudum.com.ar/wp-content/uploads/2018/06/DSC_8132-768x513.jpg")
                .conPrecio(0).build();

        Recital recitalTres = RecitalBuilderForLoader
                .conNombre("Lolapeluza")
                .conDescripcion("Potencial Hardcore se presenta al Lolapeluza con todo su rock punk no te lo podes perder")
                .conBandas(Arrays.asList(laRenga, potencial, etiliko))
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
                .conBandas(Arrays.asList(desorbitados, gondwana))
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
                .conBandas(Arrays.asList(amnecia, forasteros, laMississippi))
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
                .conBandas(Arrays.asList(demoledor))
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
                .conBandas(Arrays.asList(amnecia, forasteros, laMississippi))
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
                .conBandas(Arrays.asList(donCabot, laMississippi))
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
                .conBandas(Arrays.asList(banda, donCabot, etiliko))
                .conFecha(LocalDate.of(2020, 12, 16))
                .conHora(LocalTime.of(16, 00, 00))
                .conLocalidad("Banfield")
                .conDireccion("Rio bamba 2255")
                .conLugar("Centro cultural Maria Campo")
                .conImagen("http://www.chacofederal.com/galeria/recital0507.jpg")
                .conPrecio(0).build();

        Recital recitalDiez = RecitalBuilderForLoader
                .conNombre("Solventes de Todo")
                .conDescripcion("La legendaria banda del corurbano vuelve a los ecenarios de la mano con nuevo materia y vos no te lo podes perder.")
                .conBandas(Arrays.asList(laRenga))
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
                .conBandas(Arrays.asList(banda, forasteros, laMississippi))
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
                .conBandas(Arrays.asList(forasteros, laMississippi))
                .conFecha(LocalDate.of(2020, 05, 15))
                .conHora(LocalTime.of(21, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("almirante brown 662")
                .conLugar("La Barra")
                .conImagen("https://lh3.googleusercontent.com/proxy/H6iV9jvILKjgrKCjjgmXUCQ-fqBHDrpjZyWetvdd3ixfIhsDO2D9CHtIoTMC03dmSOfiwlObB00YrPDrm1Fz50mJe2bw0yG5OPBREYIYv5T5LqThrdOw9dLe")
                .conPrecio(0).build();

        Recital recitalTrece = RecitalBuilderForLoader
                .conNombre("Silencio del vacio")
                .conDescripcion("La legendaria banda de Valenti Alsina presenta su nuevo disco tocando en vivo para todos su seguidores. Entrada libre y gratuita")
                .conBandas(Arrays.asList(laKatana))
                .conFecha(LocalDate.of(2020, 10, 11))
                .conHora(LocalTime.of(20, 00, 00))
                .conLocalidad("Avellaneda")
                .conDireccion("Mitre 2245")
                .conLugar("El Catar")
                .conImagen("https://media.datachaco.com/adjuntos/244/imagenes/000/896/0000896826.jpg")
                .conPrecio(0).build();

        Recital recitalCatorce = RecitalBuilderForLoader
                .conNombre("Volátil")
                .conDescripcion("Volátil se presenta junto a grandes colegas del under local. No te lo podes perder")
                .conBandas(Arrays.asList(camus))
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
                .conBandas(Arrays.asList(demoledor, laMississippi))
                .conFecha(LocalDate.of(2020, 06, 22))
                .conHora(LocalTime.of(16, 30, 00))
                .conLocalidad("Lomas de Zamora")
                .conDireccion("Almirante brown 2258")
                .conLugar("Plaza Cerrano")
                .conImagen("https://blogmedia.evbstatic.com/wp-content/uploads/wpmulti/sites/31/2016/04/15130500/1dondeescucharmusicaenvivoenbuenosaires.jpg")
                .conPrecio(0).build();

        Recital recitalDieciSeis = RecitalBuilderForLoader
                .conNombre("Dementes")
                .conDescripcion("Hoy una noche de a puro rock y blues la Terraza. Tenemos show en vivo de Dementes, El concilio, La pavada, Ojos turbios. Los esperamos! Las mejores noches de rock están en La terraza")
                .conBandas(Arrays.asList(dementes))
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
