package obligatorio2.Repository;

import obligatorio2.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    boolean existsByEmail(String email);
    Optional<UsuarioEntity> findByEmailAndPassword(String email, String password);
}

