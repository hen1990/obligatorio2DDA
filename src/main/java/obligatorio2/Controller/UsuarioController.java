package obligatorio2.Controller;

import obligatorio2.EntitiesDTOs.UsuarioDTO;
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
@CrossOrigin(origins = "https://obg2henryemi.vercel.app")
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

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> upDateUsuario(@PathVariable Integer id, @RequestBody UsuarioEntity persona) {
        try {
            UsuarioDTO usuarioDTO = usuarioService.getById(id);
            if (usuarioDTO != null) {
                persona.setId(id);
                return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(persona));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no encontrado.");

        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUsuario (@PathVariable Integer id) {
        try {
            usuarioService.deleteUsuario(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioEntity usuarioEntity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(usuarioService.login(usuarioEntity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontró usuario");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
