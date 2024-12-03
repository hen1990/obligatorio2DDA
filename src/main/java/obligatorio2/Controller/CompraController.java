package obligatorio2.Controller;

import obligatorio2.EntitiesDTOs.CompraDTO;
import obligatorio2.EntitiesDTOs.VideojuegoDTO;
import obligatorio2.Entity.CompraEntity;
import obligatorio2.Entity.CompraVideojuegoEntity;
import obligatorio2.Entity.UsuarioEntity;
import obligatorio2.Entity.VideojuegoEntity;
import obligatorio2.Service.CompraService;
import obligatorio2.Service.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;
    @Autowired
    private VideojuegoService videojuegoService;

    @PostMapping
    public ResponseEntity<CompraEntity> agregarCompra(@RequestBody CompraDTO compraDTO) {
        try {
            CompraEntity compraEntity = new CompraEntity();
            compraEntity.setUsuario(new UsuarioEntity(compraDTO.getUsuarioId()));
            compraEntity.setFechaCompra(LocalDateTime.now());

            double totalCompra = 0;
            int cantidadTotal = 0;

            //Crear CompraVideojuegoEntity y agregar cada juego a la lista de compraVideojuego
            //Sumar el total del precio
            //Sumar cantidad total de juegos
            List<CompraVideojuegoEntity> compraVideojuegos = new ArrayList<>();
            for (VideojuegoDTO videojuegoDTO : compraDTO.getVideojuegos()) {
                Optional<VideojuegoEntity> videojuegoDto = videojuegoService.getById(videojuegoDTO.getId());
                if (videojuegoDto.isPresent()) {
                    VideojuegoEntity videojuego = videojuegoDto.get();
                    int cantidad = videojuegoDTO.getCantidad();

                    CompraVideojuegoEntity compraVideojuego = new CompraVideojuegoEntity();
                    compraVideojuego.setCompra(compraEntity);
                    compraVideojuego.setVideojuego(videojuego);
                    compraVideojuego.setCantidad(cantidad);

                    compraVideojuegos.add(compraVideojuego);

                    totalCompra += videojuego.getPrecio() * cantidad;
                    cantidadTotal += cantidad;
                    videojuegoService.updateCantidadCopias(videojuegoDTO.getId(), cantidad);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
            }

            compraEntity.setTotalCompra(totalCompra);
            compraEntity.setCantidad(cantidadTotal);
            compraEntity.setCompraVideojuegoEntityList(compraVideojuegos);

            // Guardar compra
            CompraEntity savedCompra = compraService.save(compraEntity);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedCompra);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompraDTO> getCompraDTOById(@PathVariable Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(compraService.getCompraDTOById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<CompraDTO>> getAllCompraDTO() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(compraService.getAllCompraDTO());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
