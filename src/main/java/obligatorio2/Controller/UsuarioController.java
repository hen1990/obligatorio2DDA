package obligatorio2.Controller;

import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http:/localhost:3000")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<?> addUsuario(@RequestBody UsuarioEntity persona) {

        try {
            if (usuarioService.existsByEmail(persona.getEmail())) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("El email ya está en uso.");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(persona));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping
    public ResponseEntity<?> upDateUsuario(@RequestBody UsuarioEntity persona) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(persona));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioEntity>> getUsuarioById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> getAllUsuarios() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    /*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioEntity usuarioEntity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.login(usuarioEntity));
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

     */
}
