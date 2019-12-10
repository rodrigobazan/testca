package UnitTest;

import Excepciones.CursoExisteException;
import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Mockito.MockitoExtension;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;
import Repository.IRepositorioConsultarCursoPorNombre;
import Repository.IRepositorioModificarCurso;
import UseCase.ModificarCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarCursoUnitTest {

    @Mock
    IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    @Mock
    IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;

    @Mock
    IRepositorioModificarCurso iRepositorioModificarCurso;

    @Test
    void modificarCurso_NoExisteCursoNombre_ModificaCorrectamente() throws FechaLimiteIncorrectaException, CursoIncompletoException, UpdateCuentaException, CursoExisteException {
        Curso cursoModificado = Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        Curso curso = Curso.instance(1, "Nuevo Curso", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        ModificarCursoUseCase modificarCursoUseCase = new ModificarCursoUseCase(iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCursoPorNombre, iRepositorioModificarCurso);
        when(iRepositorioConsultarCursoPorId.findByIdCurso(1)).thenReturn(curso);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Ionic 4")).thenReturn(null);
        when(iRepositorioModificarCurso.update(curso)).thenReturn(true);
        Curso modificado = modificarCursoUseCase.modificarCurso(cursoModificado);
        Assertions.assertEquals("Ionic 4", modificado.getTitulo());
    }

    @Test
    void modificarCurso_ExisteCursoNombre_CursoExisteException() throws FechaLimiteIncorrectaException, CursoIncompletoException, UpdateCuentaException, CursoExisteException {
        Curso cursoModificado = Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        Curso curso = Curso.instance(1, "Nuevo Curso", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        ModificarCursoUseCase modificarCursoUseCase = new ModificarCursoUseCase(iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCursoPorNombre, iRepositorioModificarCurso);
        when(iRepositorioConsultarCursoPorId.findByIdCurso(1)).thenReturn(curso);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Ionic 4")).thenReturn(Curso.instance(10, "Ionic 4", new ArrayList<>(),
                LocalDateTime.now().plusDays(30), 10));
        Assertions.assertThrows(CursoExisteException.class, () -> modificarCursoUseCase.modificarCurso(cursoModificado));
    }


    @Test
    void modificarCurso_FechaIncorrecta_FechaLimiteIncorrectaException() throws FechaLimiteIncorrectaException, CursoIncompletoException, UpdateCuentaException, CursoExisteException {
        Curso cursoModificado = Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().minusDays(10), 10);
        Curso curso = Curso.instance(1, "Nuevo Curso", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        ModificarCursoUseCase modificarCursoUseCase = new ModificarCursoUseCase(iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCursoPorNombre, iRepositorioModificarCurso);
        when(iRepositorioConsultarCursoPorId.findByIdCurso(1)).thenReturn(curso);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Ionic 4")).thenReturn(null);
        Assertions.assertThrows(FechaLimiteIncorrectaException.class, () -> modificarCursoUseCase.modificarCurso(cursoModificado));
    }

}
