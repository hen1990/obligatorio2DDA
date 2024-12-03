package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.UsuarioDTO;
import obligatorio2.Entity.UsuarioEntity;
import org.apache.coyote.BadRequestException;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    boolean existsByEmail(String email);
    UsuarioDTO save(UsuarioEntity usuarioEntity);
    UsuarioDTO getById (Integer id);
    List<UsuarioDTO> getAll();
    void deleteUsuario (Integer id);
    UsuarioDTO login(UsuarioEntity usuarioEntity) throws BadRequestException;
}
