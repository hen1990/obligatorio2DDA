package obligatorio2.Controller;

import obligatorio2.Entity.TipoUsuarioEntity;
import obligatorio2.Entity.VideojuegoEntity;
import obligatorio2.Service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "https://obg2henryemi.vercel.app/")
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @PostMapping
    public ResponseEntity<TipoUsuarioEntity> addTipoUsuario(@RequestBody TipoUsuarioEntity tipoUsuario) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioService.save(tipoUsuario));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TipoUsuarioEntity>> getTipoUsuarioById (@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioService.getTipoUsuarioById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<TipoUsuarioEntity>> getTipoUsuario() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioService.getAll());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTipoUsuario (@PathVariable Integer id) {
        try {
            Optional<TipoUsuarioEntity> tipoUsuarioEntity = tipoUsuarioService.getTipoUsuarioById(id);
            if (tipoUsuarioEntity.isPresent()) {
                tipoUsuarioService.deleteTipoUsuario(id);
                return ResponseEntity.status(HttpStatus.OK).body("TipoUsuario eliminado!");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("TipoUsuario no encontrado.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("TipoUsuario es uso.");
        }
    }

}
