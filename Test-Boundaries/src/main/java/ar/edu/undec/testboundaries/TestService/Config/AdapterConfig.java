package ar.edu.undec.testboundaries.TestService.Config;

import Adapter.CrearCuentaAdapter;
import Adapter.ModificarCuentaAdapter;
import Input.CrearCuentaInput;
import Input.ModificarCuentaInput;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    private final CrearCuentaInput crearCuentaInput;
    private final ModificarCuentaInput modificarCuentaInput;

    public AdapterConfig(CrearCuentaInput crearCuentaInput,
                         ModificarCuentaInput modificarCuentaInput) {
        this.crearCuentaInput = crearCuentaInput;
        this.modificarCuentaInput = modificarCuentaInput;
    }

    @Bean
    public CrearCuentaAdapter crearCuentaAdapter() {
        return new CrearCuentaAdapter(crearCuentaInput);
    }

    @Bean
    public ModificarCuentaAdapter modificarCuentaAdapter() {
        return new ModificarCuentaAdapter(modificarCuentaInput);
    }


}
