package ar.edu.unq.circuito.model;

import javax.persistence.Embeddable;

@Embeddable
public class Genero {

    private String genero;

    public Genero(String Genero) {
        this.genero = Genero;
    }

    public Genero() {
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String Genero) {
        this.genero = Genero;
    }

}
