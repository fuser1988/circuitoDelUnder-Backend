package ar.edu.unq.circuito.util;

import ar.edu.unq.circuito.model.Genero;
import ar.edu.unq.circuito.model.Recital;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RecitalBuilder {
    private Long id;
    private String nombre;
    private String descripcion;
    private List<String> bandas;
    private LocalDate fecha;
    private LocalTime hora;
    private List<Genero> generos;
    private String direccion;
    private String localidad;
    private String lugar;
    private String imagen;
    private int precio;
    
    public Recital build(){
        Recital recital = new Recital();
        recital.setNombre(nombre);
        recital.setDescripcion(descripcion);
        recital.setBandas(bandas);
        recital.setFecha(fecha);
        recital.setHora(hora);
        recital.setGeneros(generos);
        recital.setDireccion(direccion);
        recital.setLocalidad(localidad);
        recital.setLugar(lugar);
        recital.setImagen(imagen);
        recital.setPrecio(precio);
        return recital;
    }
    
    public RecitalBuilder conId(Long id) {
        this.id = id; 
        return this;
    }
    
    public static RecitalBuilder conNombre(String nombre) {
        RecitalBuilder builder = new RecitalBuilder(); 
        builder.nombre = nombre;
        return builder;
    }
    
    public RecitalBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public RecitalBuilder conBandas(List<String> bandas) {
        this.bandas = bandas;
        return this;
    }
    
    public RecitalBuilder conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }
    
    public RecitalBuilder conHora(LocalTime hora) {
        this.hora = hora;
        return this;
    }
    
    public RecitalBuilder conGeneros(List<Genero> generos) {
        this.generos = generos;
        return this;
    }
    
    public RecitalBuilder conLocalidad(String localidad) {
        this.localidad = localidad;
        return this;
    }
    
    public RecitalBuilder conLugar(String lugar) {
        this.lugar = lugar;
        return this;
    }
    
    public RecitalBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }
    
    public RecitalBuilder conImagen(String imagen) {
        this.imagen = imagen;
        return this;
    }
    
    public RecitalBuilder conPrecio(int precio) {
        this.precio = precio;
        return this;
    }
}