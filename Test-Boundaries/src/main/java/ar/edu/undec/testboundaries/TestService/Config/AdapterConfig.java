package ar.edu.undec.testboundaries.TestService.Config;

import Adapter.CrearCuentaAdapter;
import Input.CrearCuentaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    private final CrearCuentaInput crearCuentaInput;

    public AdapterConfig(CrearCuentaInput crearCuentaInput) {
        this.crearCuentaInput = crearCuentaInput;
    }

    @Bean
    public CrearCuentaAdapter crearCuentaAdapter() {
        return new CrearCuentaAdapter(crearCuentaInput);
    }


}
