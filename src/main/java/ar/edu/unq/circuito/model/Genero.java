package ar.edu.unq.circuito.model;

import javax.persistence.Embeddable;

@Embeddable
public class Genero {

    private String nombre;

    public Genero(String Genero) {
        this.nombre = Genero;
    }

    public Genero() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Genero) {
        this.nombre = Genero;
    }

}
