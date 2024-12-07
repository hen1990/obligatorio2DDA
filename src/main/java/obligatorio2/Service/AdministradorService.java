package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.UsuarioDTO;
import obligatorio2.Entity.AdministradorEntity;
import obligatorio2.Entity.UsuarioEntity;
import org.apache.coyote.BadRequestException;

import java.util.Optional;

public interface AdministradorService {
    AdministradorEntity save (AdministradorEntity administradorEntity);
    Optional<AdministradorEntity> getById(Integer id);
    AdministradorEntity login(AdministradorEntity administradorEntity) throws BadRequestException;

}
