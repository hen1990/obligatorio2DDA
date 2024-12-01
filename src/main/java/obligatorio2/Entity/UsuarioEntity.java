package obligatorio2.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String apellido;
    @Column(unique = true, nullable = false, length = 50)
    private String email;
    @Column(nullable = false, length = 50)
    private String password;
    @Column(nullable = false, length = 50)
    private LocalDate fechaNacimiento;
    @Column(nullable = false, length = 50)
    private LocalDateTime fechaRegistro;
    @ManyToOne
    @JoinColumn(name = "tipoUsuarioId")
    private TipoUsuarioEntity tipoUsuario;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<CompraEntity> historialCompras;

    //Usuario premium
    private LocalDate fechaMembresia;
    private LocalDate fechaVencimientoMembresia;
    private Double descuento;
    @Column(unique = true)
    private String tarjetaCredito;

    //Usuario estandar
    public UsuarioEntity(int id, String nombre, String apellido, String email, String password, LocalDate fechaNacimiento, LocalDateTime fechaRegistro, TipoUsuarioEntity tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDateTime.now();
        this.tipoUsuario = tipoUsuario;
    }

    //Usuario premium
    public UsuarioEntity(int id, String nombre, String apellido, String email, String password, LocalDate fechaNacimiento, LocalDateTime fechaRegistro, TipoUsuarioEntity tipoUsuario, LocalDate fechaMembresia, LocalDate fechaVencimientoMembresia, Double descuento, String tarjetaCredito) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.tipoUsuario = tipoUsuario;
        this.fechaMembresia = fechaMembresia;
        this.fechaVencimientoMembresia = fechaVencimientoMembresia;
        this.descuento = 0.2;
        this.tarjetaCredito = tarjetaCredito;
    }

    public UsuarioEntity() {}

    public UsuarioEntity(int id) {
        this.id = id;
    }

    @PrePersist
    protected void onCreate() {
        if (this.fechaRegistro == null) {
            this.fechaRegistro = LocalDateTime.now();
        }
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public TipoUsuarioEntity getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuarioEntity tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<CompraEntity> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<CompraEntity> historialCompras) {
        this.historialCompras = historialCompras;
    }

    public LocalDate getFechaMembresia() {
        return fechaMembresia;
    }

    public void setFechaMembresia(LocalDate fechaMembresia) {
        this.fechaMembresia = fechaMembresia;
    }

    public LocalDate getFechaVencimientoMembresia() {
        return fechaVencimientoMembresia;
    }

    public void setFechaVencimientoMembresia(LocalDate fechaVencimientoMembresia) {
        this.fechaVencimientoMembresia = fechaVencimientoMembresia;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

}
