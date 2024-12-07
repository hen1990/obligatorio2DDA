package obligatorio2.EntitiesDTOs;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import obligatorio2.Entity.CategoriaEntity;

import java.util.List;

public class VideojuegoDTO {
    private int id;
    private int cantidad;
    private String codigoUnico;
    private String nombre;
    private String descripcion;
    private double precio;
    private String imagen;
    private int cantidadCopias;
    private CategoriaEntity categoria;
    List<CompraDTO> compraDTOList;
    private Double descuento;

    public VideojuegoDTO(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public VideojuegoDTO(int id, String codigoUnico, String nombre, String descripcion, double precio, String imagen, int cantidadCopias, CategoriaEntity categoria, List<CompraDTO> compraDTOList, Double descuento) {
        this.id = id;
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.cantidadCopias = cantidadCopias;
        this.categoria = categoria;
        this.compraDTOList = compraDTOList;
        this.descuento = descuento;
    }

    public VideojuegoDTO() {
    }

    public VideojuegoDTO(int id, int cantidad, String codigoUnico, String nombre, String descripcion, double precio, String imagen, int cantidadCopias, CategoriaEntity categoria, List<CompraDTO> compraDTOList, Double descuento) {
        this.id = id;
        this.cantidad = cantidad;
        this.codigoUnico = codigoUnico;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
        this.cantidadCopias = cantidadCopias;
        this.categoria = categoria;
        this.compraDTOList = compraDTOList;
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }
}
