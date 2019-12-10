package ModelTest;

import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Mockito.MockitoExtension;
import Model.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDateTime;
import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class CursoUnitTest {

    @Test
    void crearCurso_TodosLosCamposObligatorios_CreaNuevaInstancia() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Curso curso = Curso.instance(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.of(2019, 12, 31, 0, 0, 0));
        Assertions.assertNotNull(curso);
    }

    @Test
    void crearCurso_FaltanCamposObligatorios_CursoIncompletoException() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Assertions.assertThrows(CursoIncompletoException.class, () -> Curso.instance(null, "", new ArrayList<>(),
                LocalDateTime.of(2019, 12, 31, 0, 0, 0)));
    }

    @Test
    void crearCurso_fechaLimiteInscripcionCorrecta_CrearInstancia() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Curso curso = Curso.instance(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.of(2019, 12, 31, 0, 0, 0));
        Assertions.assertNotNull(curso);
    }

    @Test
    void crearCurso_fechaLimiteInscripcionIncorrecta_FechaLimiteIncorrectaException() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Assertions.assertThrows(FechaLimiteIncorrectaException.class, () -> Curso.instance(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.now().minusDays(1)));
    }


}
