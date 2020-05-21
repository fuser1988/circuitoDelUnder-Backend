package ar.edu.unq.circuito.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unq.circuito.model.Recital;


public interface RecitalRepository extends JpaRepository<Recital, Long>{

	@Query(value = "SELECT distinct r.* "
                        + "FROM recital r "
                        + "INNER JOIN recital_bandas c ON r.id = c.recital_id "
                        + "INNER JOIN  banda b  ON c.bandas_id = b.id "
                        + "INNER JOIN  genero g  ON g.banda_id = b.id "
                        + "AND g.nombre LIKE %?1% ;"
                        , nativeQuery = true)
	List<Recital> findByGeneros(String genero);

	Optional<Recital> findById(Long id);

}
