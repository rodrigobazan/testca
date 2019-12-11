package UnitTest;

import Excepciones.*;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;
import Repository.IRepositorioModificarCurso;
import UseCase.InscripcionCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InscripcionCursoUnitTest {

    @Mock
    IRepositorioModificarCurso iRepositorioModificarCurso;

    @Test
    void inscripcionCurso_NoEstaInscripto_InscribeCorrectamente() throws CursoIncompletoException, CuentaIncompletaException, FechaCreacionIncorrectaException, EstaInscriptoException, UpdateCursoException, FechaLimiteException {
        Curso curso = Curso.instance(1, "Ionic 5", new ArrayList<>(), LocalDateTime.now().plusDays(5),
                15);
        Cuenta cuenta = Cuenta.instance(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456");
        InscripcionCursoUseCase inscripcionCursoUseCase = new InscripcionCursoUseCase(iRepositorioModificarCurso);
        when(iRepositorioModificarCurso.update(curso)).thenReturn(true);
        boolean resultado = inscripcionCursoUseCase.inscripcion(curso, cuenta);
        Assertions.assertTrue(resultado);
    }


    @Test
    void inscripcionCurso_EstaInscripto_EstaInscriptoException() throws CursoIncompletoException, CuentaIncompletaException, FechaCreacionIncorrectaException, EstaInscriptoException, UpdateCursoException, FechaLimiteException {
        Curso curso = Curso.instance(1, "Ionic 5", factoryInscripto(), LocalDateTime.now().plusDays(5),
                15);
        Cuenta cuenta = Cuenta.instance(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456");
        InscripcionCursoUseCase inscripcionCursoUseCase = new InscripcionCursoUseCase(iRepositorioModificarCurso);
        Assertions.assertThrows(EstaInscriptoException.class, () -> inscripcionCursoUseCase.inscripcion(curso, cuenta));
    }


    @Test
    void inscripcionCurso_FechaLimitePaso_FechaLimiteException() throws CursoIncompletoException, CuentaIncompletaException, FechaCreacionIncorrectaException, EstaInscriptoException, UpdateCursoException, FechaLimiteException {
        Curso curso = Curso.instance(1, "Ionic 5", new ArrayList<>(), LocalDateTime.now().minusDays(1), 15);
        Cuenta cuenta = Cuenta.instance(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456");
        InscripcionCursoUseCase inscripcionCursoUseCase = new InscripcionCursoUseCase(iRepositorioModificarCurso);
        Assertions.assertThrows(FechaLimiteException.class, () -> inscripcionCursoUseCase.inscripcion(curso, cuenta));
    }

    private List<Cuenta> factoryInscripto() {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(Cuenta.instance(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
