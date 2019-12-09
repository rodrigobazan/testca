package ar.edu.undec.testboundaries.TestData.ModeloData;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "cuenta")
@SequenceGenerator(name = "cuenta_idcuenta_seq", initialValue = 1, sequenceName = "cuenta_idcuenta_seq", allocationSize = 1)
public class CuentaEntity {


    @Id
    @Column(name = "idcuenta")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cuenta_idcuenta_seq")
    private Integer idCuenta;

    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fechacreacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pass")
    private String pass;

    public CuentaEntity() {
    }

    public CuentaEntity(String usuario, LocalDateTime fechaCreacion, String nombre, String pass) {
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.pass = pass;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
