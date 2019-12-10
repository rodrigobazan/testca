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

    public AdapterConfig(CrearCuentaInput crearCuentaInput,
                         ModificarCuentaInput modificarCuentaInput,
                         ConsultarCuentasInput consultarCuentasInput,
                         CrearCursoInput crearCursoInput,
                         ModificarCursoInput modificarCursoInput) {
        this.crearCuentaInput = crearCuentaInput;
        this.modificarCuentaInput = modificarCuentaInput;
        this.consultarCuentasInput = consultarCuentasInput;
        this.crearCursoInput = crearCursoInput;
        this.modificarCursoInput = modificarCursoInput;
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


}
