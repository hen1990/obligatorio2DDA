package obligatorio2.Service;

import obligatorio2.Entity.CategoriaEntity;
import obligatorio2.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaEntity save (CategoriaEntity categoriaEntity) {
        return categoriaRepository.save(categoriaEntity);
    }

    public Optional<CategoriaEntity> getById (Integer id) {
        return categoriaRepository.findById(id);
    }

    public List<CategoriaEntity> getAll () {
        return categoriaRepository.findAll();
    }
}
