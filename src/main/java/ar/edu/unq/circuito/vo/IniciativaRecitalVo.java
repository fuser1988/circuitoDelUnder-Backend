package ar.edu.unq.circuito.vo;

import java.time.LocalDate;
import java.time.LocalTime;

public class IniciativaRecitalVo {

    private long id;
    private String descripcion;
    private LocalDate fecha;
    private String localidad;
    private String lugar;
    private int telefono;
    private BandaVo banda;
    private long usuarioId;

    public IniciativaRecitalVo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
