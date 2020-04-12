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
		SpringApplication.run(CircuitoDelUnderBackendApplication.class, args);
    }

}
