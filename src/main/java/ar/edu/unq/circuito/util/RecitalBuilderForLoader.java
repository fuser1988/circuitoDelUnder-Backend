package ar.edu.unq.circuito.util;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.model.Ubicacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RecitalBuilderForLoader {

    private Long id;
    private String nombre;
    private String descripcion;
    private List<Banda> bandas;
    private LocalDate fecha;
    private LocalTime hora;
    private String direccion;
    private String localidad;
    private String lugar;
    private String imagen;
    private int precio;
    private Ubicacion ubicacion;

    public Recital build() {
        Recital recital = new Recital();
        recital.setNombre(nombre);
        recital.setDescripcion(descripcion);
        recital.setBandas(bandas);
        recital.setFecha(fecha);
        recital.setHora(hora);
        recital.setDireccion(direccion);
        recital.setLocalidad(localidad);
        recital.setLugar(lugar);
        recital.setImagen(imagen);
        recital.setPrecio(precio);
        recital.setUbicacion(ubicacion);
        return recital;
    }

    public RecitalBuilderForLoader conId(Long id) {
        this.id = id;
        return this;
    }

    public static RecitalBuilderForLoader conNombre(String nombre) {
        RecitalBuilderForLoader builder = new RecitalBuilderForLoader();
        builder.nombre = nombre;
        return builder;
    }

    public RecitalBuilderForLoader conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public RecitalBuilderForLoader conBandas(List<Banda> bandas) {
        this.bandas = bandas;
        return this;
    }

    public RecitalBuilderForLoader conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }

    public RecitalBuilderForLoader conHora(LocalTime hora) {
        this.hora = hora;
        return this;
    }

    public RecitalBuilderForLoader conLocalidad(String localidad) {
        this.localidad = localidad;
        return this;
    }

    public RecitalBuilderForLoader conLugar(String lugar) {
        this.lugar = lugar;
        return this;
    }

    public RecitalBuilderForLoader conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public RecitalBuilderForLoader conImagen(String imagen) {
        this.imagen = imagen;
        return this;
    }

    public RecitalBuilderForLoader conPrecio(int precio) {
        this.precio = precio;
        return this;
    }

    public RecitalBuilderForLoader conUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }
}
