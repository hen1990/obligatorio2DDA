package obligatorio2.Service;

import obligatorio2.Entity.UsuarioEntity;
import org.apache.coyote.BadRequestException;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    boolean existsByEmail(String email);
    UsuarioEntity save(UsuarioEntity usuarioEntity);
    Optional<UsuarioEntity> getById (Integer id);
    List<UsuarioEntity> getAll();
    Optional<UsuarioEntity> login(UsuarioEntity usuarioEntity) throws BadRequestException;

}
