package obligatorio2.Controller;

import obligatorio2.EntitiesDTOs.VideojuegoDTO;
import obligatorio2.Entity.VideojuegoEntity;
import obligatorio2.Service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/videojuego")
public class VideojuegoController {

    @Autowired
    private VideojuegoService videojuegoService;

    @PostMapping
    public ResponseEntity<?> addVideojuego (@RequestBody VideojuegoEntity videojuego) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(videojuegoService.save(videojuego));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideojuegoDTO> getVideojuegoDTOById (@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videojuegoService.getVideojuegoDTOById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<VideojuegoDTO>> getAll () {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(videojuegoService.getAll());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PatchMapping("/{id}/cantidadCopias")
    public ResponseEntity<?> updateCantidad(@PathVariable Integer id, @RequestBody Map<String, Integer> cantidadPayload) {
        try {
            Integer nuevaCantidad = cantidadPayload.get("cantidadCopias");
            if (nuevaCantidad == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La cantidad es obligatoria.");
            }
            videojuegoService.updateCantidadCopias(id, nuevaCantidad);
            return ResponseEntity.ok().body("Cantidad actualizada correctamente.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El videojuego no existe.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la cantidad.");
        }
    }

}
