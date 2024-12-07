package obligatorio2.Repository;

import obligatorio2.Entity.AdministradorEntity;
import obligatorio2.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Integer> {
    Optional<AdministradorEntity> findByEmailAndPassword(String email, String password);
}
