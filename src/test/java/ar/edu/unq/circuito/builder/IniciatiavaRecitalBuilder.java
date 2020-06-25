package ar.edu.unq.circuito.builder;

import java.time.LocalDate;
import java.time.LocalTime;

import com.somospnt.test.builder.AbstractPersistenceBuilder;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.IniciativaRecital;

public class IniciatiavaRecitalBuilder extends AbstractPersistenceBuilder<IniciativaRecital>{

	private IniciatiavaRecitalBuilder() {
		
		instance = new IniciativaRecital();
		instance.setNombre("El Recital");
        instance.setDescripcion("nos volvemso a encontrar en laa roca bar para compartir una noche a puro rock");
        instance.setFecha(LocalDate.of(2018, 10, 30));
        instance.setHora(LocalTime.of(22, 00, 00));
        instance.setLocalidad("Quilmes");
        instance.setDireccion("almirante brown 662");
        instance.setLugar("La Barra");
        instance.setTelefono(123456);
	}
	
	public IniciatiavaRecitalBuilder conId(Long id) {
        instance.setId(id);
        return this;
    }
	
	public static IniciatiavaRecitalBuilder conNombre(String nombre) {
		IniciatiavaRecitalBuilder builder = new IniciatiavaRecitalBuilder();
		builder.instance.setNombre(nombre);
        return builder;
    }
	
	public IniciatiavaRecitalBuilder conDescripcion(String descripcion) {
        instance.setDescripcion(descripcion);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conFecha(LocalDate fecha) {
        instance.setFecha(fecha);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conHora(LocalTime hora) {
        instance.setHora(hora);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conLocalidad(String localidad) {
        instance.setLocalidad(localidad);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conLugar(String lugar) {
        instance.setLugar(lugar);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conDireccion(String direccion) {
        instance.setDireccion(direccion);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conTelefono(int telefono) {
        instance.setTelefono(telefono);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conBanda(Banda banda) {
        instance.setBanda(banda);
        return this;
    }
}
