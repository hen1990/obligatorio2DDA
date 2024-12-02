package obligatorio2.Repository;

import obligatorio2.Entity.CompraVideojuegoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraVideojuegoRepository extends JpaRepository<CompraVideojuegoEntity, Integer> {

}
