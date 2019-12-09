package ar.edu.undec.testboundaries.TestService.Config;

import Repository.IRepositorioConsultarCuentaPorUsuario;
import Repository.IRepositorioCrearCuenta;
import UseCase.CrearCuentaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final IRepositorioCrearCuenta iRepositorioCrearCuenta;

    private final IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    public UseCaseConfig(IRepositorioCrearCuenta iRepositorioCrearCuenta, IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario) {
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
    }

    @Bean
    public CrearCuentaUseCase crearCuentaUseCase() {
        return new CrearCuentaUseCase(iRepositorioConsultarCuentaPorUsuario, iRepositorioCrearCuenta);
    }

}
