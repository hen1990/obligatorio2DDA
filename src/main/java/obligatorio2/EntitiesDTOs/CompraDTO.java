package obligatorio2.EntitiesDTOs;

import java.util.List;

public class CompraDTO {
    private int usuarioId;
    private List<VideojuegoCompraDTO> videojuegosCompraDTO;

    public CompraDTO(int usuarioId, List<VideojuegoCompraDTO> videojuegosCompraDTO) {
        this.usuarioId = usuarioId;
        this.videojuegosCompraDTO = videojuegosCompraDTO;
    }

    public CompraDTO() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<VideojuegoCompraDTO> getVideojuegosCompraDTO() {
        return videojuegosCompraDTO;
    }

    public void setVideojuegos(List<VideojuegoCompraDTO> videojuegosCompraDTO) {
        this.videojuegosCompraDTO = videojuegosCompraDTO;
    }
}

