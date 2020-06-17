package ar.edu.unq.circuito.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unq.circuito.model.Recital;
import ar.edu.unq.circuito.model.Ubicacion;

public interface RecitalRepository extends JpaRepository<Recital, Long> {

    @Query(value = "SELECT DISTINCT r.* "
            + "FROM recital r "
            + "INNER JOIN recital_bandas c ON r.id = c.recital_id "
            + "INNER JOIN  banda b  ON c.bandas_id = b.id "
            + "INNER JOIN  genero g  ON g.banda_id = b.id "
            + "AND g.nombre LIKE %?1%",
           countQuery = "SELECT COUNT(rg.*) "
            + "FROM (SELECT DISTINCT r.* FROM recital r "
            + "INNER JOIN recital_bandas c ON r.id = c.recital_id "
            + "INNER JOIN  banda b  ON c.bandas_id = b.id "
            + "INNER JOIN  genero g  ON g.banda_id = b.id "
            + "AND g.nombre LIKE %?1%) rg;",
           nativeQuery = true)
    Page<Recital> findByGeneros(String genero, Pageable pageable);

    Optional<Recital> findById(Long id);

    @Query(value = "SELECT * FROM recital r "
    		+ "ORDER BY "
    		+ "((abs(r.latitud - (?1))) + ((abs(r.longitud - (?2))))) "
    		+ "ASC",
           countQuery = "SELECT COUNT(ru.*) FROM " 
            + "(SELECT * FROM recital r "
    		+ "ORDER BY "
    		+ "((abs(r.latitud - (?1))) + ((abs(r.longitud - (?2))))) "
    		+ "ASC) ru;",
           nativeQuery = true)
	Page<Recital> findByUbicacion(double latitud, double longitud, Pageable pageable);

}
