package obligatorio2.EntitiesDTOs;

public class VideojuegoCompraDTO {
    private int id;
    private int cantidad;

    public VideojuegoCompraDTO(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public VideojuegoCompraDTO() {
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
}
