package ar.edu.unq.circuito.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion implements Serializable {

    private double latitud;
    private double longitud;

    public Ubicacion() {

    }

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

}
