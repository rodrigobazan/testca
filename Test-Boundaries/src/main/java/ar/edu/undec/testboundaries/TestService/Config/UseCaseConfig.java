package ar.edu.undec.testboundaries.TestService.Config;

import Repository.*;
import UseCase.ConsultarCuentasUseCase;
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

    private final IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    public UseCaseConfig(IRepositorioCrearCuenta iRepositorioCrearCuenta,
                         IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario,
                         IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId,
                         IRepositorioModificarCuenta iRepositorioModificarCuenta,
                         IRepositorioConsultarCuentas iRepositorioConsultarCuentas) {
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
        this.iRepositorioModificarCuenta = iRepositorioModificarCuenta;
        this.iRepositorioConsultarCuentas = iRepositorioConsultarCuentas;
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

    @Bean
    public ConsultarCuentasUseCase consultarCuentasUseCase() {
        return new ConsultarCuentasUseCase(iRepositorioConsultarCuentas);
    }

}
