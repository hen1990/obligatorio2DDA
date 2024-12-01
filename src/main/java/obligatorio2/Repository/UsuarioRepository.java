package obligatorio2.Repository;

import obligatorio2.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
    boolean existsByEmail(String email);
    boolean findByEmailAndPassword(String email, String password);
}

