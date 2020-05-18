package ar.edu.unq.circuito.repo;

import ar.edu.unq.circuito.model.CodigoDeCuentaDeUsuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodigoDeCuentaDeUsuarioRepository extends JpaRepository<CodigoDeCuentaDeUsuario, Long>{ 

    Optional<CodigoDeCuentaDeUsuario> findByUsuarioId(long usuarioId);
                
}
