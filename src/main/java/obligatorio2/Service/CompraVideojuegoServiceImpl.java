package obligatorio2.Service;

import obligatorio2.Entity.CompraVideojuegoEntity;
import obligatorio2.Repository.CompraVideojuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CompraVideojuegoServiceImpl implements CompraVideojuegoService{

    @Autowired
    private CompraVideojuegoRepository compraVideojuegoRepository;

    public CompraVideojuegoEntity save (CompraVideojuegoEntity compraVideojuegoEntity) {
        return compraVideojuegoRepository.save(compraVideojuegoEntity);
    }

    public List<CompraVideojuegoEntity> getById (Integer id) {
        return compraVideojuegoRepository.findAllById(Collections.singleton(id));
    }

}
