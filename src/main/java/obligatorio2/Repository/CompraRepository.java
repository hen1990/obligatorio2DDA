package obligatorio2.Repository;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.Entity.CompraEntity;
import obligatorio2.Entity.CompraVideojuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<CompraEntity, Integer> {
    List<CompraEntity> getByUsuarioId (Integer id);
}
