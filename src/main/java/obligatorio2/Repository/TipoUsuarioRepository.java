package obligatorio2.Repository;

import obligatorio2.Entity.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Integer> {
    TipoUsuarioEntity findById(int id);
}
