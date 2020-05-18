package ar.edu.unq.circuito.builder;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import com.somospnt.test.builder.AbstractPersistenceBuilder;
import java.util.Arrays;
import java.util.List;

public class BandaBuilder extends AbstractPersistenceBuilder<Banda> {

    private BandaBuilder() {

        instance = new Banda();
        instance.setNombre("El Banda");
        instance.setGeneros(Arrays.asList());
        instance.setInfo("somos una banda del sur de Buenos aires, hacemos rock");
        instance.setImagen("www.UnaUmagen.com/imagen");
    }

    public static BandaBuilder conNombre(String nombre) {
        BandaBuilder builder = new BandaBuilder();
        builder.instance.setNombre(nombre);
        return builder;
    }
    
    public BandaBuilder conGeneros(List<Genero> generos) {
    	BandaBuilder builder = new BandaBuilder();
        builder.instance.setGeneros(generos);
        return builder;
    }
    
    public BandaBuilder conInfo(String info) {
        instance.setInfo(info);
        return this;
    }
    
    public BandaBuilder conImagen(String info) {
        instance.setInfo(info);
        return this;
    }
/*
    public BandaBuilder conMaterial(List<Material> material) {
        instance.setMaterial(material);
        return this;
    }*/

}
