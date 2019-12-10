package UnitTest;

import Excepciones.CursoExisteException;
import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.PersistException;
import Mockito.MockitoExtension;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorNombre;
import Repository.IRepositorioCrearCurso;
import UseCase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoUnitTest {

    @Mock
    IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;

    @Mock
    IRepositorioCrearCurso iRepositorioCrearCurso;

    @Test
    void crearCurso_NoExisteNombreCurso_CrearCorrectamente() throws FechaLimiteIncorrectaException, CursoIncompletoException, PersistException, CursoExisteException {
        Curso curso = Curso.instance(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.now().plusDays(5), 10);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(iRepositorioConsultarCursoPorNombre, iRepositorioCrearCurso);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Nuevo Curso")).thenReturn(null);
        when(iRepositorioCrearCurso.persist(curso)).thenReturn(true);
        boolean resultado = crearCursoUseCase.crearCurso(curso);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearCurso_ExisteNombreCurso_CursoExisteException() throws FechaLimiteIncorrectaException, CursoIncompletoException, PersistException, CursoExisteException {
        Curso curso = Curso.instance(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.now().plusDays(5), 10);
        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(iRepositorioConsultarCursoPorNombre, iRepositorioCrearCurso);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Nuevo Curso")).thenReturn(Curso.instance(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.now().plusDays(5), 10));
        Assertions.assertThrows(CursoExisteException.class, () -> crearCursoUseCase.crearCurso(curso));
    }

}
