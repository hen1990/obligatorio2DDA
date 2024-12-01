package obligatorio2.Repository;

import obligatorio2.Entity.VideojuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideojuegoRepository extends JpaRepository<VideojuegoEntity, Integer> {
    boolean existsByCodigoUnico(String codigo);

}
