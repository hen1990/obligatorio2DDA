package obligatorio2.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compra")
public class CompraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private UsuarioEntity usuario;
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = false)
    private List<CompraVideojuegoEntity> compraVideojuegoEntityList;
    @Column(nullable = false)
    private LocalDateTime fechaCompra;
    @Column(nullable = false)
    private double totalCompra;
    @Column(nullable = false)
    private int cantidadTotal;

    public CompraEntity(int id, UsuarioEntity usuario, List<CompraVideojuegoEntity> compraVideojuegoEntityList, LocalDateTime fechaCompra, double totalCompra, int cantidadTotal) {
        this.id = id;
        this.usuario = usuario;
        this.compraVideojuegoEntityList = compraVideojuegoEntityList;
        this.fechaCompra = fechaCompra;
        this.totalCompra = totalCompra;
        this.cantidadTotal = cantidadTotal;
    }

    public CompraEntity() {}

    @PrePersist
    protected void onCreate() {
        if (this.fechaCompra == null) {
            this.fechaCompra = LocalDateTime.now();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<CompraVideojuegoEntity> getCompraVideojuegoEntityList() {
        return compraVideojuegoEntityList;
    }

    public void setCompraVideojuegoEntityList(List<CompraVideojuegoEntity> compraVideojuegoEntityList) {
        this.compraVideojuegoEntityList = compraVideojuegoEntityList;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public int getCantidad() {
        return cantidadTotal;
    }

    public void setCantidad(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

}
