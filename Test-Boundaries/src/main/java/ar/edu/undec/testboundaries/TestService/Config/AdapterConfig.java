package ar.edu.undec.testboundaries.TestService.Config;

import Adapter.*;
import Input.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    private final CrearCuentaInput crearCuentaInput;
    private final ModificarCuentaInput modificarCuentaInput;
    private final ConsultarCuentasInput consultarCuentasInput;
    private final CrearCursoInput crearCursoInput;
    private final ModificarCursoInput modificarCursoInput;
    private final ConsultarCursosInput consultarCursosInput;
    private final InscripcionCursoInput inscripcionCursoInput;

    public AdapterConfig(CrearCuentaInput crearCuentaInput,
                         ModificarCuentaInput modificarCuentaInput,
                         ConsultarCuentasInput consultarCuentasInput,
                         CrearCursoInput crearCursoInput,
                         ModificarCursoInput modificarCursoInput,
                         ConsultarCursosInput consultarCursosInput,
                         InscripcionCursoInput inscripcionCursoInput) {
        this.crearCuentaInput = crearCuentaInput;
        this.modificarCuentaInput = modificarCuentaInput;
        this.consultarCuentasInput = consultarCuentasInput;
        this.crearCursoInput = crearCursoInput;
        this.modificarCursoInput = modificarCursoInput;
        this.consultarCursosInput = consultarCursosInput;
        this.inscripcionCursoInput = inscripcionCursoInput;
    }

    @Bean
    public CrearCuentaAdapter crearCuentaAdapter() {
        return new CrearCuentaAdapter(crearCuentaInput);
    }

    @Bean
    public ModificarCuentaAdapter modificarCuentaAdapter() {
        return new ModificarCuentaAdapter(modificarCuentaInput);
    }

    @Bean
    public ConsultarCuentasAdapter consultarCuentasAdapter() {
        return new ConsultarCuentasAdapter(consultarCuentasInput);
    }

    @Bean
    public CrearCursoAdapter crearCursoAdapter() {
        return new CrearCursoAdapter(crearCursoInput);
    }

    @Bean
    public ModificarCursoAdapter modificarCursoAdapter() {
        return new ModificarCursoAdapter(modificarCursoInput);
    }

    @Bean
    public ConsultarCursosAdapter consultarCursosAdapter() {
        return new ConsultarCursosAdapter(consultarCursosInput);
    }

    @Bean
    public InscripcionCursoAdapter inscripcionCursoAdapter() {
        return new InscripcionCursoAdapter(inscripcionCursoInput);
    }


}
