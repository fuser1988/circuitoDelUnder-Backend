package ar.edu.unq.circuito.vo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class RecitalVo {

	private String nombre;
    private String descripcion;
    private List<BandaVo> bandas;
    private LocalDate fecha;
    private LocalTime hora;
    private String direccion;
    private String localidad;
    private String lugar;
    private String imagen;
    private int precio;
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<BandaVo> getBandas() {
		return bandas;
	}
	public void setBandas(List<BandaVo> bandas) {
		this.bandas = bandas;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
    
}