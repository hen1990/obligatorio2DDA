package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.EntitiesDTOs.VideojuegoDTO;
import obligatorio2.Entity.CompraEntity;
import obligatorio2.Entity.CompraVideojuegoEntity;
import obligatorio2.Repository.CompraRepository;
import obligatorio2.Repository.CompraVideojuegoRepository;
import obligatorio2.Repository.VideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private CompraVideojuegoRepository compraVideojuegoRepository;
    @Autowired
    private VideojuegoRepository videojuegoRepository;

    public CompraEntity save(CompraEntity compraEntity) {
        CompraEntity compra = compraRepository.save(compraEntity);

        //Se guarda en la base de datos cada compraVideojuego
        for (CompraVideojuegoEntity compraVideojuego : compraEntity.getCompraVideojuegoEntityList()) {
            compraVideojuego.setCompra(compra);
            compraVideojuegoRepository.save(compraVideojuego);
        }
        return compra;
    }

    public Optional<CompraEntity> getById(Integer id) {
        return compraRepository.findById(id);
    }

    public CompraDTO getCompraDTOById(Integer id) {
        try {
            Optional<CompraEntity> compra = compraRepository.findById(id);

            List<CompraVideojuegoEntity> compraVideojuegoEntityList = compra.get().getCompraVideojuegoEntityList();
            List<VideojuegoDTO> videojuegoDTOList = getVideojuegoDTOS(compra.get());

            return new CompraDTO(compra.get().getUsuario().getId(), compra.get().getFechaCompra(), compra.get().getTotalCompra(), videojuegoDTOList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CompraDTO> getByUsuarioId (Integer id){
        List<CompraEntity> compraEntityList = compraRepository.getByUsuarioId(id);
        List<CompraDTO> compraDTOList = new ArrayList<>();

        //Convierto Compra => CompraDTO / videojuego => videojuegoDTO
        for (CompraEntity compraEntity : compraEntityList) {
            List<VideojuegoDTO> videojuegosCompraDTOList = new ArrayList<>();
            for (CompraVideojuegoEntity videojuegoEntity : compraEntity.getCompraVideojuegoEntityList()) {
                VideojuegoDTO videojuegoDTO = new VideojuegoDTO(
                        videojuegoEntity.getId(),
                        videojuegoEntity.getCantidad()
                );
                videojuegosCompraDTOList.add(videojuegoDTO);
            }

            //Creo CompraDTO
            CompraDTO compraDTO = new CompraDTO(
                    compraEntity.getUsuario().getId(),
                    compraEntity.getFechaCompra(),
                    compraEntity.getTotalCompra(),
                    videojuegosCompraDTOList
            );

            compraDTOList.add(compraDTO);
        }
        return compraDTOList;
    }

    public List<CompraEntity> getAll() {
        return compraRepository.findAll();
    }

    public List<CompraDTO> getAllCompraDTO() {
        List<CompraDTO> compraDTOList = new ArrayList<>();
        List<CompraEntity> compraEntityList = getAll();
        for (CompraEntity compra : compraEntityList) {
            int usuarioId = compra.getUsuario().getId();
            List<VideojuegoDTO> videojuegoDTOList = getVideojuegoDTOS(compra);

            CompraDTO compraDTO = new CompraDTO(usuarioId,
                    compra.getFechaCompra(),
                    compra.getTotalCompra(),
                    videojuegoDTOList);
            compraDTOList.add(compraDTO);
        }
        return compraDTOList;
    }

    //Obtener juegoDTO por cada juego en la lista de compraVideojuego
    private List<VideojuegoDTO> getVideojuegoDTOS(CompraEntity compra) {
        List<VideojuegoDTO> videojuegoDTOList = new ArrayList<>();

        for (CompraVideojuegoEntity compraVideojuego : compra.getCompraVideojuegoEntityList()) {
            VideojuegoDTO videojuegoDTO = new VideojuegoDTO(
                    compraVideojuego.getVideojuego().getId(),
                    compraVideojuego.getCantidad());

            videojuegoDTOList.add(videojuegoDTO);
        }
        return videojuegoDTOList;
    }
}
