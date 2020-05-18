package ar.edu.unq.circuito.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.edu.unq.circuito.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByReferenciaId(long idDeReferencia);

}
