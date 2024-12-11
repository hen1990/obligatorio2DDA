package obligatorio2.Controller;

import obligatorio2.Entity.AdministradorEntity;
import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin(origins = "https://obg2henryemi.vercel.app/")
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @PostMapping
    public ResponseEntity<AdministradorEntity> save (@RequestBody AdministradorEntity administradorEntity ) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.save(administradorEntity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AdministradorEntity>> getById (@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.getById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping ("/login")
    public ResponseEntity<?> login(@RequestBody AdministradorEntity administradorEntity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(administradorService.login(administradorEntity));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se encontró usuario");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
