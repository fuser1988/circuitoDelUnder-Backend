package ar.edu.unq.circuito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalDao;
import ar.edu.unq.circuito.service.RecitalServiceImpl;

@SpringBootApplication
public class CircuitoDelUnderBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CircuitoDelUnderBackendApplication.class);
		RecitalServiceImpl service = context.getBean(RecitalServiceImpl.class);

        // Guardar un conjunto de recitales
		Recital r = new Recital("La Renga");
		Recital r2 = new Recital("lollapalooza");
		Recital r3 = new Recital("Soda Stereo");
		service.guardar(r);
		service.guardar(r2);
		service.guardar(r3);
		context.close();
    }

}
