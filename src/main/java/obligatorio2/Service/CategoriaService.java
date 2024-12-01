package obligatorio2.Service;

import obligatorio2.Entity.CategoriaEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    CategoriaEntity save (CategoriaEntity categoriaEntity);
    Optional<CategoriaEntity> getById (Integer id);
    List<CategoriaEntity> getAll ();
}
