package obligatorio2.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "videojuego")
public class VideojuegoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 20)
    private String codigoUnico;

    @Column(nullable = false, length = 50)
    private String nombre;

    private String descripcion;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private String imagen;

    private int cantidadCopias;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;

    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CompraVideojuegoEntity> compraVideojuegoEntityList;

    public VideojuegoEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public List<CompraVideojuegoEntity> getCompraVideojuegoEntityList() {
        return compraVideojuegoEntityList;
    }

    public void setCompraVideojuegoEntityList(List<CompraVideojuegoEntity> compraVideojuegoEntityList) {
        this.compraVideojuegoEntityList = compraVideojuegoEntityList;
    }
}
