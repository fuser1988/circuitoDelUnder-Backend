package ar.edu.unq.circuito.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.circuito.model.Recital;


public interface RecitalRepository extends JpaRepository<Recital, Long>{

	List<Recital> findByGeneros(String genero);

}
