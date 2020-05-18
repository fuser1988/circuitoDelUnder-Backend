package ar.edu.unq.circuito.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unq.circuito.model.Recital;


public interface RecitalRepository extends JpaRepository<Recital, Long>{

	//SELECT a.* FROM recital a INNER JOIN (SELECT b.* FROM recital_bandas b INNER JOIN banda_generos c ON c.generos = 'ROCK' AND b.bandas_id = c.banda_id) d ON d.recital_id = a.id;
	@Query(value = "SELECT distinct a.* FROM recital a INNER JOIN recital_generos b ON a.id = b.recital_id AND b.generos LIKE %?1%", nativeQuery = true)
	List<Recital> findByGeneros(String genero);

	Optional<Recital> findById(Long id);

}
