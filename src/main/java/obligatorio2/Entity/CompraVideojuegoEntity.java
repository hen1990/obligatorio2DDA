package obligatorio2.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;


@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CompraVideojuegoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private CompraEntity compra;
    @ManyToOne
    @JoinColumn(name = "videojuego_id", nullable = false)
    private VideojuegoEntity videojuego;
    @Column(nullable = false)
    private int cantidad;

    public CompraVideojuegoEntity(int id, CompraEntity compra, VideojuegoEntity videojuego, int cantidad) {
        this.id = id;
        this.compra = compra;
        this.videojuego = videojuego;
        this.cantidad = cantidad;
    }

    public CompraVideojuegoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompraEntity getCompra() {
        return compra;
    }

    public void setCompra(CompraEntity compra) {
        this.compra = compra;
    }

    public VideojuegoEntity getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(VideojuegoEntity videojuego) {
        this.videojuego = videojuego;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
