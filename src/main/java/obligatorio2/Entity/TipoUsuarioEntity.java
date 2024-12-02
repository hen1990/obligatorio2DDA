package obligatorio2.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String nombreTipoUsuario;

    @OneToMany (mappedBy = "tipoUsuario")
    private List<UsuarioEntity> usuarioEntityList;

    public TipoUsuarioEntity(int id, String nombreTipoUsuario, List<UsuarioEntity> usuarioEntityList) {
        this.id = id;
        this.nombreTipoUsuario = nombreTipoUsuario;
        this.usuarioEntityList = usuarioEntityList; //new ArrayList<>();
    }

    public TipoUsuarioEntity() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }

}
