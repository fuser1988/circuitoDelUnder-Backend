package ar.edu.unq.circuito.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.circuito.model.Recital;
@Repository
public interface RecitalDao extends JpaRepository<Recital, Long>{
	
	List<Recital> findByGenero(String firstName);
}
