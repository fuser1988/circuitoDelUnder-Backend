package ar.edu.unq.circuito.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unq.circuito.model.Recital;


public interface RecitalRepository extends JpaRepository<Recital, Long>{

	@Query(value = "SELECT DISTINCT a.* FROM recital a INNER JOIN (SELECT b.* FROM recital_bandas b INNER JOIN banda_generos c ON c.generos LIKE %?1% AND b.bandas_id = c.banda_id) d ON d.recital_id = a.id", nativeQuery = true)
	List<Recital> findByGeneros(String genero);

	Optional<Recital> findById(Long id);

}
