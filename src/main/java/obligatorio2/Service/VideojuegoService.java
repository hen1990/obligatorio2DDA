package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.VideojuegoDTO;
import obligatorio2.Entity.VideojuegoEntity;

import java.util.List;
import java.util.Optional;

public interface VideojuegoService {
    VideojuegoEntity save (VideojuegoEntity videojuegoEntity);
    Optional<VideojuegoEntity> getById (Integer id);
    VideojuegoDTO getVideojuegoDTOById(Integer id);
    List<VideojuegoDTO> getAll ();
    void updateCantidadCopias(int id, int nuevaCantidad);

}
