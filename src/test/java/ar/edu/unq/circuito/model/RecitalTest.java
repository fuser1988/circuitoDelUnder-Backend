package ar.edu.unq.circuito.model;

import java.util.Date;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class RecitalTest {
	
	@Test
	public void dadoUnRecitalCreadoVerificoSusDatos() {
		Recital recital1 = new Recital("Recital1","rock",new Date(),new Date(),"La Renga","La Viola","Quilmes","imagen",0); 
		
		assertThat(recital1.getNombre().equals("Recital1"), is(true));
		assertThat(recital1.getGeneros().equals("rock"), is(true));
		assertThat(recital1.getBandas().equals("La Renga"), is(true));
		assertThat(recital1.getNombreDeLugar().equals("La Viola"), is(true));
		assertThat(recital1.getImagen().equals("imagen"), is(true));
		assertThat(recital1.getPrecioDeEntrada() == 0);
		assertThat(recital1.getFechayHoraComienzoDeRecital() == new Date());
		assertThat(recital1.getFechaYHoraFinDeRecital() == new Date());
	}

}
