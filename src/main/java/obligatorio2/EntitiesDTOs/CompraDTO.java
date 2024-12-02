package obligatorio2.EntitiesDTOs;

import java.time.LocalDateTime;
import java.util.List;

public class CompraDTO {
    private int usuarioId;
    private LocalDateTime fechaCompra;
    private double totalCompra;
    private List<VideojuegoDTO> videojuegos;

    public CompraDTO(int usuarioId, LocalDateTime fechaCompra, double totalCompra, List<VideojuegoDTO> videojuegos) {
        this.usuarioId = usuarioId;
        this.fechaCompra = fechaCompra;
        this.totalCompra = totalCompra;
        this.videojuegos = videojuegos;
    }

    public CompraDTO() {}

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
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

    public List<VideojuegoDTO> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(List<VideojuegoDTO> videojuegos) {
        this.videojuegos = videojuegos;
    }
}

