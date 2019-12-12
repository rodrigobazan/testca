package ModelDTO;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class CuentaDTO {

    @JsonProperty("idCuenta")
    public final Integer idCuenta;
    @JsonProperty("usuario")
    public final String usuario;
    @JsonProperty("fechaCreacion")
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public final LocalDateTime fechaCreacion;
    @JsonProperty("nombre")
    public final String nombre;
    @JsonProperty("pass")
    public final String pass;


    @JsonCreator
    public CuentaDTO(@JsonProperty("idCuenta") Integer idCuenta,
                     @JsonProperty("usuario") String usuario,
                     @JsonProperty("fechaCreacion") LocalDateTime fechaCreacion,
                     @JsonProperty("nombre") String nombre,
                     @JsonProperty("pass") String pass) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.fechaCreacion = fechaCreacion;
        this.nombre = nombre;
        this.pass = pass;
    }
}
