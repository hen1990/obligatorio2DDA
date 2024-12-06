package obligatorio2.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "categoria")
    List<VideojuegoEntity> videojuegoList;

    public CategoriaEntity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public CategoriaEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
