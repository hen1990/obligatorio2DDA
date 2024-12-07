package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.UsuarioDTO;
import obligatorio2.Entity.AdministradorEntity;
import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Repository.AdministradorRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public AdministradorEntity save(AdministradorEntity administradorEntity) {
        administradorEntity.setRol("admin");
        return administradorRepository.save(administradorEntity);
    }
    public Optional<AdministradorEntity> getById (Integer id) {
        return administradorRepository.findById(id);
    }

    public AdministradorEntity login(AdministradorEntity administradorEntity) throws BadRequestException {
        Optional<AdministradorEntity> administrador = administradorRepository.findByEmailAndPassword(
                administradorEntity.getEmail(),
                administradorEntity.getPassword()
        );

        if (administrador.isPresent()) {
            return administrador.get();
        } else {
            throw new BadRequestException("Credenciales incorrectas");
        }
    }
}
