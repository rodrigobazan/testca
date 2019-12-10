package UnitTest;

import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Mockito.MockitoExtension;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;
import UseCase.ConsultarCursoPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCursoPorIdUnitTest {

    @Mock
    IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    @Test
    void consultarCursoPorId_ExisteId_DevuelveCurso() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Curso curso = Curso.instance(1, "Nuevo Curso", new ArrayList<>(), LocalDateTime.of(2019, 12, 31, 0, 0, 0),
                10);
        ConsultarCursoPorIdUseCase consultarCursoPorIdUseCase = new ConsultarCursoPorIdUseCase(iRepositorioConsultarCursoPorId);
        when(iRepositorioConsultarCursoPorId.findByIdCurso(1)).thenReturn(curso);
        Curso buscado = consultarCursoPorIdUseCase.consultarCursoPorId(1);
        Assertions.assertEquals("Nuevo Curso", buscado.getTitulo());
    }

}
