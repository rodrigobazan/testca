package Model;

import java.time.LocalDateTime;

import Exception.CuentaIncompletaException;

public class Cuenta {

    private Integer idCuenta;
    private String usuario;
    private LocalDateTime fechaCreacion;
    private String nombre;
    private String pass;

    private Cuenta(Integer idCuenta, String usuario, LocalDateTime fechaCreacion, String nombre, String pass) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.pass = pass;
    }

    public static Cuenta instance(Integer idCuenta, String usuario, LocalDateTime fechaCreacion,
                                  String nombre, String pass) throws CuentaIncompletaException {
        if (idCuenta == null || usuario == null || usuario.isEmpty() || fechaCreacion == null || nombre == null || nombre.isEmpty()
                || pass == null || pass.isEmpty())
            throw new CuentaIncompletaException();
        return new Cuenta(idCuenta, usuario, fechaCreacion, nombre, pass);
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }
}
