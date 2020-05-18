package ar.edu.unq.circuito.builder;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Recital;
import com.somospnt.test.builder.AbstractPersistenceBuilder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class RecitalBuilder extends AbstractPersistenceBuilder<Recital> {

    private RecitalBuilder() {

        instance = new Recital();
        instance.setNombre("El Recital");
        instance.setDescripcion("nos volvemso a encontrar en laa roca bar para compartir una noche a puro rock");
        instance.setBandas(Arrays.asList());
        instance.setFecha(LocalDate.of(2018, 10, 30));
        instance.setHora(LocalTime.of(22, 00, 00));
        instance.setDireccion("Mitre 2154");
        instance.setLocalidad("Berazategui");
        instance.setLugar("Bar Del Fondo");
        instance.setImagen("www.UnaUmagen.com/imagen");
        instance.setPrecio(0);
    }

    public RecitalBuilder conId(Long id) {
        instance.setId(id);
        return this;
    }

    public static RecitalBuilder conNombre(String nombre) {
        RecitalBuilder builder = new RecitalBuilder();
        builder.instance.setNombre(nombre);
        return builder;
    }

    public RecitalBuilder conDescripcion(String descripcion) {
        instance.setDescripcion(descripcion);
        return this;
    }

    public RecitalBuilder conBandas(List<Banda> bandas) {
        instance.setBandas(bandas);
        return this;
    }

    public RecitalBuilder conFecha(LocalDate fecha) {
        instance.setFecha(fecha);
        return this;
    }

    public RecitalBuilder conHora(LocalTime hora) {
        instance.setHora(hora);
        return this;
    }

    public RecitalBuilder conLocalidad(String localidad) {
        instance.setLocalidad(localidad);
        return this;
    }

    public RecitalBuilder conLugar(String lugar) {
        instance.setLugar(lugar);
        return this;
    }

    public RecitalBuilder conDireccion(String direccion) {
        instance.setDireccion(direccion);
        return this;
    }

    public RecitalBuilder conImagen(String imagen) {
        instance.setImagen(imagen);
        return this;
    }

    public RecitalBuilder conPrecio(int precio) {
        instance.setPrecio(precio);
        return this;
    }
}
