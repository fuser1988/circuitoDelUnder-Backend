package ar.edu.unq.circuito.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unq.circuito.model.Banda;

public interface BandaRepository extends JpaRepository<Banda, Long> {

	Optional<Banda> findById(Long id);
	
	@Query(value = "SELECT DISTINCT b.* "
            + "FROM banda b "
            + "INNER JOIN  genero g  ON g.banda_id = b.id "
            + "AND g.nombre LIKE %?1%",
            countQuery = "SELECT COUNT(bg.*) "
            + "FROM (SELECT DISTINCT b.* FROM banda b "
            + "INNER JOIN  genero g  ON g.banda_id = b.id "
            + "AND g.nombre LIKE %?1%) bg ;",
            nativeQuery = true)
	Page<Banda> findByGeneros(String genero, Pageable pageable);
	
	@Query(value = "SELECT DISTINCT * "
			+ "FROM banda b WHERE LOWER(b.nombre) LIKE %?1%",
			countQuery = "SELECT COUNT(DISTINCT *) "
			+ "FROM banda b WHERE LOWER(b.nombre) LIKE %?1% ;",
            nativeQuery = true)
	Page<Banda> findByNombre(String nombre, Pageable pageable);
}
