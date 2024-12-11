package obligatorio2.Controller;

import obligatorio2.EntitiesDTOs.UsuarioDTO;
import obligatorio2.Entity.CategoriaEntity;
import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Entity.VideojuegoEntity;
import obligatorio2.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "https://obg2henryemi.vercel.app")
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaEntity> addCategoria (@RequestBody CategoriaEntity categoriaEntity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaEntity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoriaEntity>> getById (@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<CategoriaEntity>> getAll () {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAll());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> upDateCategoria(@PathVariable Integer id, @RequestBody CategoriaEntity categoria) {
        try {
            Optional<CategoriaEntity> categoriaEntity = categoriaService.getById(id);
            if (categoriaEntity.isPresent()) {
                categoriaEntity.get().setNombre(categoria.getNombre());
                return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaEntity.get()));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Categoría no encontrada.");

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoria (@PathVariable Integer id) {
        try {
            Optional<CategoriaEntity> categoriaEntity = categoriaService.getById(id);
            if (categoriaEntity.isPresent()) {
                categoriaService.deleteCategoria(id);
                return ResponseEntity.status(HttpStatus.OK).body("Categoría eliminada!");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Categoría no encontrada.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Categoría en uso.");
        }
    }
}
