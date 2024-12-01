package obligatorio2.Service;

import obligatorio2.Entity.AdministradorEntity;
import obligatorio2.Repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    @Autowired
    private AdministradorRepository administradorRepository;

    public AdministradorEntity save(AdministradorEntity administradorEntity) {
        return administradorRepository.save(administradorEntity);
    }
    public Optional<AdministradorEntity> getById (Integer id) {
        return administradorRepository.findById(id);
    }
}
