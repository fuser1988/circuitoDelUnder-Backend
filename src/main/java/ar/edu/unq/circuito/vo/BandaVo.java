package ar.edu.unq.circuito.vo;

import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Material;
import ar.edu.unq.circuito.model.Usuario;
import java.util.List;

public class BandaVo {
    
    private String nombre;
    private List<String> generos;
    private String imagen;
    private String info;
    private List<Material> material;
    private long usuarioId;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Material> getMaterial() {
        return material;
    }

    public void setMaterial(List<Material> material) {
        this.material = material;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    
}
