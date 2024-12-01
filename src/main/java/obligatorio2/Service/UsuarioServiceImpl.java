package obligatorio2.Service;

import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Repository.UsuarioRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        return usuarioRepository.save(usuarioEntity);
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public Optional<UsuarioEntity> getById (Integer id) {
        return usuarioRepository.findById(id);
    }

    public List<UsuarioEntity> getAll() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioEntity> login(UsuarioEntity usuarioEntity) throws BadRequestException {
        if(usuarioRepository.findByEmailAndPassword(usuarioEntity.getEmail(), usuarioEntity.getPassword())){
            return usuarioRepository.findById(usuarioEntity.getId());
        }
        throw new BadRequestException("Credenciales incorrectas");
    }

}
