package ar.edu.unq.circuito.vo;

import java.time.LocalDate;
import java.time.LocalTime;
import ar.edu.unq.circuito.model.Usuario;

public class IniciativaRecitalVo {
	
	private long id;
	private String nombre;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime hora;
    private String direccion;
    private String localidad;
    private String lugar;
    private int telefono;
    private BandaVo banda;
    private Usuario usuario;

    public IniciativaRecitalVo() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public BandaVo getBanda() {
		return banda;
	}

	public void setBanda(BandaVo banda) {
		this.banda = banda;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
