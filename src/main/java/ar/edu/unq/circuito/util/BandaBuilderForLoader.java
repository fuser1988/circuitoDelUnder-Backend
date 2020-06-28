package ar.edu.unq.circuito.util;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Material;
import java.util.List;

public class BandaBuilderForLoader {

    private Long id;
    private String nombre;
    private List<Genero> generos;
    private String imagen;
    private String info;
    private List<Material> material;

    public Banda build() {
        Banda banda = new Banda();
        banda.setNombre(nombre);
        banda.setInfo(info);
        banda.setImagen(imagen);
        banda.setGeneros(generos);
        banda.setMaterial(material);
        return banda;
    }

    public BandaBuilderForLoader conId(Long id) {
        this.id = id;
        return this;
    }

    public static BandaBuilderForLoader conNombre(String nombre) {
        BandaBuilderForLoader builder = new BandaBuilderForLoader();
        builder.nombre = nombre;
        return builder;
    }

    public BandaBuilderForLoader conInfo(String info) {
        this.info = info;
        return this;
    }

    public BandaBuilderForLoader conGeneros(List<Genero> generos) {
        this.generos = generos;
        return this;
    }

    public BandaBuilderForLoader conImagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public BandaBuilderForLoader conMaterial(List<Material> material) {
        this.material = material;
        return this;
    }
}
