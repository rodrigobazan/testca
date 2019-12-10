package ar.edu.undec.testboundaries.TestService.Config;

import Adapter.ConsultarCuentasAdapter;
import Adapter.CrearCuentaAdapter;
import Adapter.CrearCursoAdapter;
import Adapter.ModificarCuentaAdapter;
import Input.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    private final CrearCuentaInput crearCuentaInput;
    private final ModificarCuentaInput modificarCuentaInput;
    private final ConsultarCuentasInput consultarCuentasInput;
    private final CrearCursoInput crearCursoInput;

    public AdapterConfig(CrearCuentaInput crearCuentaInput,
                         ModificarCuentaInput modificarCuentaInput,
                         ConsultarCuentasInput consultarCuentasInput,
                         CrearCursoInput crearCursoInput) {
        this.crearCuentaInput = crearCuentaInput;
        this.modificarCuentaInput = modificarCuentaInput;
        this.consultarCuentasInput = consultarCuentasInput;
        this.crearCursoInput = crearCursoInput;
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


}
