package ar.edu.unq.circuito.util;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.IniciativaRecital;
import ar.edu.unq.circuito.model.Material;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.model.TipoMaterial;
import ar.edu.unq.circuito.model.Ubicacion;
import ar.edu.unq.circuito.repo.BandaRepository;
import ar.edu.unq.circuito.repo.IniciativaRecitalRepository;
import ar.edu.unq.circuito.repo.RecitalRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    private RecitalRepository recitalRepository;
    private BandaRepository bandaRepository;
    private IniciativaRecitalRepository iniciativaRecitalRepository;

    @Autowired
    public DatabaseLoader(RecitalRepository recitalRepository, BandaRepository bandaRepository, IniciativaRecitalRepository iniciativaRecitalRepository) {
        this.recitalRepository = recitalRepository;
        this.bandaRepository = bandaRepository;
        this.iniciativaRecitalRepository = iniciativaRecitalRepository;
    }

    public void run(String... args) throws Exception {
        String ineptosLogo = ConversorDeArchivos.convertirABase64("images/IneptosLogo.jpg");
        String fokLogo = ConversorDeArchivos.convertirABase64("images/Fok Logo.jpg");
        String gritosLogo = ConversorDeArchivos.convertirABase64("images/GritosDe ProtestaLogo.jpg");
        String higadoLogo = ConversorDeArchivos.convertirABase64("images/HigadoValienteLogo.jpg");
        String laCautivaLogo = ConversorDeArchivos.convertirABase64("images/LaCautivaLogo.jpg");
        String lameloidesLogo = ConversorDeArchivos.convertirABase64("images/LameloidesLogo.jpg");
        String trampososLogo = ConversorDeArchivos.convertirABase64("images/LosTrampososLogo.jpg");
        String verdaderosLogo = ConversorDeArchivos.convertirABase64("images/LosVerdaderosLogo.jpg");
        String muffarinisLogo = ConversorDeArchivos.convertirABase64("images/MuffarinisLogo.jpg");
        String gronchosLogo = ConversorDeArchivos.convertirABase64("images/TheGronchosLogo.jpg");
        String sagradaLogo = ConversorDeArchivos.convertirABase64("images/Sagrada Logo.jpg");
        
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

        Material videoExplenden = new Material();
        videoExplenden.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoExplenden.setUrl("https://www.youtube.com/embed/4h18GNtqjcc");
        videoExplenden.setComentario("Tus pupilas- en plaza sanmartin");

        Material albumExplenden = new Material();
        albumExplenden.setTipoMaterial(TipoMaterial.TIPO_ALBUM);
        albumExplenden.setUrl("https://www.youtube.com/embed/9xtYdCX-CYI");
        albumExplenden.setComentario("Jardin de Omar- Disco 20014");
        List<Material> explendenMaterial = Arrays.asList(videoExplenden, albumExplenden);
        
        Material videoIneptos = new Material();
        videoIneptos.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoIneptos.setUrl("https://www.youtube.com/embed/-tvO2AvEPzc");
        videoIneptos.setComentario("Este es un demo que realizamos en diciembre del 2019 después de mucho tiempo sin grabar por la gira en el interior del país.");
        
        Material videoFok = new Material();
        videoFok.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoFok.setUrl("https://www.youtube.com/embed/CdF3s25DXro");
        videoFok.setComentario("Fok electro chongo- sos tan fácil - video oficial");

        Material videoGritos = new Material();
        videoGritos.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoGritos.setUrl("https://www.youtube.com/embed/1RG5gLb3SGE");
        videoGritos.setComentario("Este es nuestro primer sencillo grabado en la sala de El Peluca el 14 de diciembre 2019, en este tema reflejamos la necesidad de una fraternidad social y la unión.");

        Material videoHigado = new Material();
        videoHigado.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoHigado.setUrl("https://www.youtube.com/embed/DwJAHi-BHgY");
        videoHigado.setComentario("HÍGADO VALIENTE THRASH METAL LES PRESENTAMOS UN VÍDEO PARA TODOS LOS MALDITOS THRASHEROS RABIOSOS... NOCHE TÓXICA PARA USTEDES!!");

        Material videoCautiva = new Material();
        videoCautiva.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoCautiva.setUrl("https://www.youtube.com/embed/5ooxqGTMZaE");
        videoCautiva.setComentario("La Cautiva Rock & Roll – Esas cosas- tema hecho en septiembre del año 2008, grabado en el estudio de El Tano de Florencio Varela.");

        Material videoLameloide = new Material();
        videoLameloide.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoLameloide.setUrl("https://www.youtube.com/embed/T5Z5J2_si8Y");
        videoLameloide.setComentario("Este es nuestro primer sencillo grabado en la sala de El Peluca el 14 de diciembre 2019, en este tema reflejamos la necesidad de una fraternidad social y la unión. ");

        Material videoTramposos = new Material();
        videoTramposos.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoTramposos.setUrl("https://www.youtube.com/embed/swOTZYvJQz0");
        videoTramposos.setComentario("Primer tema del EP &quot;Casanova Open&quot; Grabado, mezclado y masterizado por Tomas Monari en el estudio La clinica.");

        Material videoVerdaderos = new Material();
        videoVerdaderos.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoVerdaderos.setUrl("https://www.youtube.com/embed/WJy33m7XQks");
        videoVerdaderos.setComentario("Los verdaderos, volver (full álbum) año 2006.");

        Material videoMuffarinis = new Material();
        videoMuffarinis.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoMuffarinis.setUrl("https://www.youtube.com/embed/lFdVisvUPvQ");
        videoMuffarinis.setComentario("En Vivo Mendoza Rock Café Cobertura de Compilado Punk Gasolero.");

        Material videoGronchos = new Material();
        videoGronchos.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoGronchos.setUrl("https://www.youtube.com/embed/QwrHCkVkXmE");
        videoGronchos.setComentario("The Gronchos - En Veremos (Videoclip)");

        Material videoSagrada = new Material();
        videoSagrada.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        videoSagrada.setUrl("https://www.youtube.com/embed/t4-VRZHImys");
        videoSagrada.setComentario("POR LAS CALLES - SRAGADA ETIOPIA PRODUCIDO Y DIRIGIDO POR @DEL_SUR_PRODUCCIONES FACEBOOK");

        Material materialManaco = new Material();
        materialManaco.setTipoMaterial(TipoMaterial.TIPO_VIDEO);
        materialManaco.setUrl("https://www.youtube.com/embed/D_v4-_TDxTs");
        materialManaco.setComentario("Show en vivo - Basta ya!");


        Banda ineptos = BandaBuilderForLoader.conNombre("INEPTOS").conInfo("INEPTOS es una banda de la zona oeste del conurbano bonaerense, después de 18 años de no tocar, a fines del año 2018, volvimos a juntarnos con las mismas ganas de hace 20 años atrás. INEPTOS somos Mauro, Alejandro, Pablo, Atilio y Danno.").conImagen("https://i.ibb.co/nk6810S/inepto-1.jpg").conGeneros(Arrays.asList(new Genero("HARDCORE"), new Genero("PUNK ROCK"))).conMaterial(Arrays.asList(videoIneptos)).build();
        Banda fok = BandaBuilderForLoader.conNombre("FOK").conInfo("Fok Electro chongo es la historia de un músico físicoculturista amante del Tecno-Pop, pero con dificultad para encontrar un cantante para su banda. Eso fue lo que me llevo a ser el cantante, soy un piano-man super musculoso con un notable oído para las melodías y las letras sensibles y/o con gracia. ").conImagen("https://i.ibb.co/X3bXjqW/Fok-Logo.jpg").conGeneros(Arrays.asList(new Genero("ROCK"),new Genero("ALTERNATIVO"), new Genero("PROGRESIVO"))).conMaterial(Arrays.asList(videoFok)).build();
        Banda gritos = BandaBuilderForLoader.conNombre("GRITOS DE PROTESTA").conInfo("Somos una Banda de punk protestante de un sonido crudo con letras en contra del sistema, la policía, toda autoridad y sobretodo una banda de amigos solidarios con las causas justas y la autogestión de los compañeros punk de toda Latinoamérica unida. ").conImagen("https://i.ibb.co/BV1Nhkw/Gritos-De-Protesta-Logo.jpg").conGeneros(Arrays.asList(new Genero("HARDCORE"), new Genero("PUNK"),new Genero("METAL"))).conMaterial(Arrays.asList(videoGritos)).build();
        Banda higado = BandaBuilderForLoader.conNombre("HIGADO VALIENTE").conInfo("Hígado valiente, banda thrash metal de Argentina Bs.As fundada en el 2009... Tenemos dos demo 2011 y 2013, después de tanta lucha en el ambiente del underground pudimos sacar este material para todos ustedes...").conImagen(higadoLogo).conGeneros(Arrays.asList(new Genero("METAL"),new Genero("NEW METAL"),new Genero("TRASH"),new Genero("HARDCORE"))).conMaterial(Arrays.asList(videoHigado)).build();
        Banda laCautiva = BandaBuilderForLoader.conNombre("LA CAUTIVA").conInfo("LA CAUTIVA banda de Rock, de zona sur de Bs.As. Más precisamente del partido de Fcio. Varela, que tuvo sus comienzos allá por el año 2000 y aun nos mantenemos con el mismo espíritu de rebeldía, recitales, amigos y la energía de siempre.").conImagen("https://i.ibb.co/nfCvvWx/La-Cautiva-Logo.jpg").conGeneros(Arrays.asList(new Genero("ROCK"),new Genero("ROCK AND ROLL"),new Genero("BLUEZ"))).conMaterial(Arrays.asList(videoCautiva)).build();
        Banda lameloides = BandaBuilderForLoader.conNombre("LAMELOIDES").conInfo("Banda formada en el 2013 en el conurbano de buenos aires, con 2 demos y 3 discos de estudio...Con un estilo punk, grunge, rock alternativo con letras de amor, odio y siempre en contra del opresor. Con LEO en voz, DAVID guitarra y coros, FEDE en la batería y MARTIN en bajo...ellos ya están trabajando en otro disco para el 2021.todo su material esta en las plataformas musicales.").conImagen("https://i.ibb.co/9mPSJvz/Lameloides-Logo.jpg").conGeneros(Arrays.asList(new Genero("ROCK"),new Genero("GRUNGE"),new Genero("PUNK"))).conMaterial(Arrays.asList(videoLameloide)).build();
        Banda tramposos = BandaBuilderForLoader.conNombre("LOS TRAMPOSOS").conInfo("Gordos, ebrios y viejos haciendo punk rock en el conurbano bonaerense.").conImagen("https://i.ibb.co/6HKdtGZ/Los-Tramposos-Logo.jpg").conGeneros(Arrays.asList(new Genero("PUNK ROCK"),new Genero("PUNK"),new Genero("ROCK"))).conMaterial(Arrays.asList(videoTramposos)).build();
        Banda verdaderos = BandaBuilderForLoader.conNombre("LOS VERDADEROS").conInfo("Los Verdaderos surgieron en San Martín, del desprendimiento de otra banda que tenía Mariano, su cantante, y hace 12 años que tocan por todos lados, todos los barrios y algunos lugares más lejanos como Brasil, Chile, y el interior del país.").conImagen("https://i.ibb.co/pvZJ4Fb/Los-Verdaderos-Logo.jpg").conGeneros(Arrays.asList(new Genero("PROGRSIVO"),new Genero("HARDCORE"),new Genero("METAL"))).conMaterial(Arrays.asList(videoVerdaderos)).build();
        Banda muffarinis = BandaBuilderForLoader.conNombre("MUFFARINIS").conInfo("Movimiento Musical Melodías simples de Compases Rápidos Anarquismo Autogestión Independencia Nihilismo.").conImagen("https://i.ibb.co/F6SSrgS/Muffarinis-Logo.jpg").conGeneros(Arrays.asList(new Genero("ROCK"),new Genero("PUNK ROCK"),new Genero("PUNK"))).conMaterial(Arrays.asList(videoMuffarinis)).build();
        Banda gronchos = BandaBuilderForLoader.conNombre("THE GRONCHOS").conInfo("somos una banda del sur de Buenos aires, hacemos PUNK ROCK").conImagen("https://i.ibb.co/pjcQTFX/The-Gronchos-Logo.jpg").conGeneros(Arrays.asList(new Genero("ROCK"),new Genero("PUNK ROcK"),new Genero("PUNK"))).conMaterial(Arrays.asList(videoGronchos)).build();
        Banda sagrada = BandaBuilderForLoader.conNombre("SAGRADA UTIOPIA").conInfo("La banda se formó en el 2009 y llevamos nuestra música por  toda la zona sur. Sin embargo, en el 2013 tuvimos un impase y se formaron otras bandas, “Del Barrio Reggae” y “Culto Fakari”; la separación no duró tanto y este año volvimos a reunirnos con la misma mística y pasión por el Reggae.").conImagen("https://i.ibb.co/zG4mtj2/sagrada-Logo.jpg").conGeneros(Arrays.asList(new Genero("ROCK"),new Genero("ALTERNATIVO"),new Genero("REGGAE"))).conMaterial(Arrays.asList(videoSagrada)).build();
        
        Banda banda = BandaBuilderForLoader.conNombre("MAÑACO").conInfo("Somos una Banda de Florencio Varela que hacemos Grincore. Nos gusta tocar en vivo y viajar para difundir nuestra musica. Mañaco MAÑACO hoy son:\n" +
            "MARIO:VOZ\n" +
            "MIDI: VOZ\n" +
            "GUSTY:VIOLA\n" +
            "NICO:VIOLA\n" +
            "ADRI:BAJO\n" +
            "FACU:BATERIA").conImagen("https://i.ibb.co/QJ6Gt5f/Manaco.jpg").conGeneros(Arrays.asList(new Genero("GRINCORE"),new Genero("HARDCORE"),new Genero("PUNK"))).conMaterial(Arrays.asList(materialManaco)).build();
        Banda elBanda = BandaBuilderForLoader.conNombre("Explenden").conInfo("EXPLENDEN se formó en enero del 2001, y originalmente la banda estaba integrada por amigos de la escuela que se reunían en Villa Urquiza por las tardes y las noches de aquel verano. La idea por aquel entonces fue hacer temas que siguieran la línea de las influencias musicales de sus integrantes: Mal Momento y Flema como referentes locales, y Ramones, Sex Pistols, Buzzcocks o La Polla Records desde el exterior, entre muchos otros.").conImagen("https://scontent.faep4-1.fna.fbcdn.net/v/t1.0-9/p960x960/68701583_2644002115632614_3536889436358836224_o.jpg?_nc_cat=110&_nc_sid=85a577&_nc_oc=AQnSRFnE1QVTAT6XzhbH_JtLyc4BV0SF5OHps2Rrij43a9yY9Qqpxx_SHbGhoxOMxynNcoTTB2Lh7RkYOQgfYoNy&_nc_ht=scontent.faep4-1.fna&_nc_tp=6&oh=d36589d0292d112e3bf15c3a47b468c9&oe=5F09F62C").conGeneros(Arrays.asList(new Genero("PUNK"), new Genero("PUNK_ROCK"), new Genero("ROCK"))).conMaterial(explendenMaterial).build();
        Banda aluminosis = BandaBuilderForLoader.conNombre("Aluminosis").conInfo("somos una banda española, hacemos rock").conImagen("https://gp1.wac.edgecastcdn.net/802892/http_public_production/artists/images/2331471/original/resize:600x600/crop:x44y48w516h386/aspect:1.0/hash:1467286589/1327535155_AGRO_2_BLANC_MODEL_2.JPG?1467286589").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda etiliko = BandaBuilderForLoader.conNombre("ETILIKO").conInfo("somos un grupo punk procedente de Salvatierra, País Vasco").conImagen("https://i.ytimg.com/vi/ct9Sz6PbCFE/hqdefault.jpg").conGeneros(Arrays.asList(new Genero("PUNK"))).conMaterial(Arrays.asList(videoEtiliko)).build();
        Banda potencial = BandaBuilderForLoader.conNombre("Potencial Hardcore").conInfo("somos una banda de Madrid, hacemos punk").conImagen("http://www.potencialhardcore.org/WebRoot/StoreES2/Shops/64798605/Styles/Fold[7]/logo.jpg").conGeneros(Arrays.asList(new Genero("PUNK"))).conMaterial(null).build();
        Banda desorbitados = BandaBuilderForLoader.conNombre("DESORBITADOS").conInfo("Desorbitados, una gran banda de reggae, algo diferente para los tiempos que corren").conImagen("https://res.cloudinary.com/plugmusix/image/upload/q_auto:good,c_fill,g_faces:center,h_400,w_1000/cnrptxbdfmple3ncgywn.png").conGeneros(Arrays.asList(new Genero("REGGAE"))).conMaterial(null).build();
        Banda gondwana = BandaBuilderForLoader.conNombre("GONDWANA").conInfo("Gondwana es un grupo musical de reggae chileno").conImagen("https://sites.google.com/site/reggaeenchile/_/rsrc/1370535858801/gondwana/gondwana.jpg").conGeneros(Arrays.asList(new Genero("REGGAE"))).conMaterial(null).build();
        Banda amnecia = BandaBuilderForLoader.conNombre("AMNECIA").conInfo("banda de blues").conImagen("http://www.amnesiabluesband.com/_Media/hailstone-front-cover_med-4.jpeg").conGeneros(Arrays.asList(new Genero("BLUES"))).conMaterial(null).build();
        Banda forasteros = BandaBuilderForLoader.conNombre("FORASTEROS").conInfo("somos un grupo olavarriense").conImagen("http://7400noticias.com.ar/wp-content/uploads/2015/09/forasteros3.jpg").conGeneros(Arrays.asList(new Genero("METAL"), new Genero("BLUES"))).conMaterial(null).build();
        Banda laMississippi = BandaBuilderForLoader.conNombre("La Mississippi").conInfo("La Mississippi Blues Band es una banda de blues rock argentino").conImagen("https://www.wipe.com.ar/imagenes/i4UViB4tyg3W1yVGDrrpEiee3plbJ6h3.jpg").conGeneros(Arrays.asList(new Genero("BLUES"))).conMaterial(null).build();
        Banda demoledor = BandaBuilderForLoader.conNombre("Demoledor").conInfo("somos una banda metalera de Florencio Varela").conImagen("https://www.miciudadrock.com.ar/media/cache/a5/7d/a57dc7ba0bcfd4f25767871a1fe377cd.jpg").conGeneros(Arrays.asList(new Genero("METAL"))).conMaterial(null).build();
        Banda donCabot = BandaBuilderForLoader.conNombre("Don Cabot").conInfo("es una banda de barrio que se formó en un espontaneo junte de músicos en busca de un espacio en la ruta del rock").conImagen("https://pbs.twimg.com/profile_images/778377437801541632/_FL9yvP3_400x400.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda laMocosa = BandaBuilderForLoader.conNombre(" La Mocosa").conInfo("La Mocosa es una banda de rock independiente formada en Buenos Aires durante el año 2000").conImagen("https://revistamutt.com/wp-content/uploads/2017/06/Gjira-7-1024x683.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda laKatana = BandaBuilderForLoader.conNombre("La Katana").conInfo("banda de rock").conImagen("https://i.ytimg.com/vi/WDe_VkCZEIs/maxresdefault.jpg").conGeneros(Arrays.asList(new Genero("METAL"))).conMaterial(null).build();
        Banda camus = BandaBuilderForLoader.conNombre("Camus").conInfo("somos una banda del sur de Buenos aires, hacemos rock").conImagen("http://www.laizquierdadiario.com/IMG/arton3346.jpg").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda dementes = BandaBuilderForLoader.conNombre("Dementes").conInfo("somos una banda de rock").conImagen("http://dementesska.es/wp-content/uploads/2016/01/footer-logo.png").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(null).build();
        Banda laRenga = BandaBuilderForLoader.conNombre("La Renga").conInfo("somos una banda del sur de Buenos aires, hacemos metal").conImagen("https://www.larenga.com/images/logo.png").conGeneros(Arrays.asList(new Genero("ROCK"))).conMaterial(Arrays.asList(videoLaRenga, albunRenga)).build();
        
        
        bandaRepository.save(ineptos);
        bandaRepository.save(gritos);
        bandaRepository.save(higado);
        bandaRepository.save(desorbitados);
        bandaRepository.save(laCautiva);
        bandaRepository.save(sagrada);
        bandaRepository.save(gronchos);
        bandaRepository.save(lameloides);
        bandaRepository.save(tramposos);
        bandaRepository.save(verdaderos);
        bandaRepository.save(muffarinis);
        bandaRepository.save(banda);
        bandaRepository.save(elBanda);
        bandaRepository.save(aluminosis);
        bandaRepository.save(etiliko);
        bandaRepository.save(potencial);
        bandaRepository.save(gondwana);
        bandaRepository.save(amnecia);
        bandaRepository.save(forasteros);
        bandaRepository.save(laMississippi);
        bandaRepository.save(demoledor);
        bandaRepository.save(donCabot);
        bandaRepository.save(laMocosa);
        bandaRepository.save(laKatana);
        bandaRepository.save(camus);
        bandaRepository.save(dementes);
        bandaRepository.save(laRenga);
        bandaRepository.save(fok);

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
                .conDescripcion("Hoy!! La convención de batman!!!! en solano...vengan altas bandas buena onda y sobretodo respeto mutuo. Vengan temprano primer banda 21 hs arranka...Traigan alimento para el comedor santillan.Los vemos mas tarde los espero!!")
                .conBandas(Arrays.asList(banda, gritos))
                .conFecha(LocalDate.of(2020, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("Av Ferrocaril Provincial 4005")
                .conLugar("Salon cultural SUDAKA")
                .conImagen("https://i.ibb.co/stxtM4G/batman.png")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.7797141,-58.320197)).build();

        Recital recitalDos = RecitalBuilderForLoader
                .conNombre("Aluminosis")
                .conDescripcion("Aluminosis se presenta con su nueva formación en Bar del Fondo, no te lo pierdas")
                .conBandas(Arrays.asList(aluminosis, etiliko, banda))
                .conFecha(LocalDate.of(2020, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("alvares tomas 2015")
                .conLugar("Bar del fondo")
                .conImagen("https://vudum.com.ar/wp-content/uploads/2018/06/DSC_8132-768x513.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.804382, -58.294734)).build();

        Recital recitalTres = RecitalBuilderForLoader
                .conNombre("Lolapeluza")
                .conDescripcion("Potencial Hardcore se presenta al Lolapeluza con todo su rock punk no te lo podes perder")
                .conBandas(Arrays.asList(potencial, elBanda))
                .conFecha(LocalDate.of(2020, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("San Isidro")
                .conDireccion("Bernabe marquez 800")
                .conLugar("Hipódromo de San Isidro")
                .conImagen("https://i.ibb.co/5cN7gWM/Lolapeluza.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.481620, -58.522587)).build();

        Recital recitalCuatro = RecitalBuilderForLoader
                .conNombre("REGGAE FOR EVER")
                .conDescripcion("DESORBITADOS se presenta para festejar su aniversario junto a los GONDWANA, en el Club Tucumán")
                .conBandas(Arrays.asList(desorbitados, gondwana))
                .conFecha(LocalDate.of(2020, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("Andres Baranda 941")
                .conLugar("Club Tucumán")
                .conImagen("https://pxb.cdn.0221.com.ar/0221/022019/1549635228344.jpg?x=18&y=95&width=1463&height=732&rotate=0&scaleX=1&scaleY=1&ow=1500&oh=964&&cw=1920&ch=950")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.725068, -58.269700)).build();

        Recital recitalCinco = RecitalBuilderForLoader
                .conNombre("Escuela de Blues")
                .conDescripcion("Hoy una noche de puro rock y Blues en La Barra. Tenemos show en vivo de AMNECIA, FORASTEROS, La Mississippi y ConurbanoBlues. Los esperamos! Las mejores noches de Rock están en La Barra")
                .conBandas(Arrays.asList(amnecia, forasteros, laMississippi))
                .conFecha(LocalDate.of(2020, 10, 30))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("almirante brown 662")
                .conLugar("La Barra")
                .conImagen("https://pxb.cdn.elchubut.com.ar/chubut/022020/1582235138036/Hoy%20terapia%2001.jpeg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.722511, -58.255382)).build();

        Recital recitalSeis = RecitalBuilderForLoader
                .conNombre("Furias del metal")
                .conDescripcion("Hoy Noche de Metal Argento en La Caldera. Se presenta Demoledor juto a Furias del metal. Los esperamos! Las mejores noches de Rock están en La Caldera")
                .conBandas(Arrays.asList(demoledor,higado))
                .conFecha(LocalDate.of(2020, 6, 22))
                .conHora(LocalTime.of(21, 00, 00))
                .conLocalidad("Avellaneda")
                .conDireccion("Mitre 2250")
                .conLugar("La caldera")
                .conImagen("http://cdn-d15c.kxcdn.com/contenidos/201904/2a53ef1d-6e6c-4b34-bc65-3f85e202f217.png")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.672205, -58.351802)).build();

        Recital recitalSiete = RecitalBuilderForLoader
                .conNombre("Las ex")
                .conDescripcion("Hoy una noche a puro Punk Rock en el Salón Pueyrredón. Las Ex presentan su nuevo disco en casa. No te lo pódes perder tocamos junto a bandas amigas, termina temprano y la entrada es gratuita.")
                .conBandas(Arrays.asList(amnecia, forasteros, laMississippi))
                .conFecha(LocalDate.of(2020, 8, 10))
                .conHora(LocalTime.of(20, 30, 00))
                .conLocalidad("Palermo")
                .conDireccion("Av. Santafe 2585")
                .conLugar("Salon Pueyrredón")
                .conImagen("https://video-images.vice.com/_uncategorized/1539281513314-Paltax.jpeg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.579117, -58.425141)).build();
        /*
        Recital recitalOcho = RecitalBuilderForLoader
                .conNombre("Don Cabot")
                .conDescripcion("Hoy una noche de a Rock and Roll  y blus en El faro. Gandes exponentes del rockandroll local se Presentan en El faro tu lugar")
                .conBandas(Arrays.asList(donCabot, laMississippi))
                .conFecha(LocalDate.of(2020, 7, 16))
                .conHora(LocalTime.of(23, 15, 00))
                .conLocalidad("Lanus")
                .conDireccion("Ortusar 6582")
                .conLugar("El faro")
                .conImagen("https://lh3.googleusercontent.com/proxy/Z_w7AOCOJdYNkYvBfzioLGDcGuE5bFzN-0PPkriGhbJaUufICCpsTFSSkHU8jB0DeRNfnxEOInQSALDGbePokayH13Zqr0sfGM0brntXvCv25Q")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.579117, -58.425141)).build();
        		
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
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.579117, -58.425141)).build();
         */
        Recital recitalDiez = RecitalBuilderForLoader
                .conNombre("Solventes de Todo")
                .conDescripcion("La legendaria banda del conurbano vuelve a los escenarios de la mano con nuevo material y vos no te lo podes perder.")
                .conBandas(Arrays.asList(laRenga))
                .conFecha(LocalDate.of(2020, 6, 16))
                .conHora(LocalTime.of(20, 30, 00))
                .conLocalidad("Solano")
                .conDireccion("San martin 2258")
                .conLugar("Sudaka")
                .conImagen("http://entreriosahora.com/wp-content/uploads/2019/06/rock-759x500.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.769387, -58.316998)).build();
        /*
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
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.769387, -58.316998)).build();
         */
        Recital recitalDoce = RecitalBuilderForLoader
                .conNombre("Incognitos de la noche")
                .conDescripcion("Hoy una noche de a puro Rock en La Barra. Show en vivo de INCOGNITOS DE LA NOCHE, FORASTEROS, La MISSISSIPPI y CONURBANO BLUES. Los esperamos! Las mejores noches de rock están en La Barra")
                .conBandas(Arrays.asList(forasteros, laMississippi))
                .conFecha(LocalDate.of(2020, 05, 15))
                .conHora(LocalTime.of(21, 00, 00))
                .conLocalidad("Quilmes")
                .conDireccion("almirante brown 662")
                .conLugar("La Barra")
                .conImagen("https://elpais.com/cultura/imagenes/2017/04/27/actualidad/1493298698_864661_1493301183_noticia_grande.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.722511, -58.255382)).build();

        Recital recitalTrece = RecitalBuilderForLoader
                .conNombre("Silencio del vacio")
                .conDescripcion("La legendaria banda de Valentín Alsina presenta su nuevo disco tocando en vivo para todos su seguidores. Entrada libre y gratuita")
                .conBandas(Arrays.asList(laKatana))
                .conFecha(LocalDate.of(2020, 10, 11))
                .conHora(LocalTime.of(20, 00, 00))
                .conLocalidad("Avellaneda")
                .conDireccion("Mitre 2226")
                .conLugar("Asociación Cultural y Folklórica Martín Fierro")
                .conImagen("https://media.datachaco.com/adjuntos/244/imagenes/000/896/0000896826.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.672135, -58.352027)).build();

        Recital recitalCatorce = RecitalBuilderForLoader
                .conNombre("Volatil")
                .conDescripcion("Volátil se presenta junto a grandes colegas del under local. No te lo podés perder")
                .conBandas(Arrays.asList(camus,laKatana))
                .conFecha(LocalDate.of(2020, 9, 21))
                .conHora(LocalTime.of(23, 00, 00))
                .conLocalidad("Burzaco")
                .conDireccion("Carlos Pellegrini 788")
                .conLugar("El Amparo")
                .conImagen("https://pbs.twimg.com/media/DGtg4VlXgAQqIkn?format=jpg&name=small")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.825670, -58.390322)).build();

        /*  Recital recitalQuince = RecitalBuilderForLoader
                .conNombre("Festival musical Todos por Juan")
                .conDescripcion("Gran festival musical 'Todos Por Juan' participa de esta campaña solidaria y apoya el rock independiente. Entrada un alimento no precedero")
                .conBandas(Arrays.asList(demoledor, laMississippi))
                .conFecha(LocalDate.of(2020, 06, 22))
                .conHora(LocalTime.of(16, 30, 00))
                .conLocalidad("Lomas de Zamora")
                .conDireccion("Almirante brown 2258")
                .conLugar("Plaza Cerrano")
                .conImagen("https://blogmedia.evbstatic.com/wp-content/uploads/wpmulti/sites/31/2016/04/15130500/1dondeescucharmusicaenvivoenbuenosaires.jpg")
                .conPrecio(0).build();*/
        Recital recitalDieciSeis = RecitalBuilderForLoader
                .conNombre("Dementes")
                .conDescripcion("Hoy una noche de puro Rock y Blues en la Terraza. Tenemos show en vivo de DEMENTES, El CONCILIO, LA PAVADA, OJOS TURBIOS. Los esperamos! Las mejores noches de Rock están en La Terraza")
                .conBandas(Arrays.asList(dementes ,banda))
                .conFecha(LocalDate.of(2020, 11, 20))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Berazategui")
                .conDireccion("Rocha 662")
                .conLugar("La Terraza")
                .conImagen("https://www.inforegion.com.ar/wp-content/uploads/2019/08/banda1200.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.770335, -58.244218)).build();

        Recital recitalDieciSiete = RecitalBuilderForLoader
                .conNombre("FESTI UNDER PUNK")
                .conDescripcion("Nos visita desde Santiago del estero la banda de “que se cague punk rock” vamos a estar tocando también con los amigos de los matados empieza a las 23:00hs la entrada es gratis y nos quedamos hasta que nos echen¡¡¡ av. corrientes 5008 villa crespo CABA.")
                .conBandas(Arrays.asList(ineptos))
                .conFecha(LocalDate.of(2020, 11, 20))
                .conHora(LocalTime.of(23, 00, 00))
                .conLocalidad("CABA")
                .conDireccion("Av. corrientes 5008")
                .conLugar("La Terraza")
                .conImagen("https://i.ibb.co/MMQhnXh/ineptos-2.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.6007489, -58.4385634)).build();
        
        Recital recitalDieciOcho = RecitalBuilderForLoader
                .conNombre("LA ERA DE LA REVELIÓN FEST")
                .conDescripcion("La era de la rebelión fest, domingo 22 de noviembre 17 hs av. Alsina 2030 (lomas de Zamora) entrada solo en puerta $40.")
                .conBandas(Arrays.asList(verdaderos))
                .conFecha(LocalDate.of(2020, 11, 22))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Lomas de Zamora")
                .conDireccion("Av. Alsina 2030")
                .conLugar("El lugarsito")
                .conImagen("https://i.ibb.co/HdC1N9F/los-verdaderos-2.jpg")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.7605256,-58.3982006)).build();

        Recital recitalDieciNueve = RecitalBuilderForLoader
                .conNombre("PUNK ROCK EN ZORBA!")
                .conDescripcion("EXPLENDEN - TUKERA - MALAS KOSTUMBRES - GRAN ESTAFA - METHRASHEROS en Zorba Rock, J.C. Paz , Hipolito Yrigoyen 1061. 22hs ENTRADAS EN PUERTA")
                .conBandas(Arrays.asList(elBanda))
                .conFecha(LocalDate.of(2021,02, 15))
                .conHora(LocalTime.of(22, 00, 00))
                .conLocalidad("Jose C. Paz")
                .conDireccion("Hipolito Yrigoyen 1061")
                .conLugar("ZORBA")
                .conImagen("https://scontent.faep4-1.fna.fbcdn.net/v/t1.0-9/51548680_2344366532262842_2882754827572477952_n.jpg?_nc_cat=105&_nc_sid=340051&_nc_eui2=AeF_AkGi_enSt_OVvAXfi3hqw2YqXC0E4BrDZipcLQTgGuD3svQ3pWpeO7H9FPRSHtx1_mFvlGvx8oZFqtqQrEv7&_nc_oc=AQmcWnkLLmnP5xCVBWUBrEar1DbJFFA8EPx0KrOiREWX3evadH0Ies9YU45LHoZ8Nqg&_nc_ht=scontent.faep4-1.fna&oh=5810f8e56600cb9beda12556556f099c&oe=5F2FCB4C")
                .conPrecio(0)
                .conUbicacion(new Ubicacion(-34.515336,-58.7460679)).build();

        recitalRepository.save(recitalUno);
        recitalRepository.save(recitalDos);
        recitalRepository.save(recitalTres);
        recitalRepository.save(recitalCuatro);
        recitalRepository.save(recitalCinco);
        recitalRepository.save(recitalSeis);
        recitalRepository.save(recitalSiete);
        //recitalRepository.save(recitalOcho);
        //recitalRepository.save(recitalNueve);
        recitalRepository.save(recitalDiez);
        //recitalRepository.save(recitalOnce);
        recitalRepository.save(recitalDoce);
        recitalRepository.save(recitalTrece);
        recitalRepository.save(recitalCatorce);
        //recitalRepository.save(recitalQuince);
        recitalRepository.save(recitalDieciSeis);
        recitalRepository.save(recitalDieciSiete);
        recitalRepository.save(recitalDieciOcho);
        recitalRepository.save(recitalDieciNueve);

        IniciativaRecital iniciativa1 = new IniciativaRecitalBuilderForLoader()
                .conDescripcion("Buenas colegas, estamos organizando una fechita en la cobacha Burzaco, un bar chiquito pero amistoso, podemos tocar hasta 4 bandas, el sonido corre por cuenta de el lugar, pero las bandas se encargarían del resto.")
                .conBanda(ineptos)
                .conFecha(LocalDate.of(2020, 9, 18))
                .conLocalidad("Burzaco")
                .conTelefono(1135781400)
                .conLugar("La Terraza").build();

        IniciativaRecital iniciativa2 = new IniciativaRecitalBuilderForLoader()
                .conDescripcion("Hay un bar en Berazategui que se llama La Terraza que no les cobran a las bandas por tocar. El único detalle es que las bandas que tocan tienen que poner el sonido y los instrumentos. Pueden tocar hasta 4 bandas. La idea es hacer una fecha Punk y Metal")
                .conBanda(banda)
                .conFecha(LocalDate.of(2020, 11, 20))
                .conLocalidad("Berazategui")
                .conTelefono(1135781400)
                .conLugar("La Terraza").build();

        iniciativaRecitalRepository.save(iniciativa1);
        iniciativaRecitalRepository.save(iniciativa2);

    }

}
