package ar.edu.unq.circuito.builder;

import java.time.LocalDate;
import java.time.LocalTime;

import com.somospnt.test.builder.AbstractPersistenceBuilder;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.IniciativaRecital;

public class IniciatiavaRecitalBuilder extends AbstractPersistenceBuilder<IniciativaRecital>{

	private IniciatiavaRecitalBuilder() {
		
		instance = new IniciativaRecital();
		instance.setDescripcion("nos volvemso a encontrar en laa roca bar para compartir una noche a puro rock");
        instance.setFecha(LocalDate.of(2018, 10, 30));
        instance.setLocalidad("Quilmes");
        instance.setLugar("La Barra");
        instance.setTelefono(123456);
	}
	
	public IniciatiavaRecitalBuilder conId(Long id) {
        instance.setId(id);
        return this;
    }
		
	public static IniciatiavaRecitalBuilder conDescripcion(String descripcion) {
		IniciatiavaRecitalBuilder builder = new IniciatiavaRecitalBuilder();
		builder.instance.setDescripcion(descripcion);
        return builder;
    }
	
	public IniciatiavaRecitalBuilder conFecha(LocalDate fecha) {
        instance.setFecha(fecha);
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
	
	public IniciatiavaRecitalBuilder conTelefono(int telefono) {
        instance.setTelefono(telefono);
        return this;
    }
	
	public IniciatiavaRecitalBuilder conBanda(Banda banda) {
        instance.setBanda(banda);
        return this;
    }
}
