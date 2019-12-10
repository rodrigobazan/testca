package ar.edu.undec.testboundaries.TestService.Config;

import Repository.IRepositorioConsultarCuentaPorId;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import Repository.IRepositorioCrearCuenta;
import Repository.IRepositorioModificarCuenta;
import UseCase.CrearCuentaUseCase;
import UseCase.ModificarCuentaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    private final IRepositorioCrearCuenta iRepositorioCrearCuenta;

    private final IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    private final IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    private final IRepositorioModificarCuenta iRepositorioModificarCuenta;

    public UseCaseConfig(IRepositorioCrearCuenta iRepositorioCrearCuenta,
                         IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario,
                         IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId,
                         IRepositorioModificarCuenta iRepositorioModificarCuenta) {
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
        this.iRepositorioModificarCuenta = iRepositorioModificarCuenta;
    }

    @Bean
    public CrearCuentaUseCase crearCuentaUseCase() {
        return new CrearCuentaUseCase(iRepositorioConsultarCuentaPorUsuario, iRepositorioCrearCuenta);
    }

    @Bean
    public ModificarCuentaUseCase modificarCuentaUseCase() {
        return new ModificarCuentaUseCase(iRepositorioConsultarCuentaPorId, iRepositorioModificarCuenta,
                iRepositorioConsultarCuentaPorUsuario);
    }

}
