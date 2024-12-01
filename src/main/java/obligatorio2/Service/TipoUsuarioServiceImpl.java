package obligatorio2.Service;

import obligatorio2.Entity.TipoUsuarioEntity;
import obligatorio2.Repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuarioEntity save(TipoUsuarioEntity tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public Optional<TipoUsuarioEntity> getTipoUsuarioById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public List<TipoUsuarioEntity> getAll() {
        return tipoUsuarioRepository.findAll();
    }
}
