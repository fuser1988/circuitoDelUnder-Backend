package ar.edu.unq.circuito.model;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "recital")
public class Recital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String nombre;
	
	private String genero;
	
	private Date fechayHoraComienzoDeRecital;

	private Date fechaYHoraFinDeRecital;

	private String bandas;

	private String nombreDeLugar;

	private String direccionDeLugar;

	private String imagen;

	private int precioDeEntrada;

	public Recital() {
		
	}
	
	public Recital(String nombre, String genero, Date fechayHoraComienzoDeRecital, Date fechaYHoraFinDeRecital,
			String bandas, String nombreDeLugar, String direccionDeLugar,String imagen, int precioDeEntrada) {
		this.nombre = nombre;
		this.genero = genero;
		this.fechayHoraComienzoDeRecital = new Date();
		this.fechaYHoraFinDeRecital = new Date();
		this.bandas = bandas;
		this.nombreDeLugar = nombreDeLugar;
		this.direccionDeLugar = direccionDeLugar;
		this.imagen = imagen;
		this.precioDeEntrada = precioDeEntrada;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechayHoraComienzoDeRecital() {
		/* pasar el formato a dia y hora.
		 * DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		hourdateFormat.format(fechayHoraComienzoDeRecital)*/
		return fechayHoraComienzoDeRecital;
	}

	public void setFechayHoraComienzoDeRecital(Date fechayHoraComienzoDeRecital) {
		this.fechayHoraComienzoDeRecital = fechayHoraComienzoDeRecital;
	}

	public Date getFechaYHoraFinDeRecital() {
		/*DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		hourdateFormat.format(fechaYHoraFinDeRecital)*/
		return fechaYHoraFinDeRecital;
	}

	public void setFechaYHoraFinDeRecital(Date fechaYHoraFinDeRecital) {
		this.fechaYHoraFinDeRecital = fechaYHoraFinDeRecital;
	}

	public String getBandas() {
		return bandas;
	}

	public void setBandas(String bandas) {
		this.bandas = bandas;
	}

	public String getNombreDeLugar() {
		return nombreDeLugar;
	}

	public void setNombreDeLugar(String nombreDeLugar) {
		this.nombreDeLugar = nombreDeLugar;
	}

	public String getDireccionDeLugar() {
		return direccionDeLugar;
	}

	public void setDireccionDeLugar(String direccionDeLugar) {
		this.direccionDeLugar = direccionDeLugar;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getPrecioDeEntrada() {
		return precioDeEntrada;
	}

	public void setPrecioDeEntrada(int precioDeEntrada) {
		this.precioDeEntrada = precioDeEntrada;
	}
	
}
