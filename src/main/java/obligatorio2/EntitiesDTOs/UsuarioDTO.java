package obligatorio2.EntitiesDTOs;

import obligatorio2.Entity.CompraEntity;
import obligatorio2.Entity.TipoUsuarioEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UsuarioDTO {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private TipoUsuarioEntity tipoUsuario;
    private List<CompraDTO> historialCompras;

    //Usuario premium
    private LocalDate fechaMembresia;
    private LocalDate fechaVencimientoMembresia;
    private String tarjetaCredito;

    public UsuarioDTO() {}

    public UsuarioDTO(int id, String nombre, String apellido, String email, LocalDate fechaNacimiento, LocalDateTime fechaRegistro, TipoUsuarioEntity tipoUsuario, List<CompraDTO> historialCompras) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.tipoUsuario = tipoUsuario;
        this.historialCompras = historialCompras;
    }

    public UsuarioDTO(int id, String nombre, String apellido, String email, LocalDate fechaNacimiento, LocalDateTime fechaRegistro, TipoUsuarioEntity tipoUsuario, List<CompraDTO> historialCompras, LocalDate fechaMembresia, LocalDate fechaVencimientoMembresia, String tarjetaCredito) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.tipoUsuario = tipoUsuario;
        this.historialCompras = historialCompras;
        this.fechaMembresia = fechaMembresia;
        this.fechaVencimientoMembresia = fechaVencimientoMembresia;
        this.tarjetaCredito = tarjetaCredito;
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

    public List<CompraDTO> getHistorialCompras() {
        return historialCompras;
    }

    public void setHistorialCompras(List<CompraDTO> historialCompras) {
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

    public String getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }
}
