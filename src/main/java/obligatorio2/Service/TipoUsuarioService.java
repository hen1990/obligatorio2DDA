package obligatorio2.Service;

import obligatorio2.Entity.TipoUsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface TipoUsuarioService {
    TipoUsuarioEntity save(TipoUsuarioEntity tipoUsuario);
    Optional<TipoUsuarioEntity> getTipoUsuarioById(Integer id);
    List<TipoUsuarioEntity> getAll();
}
