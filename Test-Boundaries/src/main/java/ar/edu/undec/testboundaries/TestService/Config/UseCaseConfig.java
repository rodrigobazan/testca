package ar.edu.undec.testboundaries.TestService.Config;

import Repository.*;
import UseCase.ConsultarCuentasUseCase;
import UseCase.CrearCuentaUseCase;
import UseCase.CrearCursoUseCase;
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

    private final IRepositorioCrearCurso iRepositorioCrearCurso;

    private final IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;

    public UseCaseConfig(IRepositorioCrearCuenta iRepositorioCrearCuenta,
                         IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario,
                         IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId,
                         IRepositorioModificarCuenta iRepositorioModificarCuenta,
                         IRepositorioConsultarCuentas iRepositorioConsultarCuentas,
                         IRepositorioCrearCurso iRepositorioCrearCurso,
                         IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre) {
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
        this.iRepositorioModificarCuenta = iRepositorioModificarCuenta;
        this.iRepositorioConsultarCuentas = iRepositorioConsultarCuentas;
        this.iRepositorioCrearCurso = iRepositorioCrearCurso;
        this.iRepositorioConsultarCursoPorNombre = iRepositorioConsultarCursoPorNombre;
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

    @Bean
    public CrearCursoUseCase crearCursoUseCase() {
        return new CrearCursoUseCase(iRepositorioConsultarCursoPorNombre, iRepositorioCrearCurso);
    }

}
