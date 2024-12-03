package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.EntitiesDTOs.VideojuegoDTO;
import obligatorio2.Entity.CompraVideojuegoEntity;
import obligatorio2.Entity.VideojuegoEntity;
import obligatorio2.Repository.CompraRepository;
import obligatorio2.Repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VideojuegoServiceImpl implements VideojuegoService{

    @Autowired
    private VideojuegoRepository videojuegoRepository;
    @Autowired
    private CompraRepository compraRepository;

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

    public VideojuegoDTO getVideojuegoDTOById (Integer id) {
        Optional<VideojuegoEntity> videojuego = videojuegoRepository.findById(id);
        List<CompraDTO> compraDTOList = new ArrayList<>();

        if (videojuego.isPresent()) {
            VideojuegoDTO videojuegoDTO = new VideojuegoDTO(
                    videojuego.get().getId(),
                    videojuego.get().getCodigoUnico(),
                    videojuego.get().getNombre(),
                    videojuego.get().getDescripcion(),
                    videojuego.get().getPrecio(),
                    videojuego.get().getImagen(),
                    videojuego.get().getCantidadCopias(),
                    videojuego.get().getCategoria(),
                    compraDTOList
            );
            return videojuegoDTO;
        }
        return null;
    }

    public List<VideojuegoDTO> getAll () {
        List<VideojuegoEntity> videojuegoEntityList = videojuegoRepository.findAll();
        List<VideojuegoDTO> videojuegoDTOList = new ArrayList<>();

        for (VideojuegoEntity videojuego : videojuegoEntityList) {
            List<CompraDTO> compraDTOList = new ArrayList<>();

            VideojuegoDTO videojuegoDTO = new VideojuegoDTO(
                    videojuego.getId(),
                    videojuego.getCodigoUnico(),
                    videojuego.getNombre(),
                    videojuego.getDescripcion(),
                    videojuego.getPrecio(),
                    videojuego.getImagen(),
                    videojuego.getCantidadCopias(),
                    videojuego.getCategoria(),
                    compraDTOList
            );
            videojuegoDTOList.add(videojuegoDTO);
        }
        return videojuegoDTOList;
    }

    public void updateCantidadCopias(int id, int cantidad) {
        Optional<VideojuegoEntity> videojuego = videojuegoRepository.findById(id);
        if (videojuego.isPresent()) {
            videojuego.get().setCantidadCopias(videojuego.get().getCantidadCopias() - cantidad);
            videojuegoRepository.save(videojuego.get());
        }
    }
}
