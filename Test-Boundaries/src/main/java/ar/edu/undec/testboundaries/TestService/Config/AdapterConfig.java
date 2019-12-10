package ar.edu.undec.testboundaries.TestService.Config;

import Adapter.ConsultarCuentasAdapter;
import Adapter.CrearCuentaAdapter;
import Adapter.ModificarCuentaAdapter;
import Input.ConsultarCuentasInput;
import Input.CrearCuentaInput;
import Input.ModificarCuentaInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    private final CrearCuentaInput crearCuentaInput;
    private final ModificarCuentaInput modificarCuentaInput;
    private final ConsultarCuentasInput consultarCuentasInput;

    public AdapterConfig(CrearCuentaInput crearCuentaInput,
                         ModificarCuentaInput modificarCuentaInput,
                         ConsultarCuentasInput consultarCuentasInput) {
        this.crearCuentaInput = crearCuentaInput;
        this.modificarCuentaInput = modificarCuentaInput;
        this.consultarCuentasInput = consultarCuentasInput;
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


}
