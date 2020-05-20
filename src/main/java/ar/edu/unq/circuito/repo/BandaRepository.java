package ar.edu.unq.circuito.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.edu.unq.circuito.model.Banda;
import ar.edu.unq.circuito.model.Recital;

public interface BandaRepository extends JpaRepository<Banda, Long> {

	Optional<Banda> findById(Long id);
}
