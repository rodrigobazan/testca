package ModeloWrapperDTO;

import ModelDTO.CuentaDTO;
import ModelDTO.CursoDTO;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InscripcionWrapperDTO {

    @JsonProperty("curso")
    public final CursoDTO cursoDTO;

    @JsonProperty("cuenta")
    public final CuentaDTO cuentaDTO;

    @JsonCreator
    public InscripcionWrapperDTO(@JsonProperty("curso") CursoDTO cursoDTO,
                                 @JsonProperty("cuenta") CuentaDTO cuentaDTO) {
        this.cursoDTO = cursoDTO;
        this.cuentaDTO = cuentaDTO;
    }
}
