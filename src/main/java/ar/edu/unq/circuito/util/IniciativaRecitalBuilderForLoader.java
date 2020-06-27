package ar.edu.unq.circuito.util;

import java.time.LocalDate;
import java.time.LocalTime;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.IniciativaRecital;

public class IniciativaRecitalBuilderForLoader {
	private long id;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private String direccion;
    private String localidad;
    private String lugar;
    private int telefono;
    private Banda banda;
    
    public IniciativaRecital build() {
    	IniciativaRecital iniciativa = new IniciativaRecital();
    	iniciativa.setDescripcion(descripcion);
    	iniciativa.setFecha(fecha);
    	iniciativa.setHora(hora);
    	iniciativa.setDireccion(direccion);
    	iniciativa.setLocalidad(localidad);
    	iniciativa.setLugar(lugar);
    	iniciativa.setTelefono(telefono);
    	iniciativa.setBanda(banda);
    	return iniciativa;
    }
    
    public IniciativaRecitalBuilderForLoader conId(Long id) {
        this.id = id;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conFecha(LocalDate fecha) {
        this.fecha = fecha;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conHora(LocalTime hora) {
        this.hora = hora;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conLocalidad(String localidad) {
        this.localidad = localidad;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conLugar(String lugar) {
        this.lugar = lugar;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
    }
	
	public IniciativaRecitalBuilderForLoader conTelefono(int telefono) {
        this.telefono = telefono;
        return this;
    }
	
	public IniciativaRecitalBuilderForLoader conBanda(Banda banda) {
        this.banda = banda;
        return this;
    }

}
