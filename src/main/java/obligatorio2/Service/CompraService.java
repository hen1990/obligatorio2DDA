package obligatorio2.Service;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.Entity.CompraEntity;

import java.util.List;
import java.util.Optional;

public interface CompraService {
    CompraEntity save (CompraEntity compraEntity);
    Optional<CompraEntity> getById (Integer id);
    List<CompraDTO> getAllCompraDTO();
    List<CompraEntity> getAll();
    public CompraDTO getCompraDTOById(Integer id);
    List<CompraDTO> getByUsuarioId (Integer id);

}
