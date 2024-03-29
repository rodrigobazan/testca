package ar.edu.undec.testboundaries.TestService.Config;

import Repository.*;
import UseCase.*;
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

    private final IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    private final IRepositorioModificarCurso iRepositorioModificarCurso;

    private final IRepositorioConsultarCursos iRepositorioConsultarCursos;

    private final IRepositorioConsultarCursosUsuario iRepositorioConsultarCursosUsuario;

    public UseCaseConfig(IRepositorioCrearCuenta iRepositorioCrearCuenta,
                         IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario,
                         IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId,
                         IRepositorioModificarCuenta iRepositorioModificarCuenta,
                         IRepositorioConsultarCuentas iRepositorioConsultarCuentas,
                         IRepositorioCrearCurso iRepositorioCrearCurso,
                         IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre,
                         IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId,
                         IRepositorioModificarCurso iRepositorioModificarCurso,
                         IRepositorioConsultarCursos iRepositorioConsultarCursos,
                         IRepositorioConsultarCursosUsuario iRepositorioConsultarCursosUsuario) {
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
        this.iRepositorioModificarCuenta = iRepositorioModificarCuenta;
        this.iRepositorioConsultarCuentas = iRepositorioConsultarCuentas;
        this.iRepositorioCrearCurso = iRepositorioCrearCurso;
        this.iRepositorioConsultarCursoPorNombre = iRepositorioConsultarCursoPorNombre;
        this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
        this.iRepositorioModificarCurso = iRepositorioModificarCurso;
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
        this.iRepositorioConsultarCursosUsuario = iRepositorioConsultarCursosUsuario;
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

    @Bean
    public ModificarCursoUseCase modificarCursoUseCase() {
        return new ModificarCursoUseCase(iRepositorioConsultarCursoPorId, iRepositorioConsultarCursoPorNombre, iRepositorioModificarCurso);
    }

    @Bean
    public ConsultarCursosUseCase consultarCursosUseCase() {
        return new ConsultarCursosUseCase(iRepositorioConsultarCursos);
    }

    @Bean
    public InscripcionCursoUseCase inscripcionCursoUseCase() {
        return new InscripcionCursoUseCase(iRepositorioModificarCurso, iRepositorioConsultarCursoPorId);
    }

    @Bean
    public ConsultarPuntosUseCase consultarPuntosUseCase() {
        return new ConsultarPuntosUseCase(iRepositorioConsultarCursosUsuario);
    }

    @Bean
    public ObtenerPromedioInscriptosUseCase obtenerPromedioInscriptosUseCase() {
        return new ObtenerPromedioInscriptosUseCase(iRepositorioConsultarCursos);
    }

    @Bean
    public ObtenerCursoMayorInscriptosUseCase obtenerCursoMayorInscriptosUseCase() {
        return new ObtenerCursoMayorInscriptosUseCase(iRepositorioConsultarCursos);
    }

    @Bean
    public ObtenerCursoMenorInscriptosUseCase obtenerCursoMenorInscriptosUseCase() {
        return new ObtenerCursoMenorInscriptosUseCase(iRepositorioConsultarCursos);
    }

}
