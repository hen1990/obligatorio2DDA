package obligatorio2.EntitiesDTOs;

public class VideojuegoDTO {
    private int id;
    private int cantidad;

    public VideojuegoDTO(int id, int cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public VideojuegoDTO() {
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
