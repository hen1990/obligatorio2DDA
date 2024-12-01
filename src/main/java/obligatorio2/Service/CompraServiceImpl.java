package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.EntitiesDTOs.VideojuegoCompraDTO;
import obligatorio2.Entity.CompraEntity;
import obligatorio2.Entity.CompraVideojuegoEntity;
import obligatorio2.Entity.VideojuegoEntity;
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
        CompraEntity savedCompra = compraRepository.save(compraEntity);

        //Se guarda en la base de datos cada compraVideojuego
        for (CompraVideojuegoEntity compraVideojuego : compraEntity.getCompraVideojuegoEntityList()) {
            compraVideojuego.setCompra(savedCompra);
            compraVideojuegoRepository.save(compraVideojuego);
        }
        return savedCompra;
    }

    public Optional<CompraEntity> getById(Integer id) {
        return compraRepository.findById(id);
    }

    public CompraDTO getCompraDTOById(Integer id) {
        try {

            Optional<CompraEntity> compra = compraRepository.findById(id);

            List<CompraVideojuegoEntity> compraVideojuegoEntityList = compra.get().getCompraVideojuegoEntityList();
            List<VideojuegoCompraDTO> videojuegoCompraDTOList = getVideojuegoCompraDTOS(compra.get());

            return new CompraDTO(compra.get().getUsuario().getId(), videojuegoCompraDTOList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CompraEntity> getAll() {
        return compraRepository.findAll();
    }


    public List<CompraDTO> getAllCompraDTO() {
        List<CompraDTO> compraDTOList = new ArrayList<>();
        List<CompraEntity> compraEntityList = getAll();
        for (CompraEntity compra : compraEntityList) {
            int usuarioId = compra.getUsuario().getId();
            List<VideojuegoCompraDTO> videojuegoCompraDTOList = getVideojuegoCompraDTOS(compra);

            CompraDTO compraDTO = new CompraDTO(usuarioId, videojuegoCompraDTOList);
            compraDTOList.add(compraDTO);
        }
        return compraDTOList;
    }

    //Obtener cada juegoDTO por cada juego en la lista de compraVideojuego
    private List<VideojuegoCompraDTO> getVideojuegoCompraDTOS(CompraEntity compra) {
        List<VideojuegoCompraDTO> videojuegoCompraDTOList = new ArrayList<>();

        for (CompraVideojuegoEntity compraVideojuego : compra.getCompraVideojuegoEntityList()) {
            VideojuegoCompraDTO videojuegoCompraDTO = new VideojuegoCompraDTO(
                    compraVideojuego.getVideojuego().getId(),
                    compraVideojuego.getCantidad());

            videojuegoCompraDTOList.add(videojuegoCompraDTO);
        }
        return videojuegoCompraDTOList;
    }
}
