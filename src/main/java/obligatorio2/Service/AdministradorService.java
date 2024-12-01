package obligatorio2.Service;

import obligatorio2.Entity.AdministradorEntity;

import java.util.Optional;

public interface AdministradorService {
    AdministradorEntity save (AdministradorEntity administradorEntity);
    Optional<AdministradorEntity> getById(Integer id);

}
