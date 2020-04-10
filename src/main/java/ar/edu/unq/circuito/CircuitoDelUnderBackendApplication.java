package ar.edu.unq.circuito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.repo.RecitalDao;

@SpringBootApplication
public class CircuitoDelUnderBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CircuitoDelUnderBackendApplication.class);
		RecitalDao repository = context.getBean(RecitalDao.class);

        // Guardar un conjunto de recitales
		Recital r = new Recital("La Renga");
		Recital r2 = new Recital("lollapalooza");
		repository.save(r);
		repository.save(r2);
        context.close();
    }

}
