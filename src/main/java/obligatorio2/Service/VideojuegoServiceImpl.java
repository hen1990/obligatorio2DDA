package obligatorio2.Service;

import obligatorio2.Entity.VideojuegoEntity;
import obligatorio2.Repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VideojuegoServiceImpl implements VideojuegoService{

    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public VideojuegoEntity save (VideojuegoEntity videojuegoEntity) {
        String codigo;
        do {
            codigo = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        } while (videojuegoRepository.existsByCodigoUnico(codigo));

        videojuegoEntity.setCodigoUnico(codigo);
        return videojuegoRepository.save(videojuegoEntity);
    }

    public Optional<VideojuegoEntity> getById (Integer id) {
        return videojuegoRepository.findById(id);
    }

    public List<VideojuegoEntity> getAll () {
        return videojuegoRepository.findAll();
    }

}
