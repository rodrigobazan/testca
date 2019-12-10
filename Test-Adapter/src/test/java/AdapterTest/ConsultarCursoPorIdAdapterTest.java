package AdapterTest;

import Adapter.ConsultarCursoPorIdAdapter;
import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Input.ConsultarCursoPorIdInput;
import Mockito.MockitoExtension;
import Model.Curso;
import ModelDTO.CursoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCursoPorIdAdapterTest {

    @Mock
    ConsultarCursoPorIdInput consultarCursoPorIdInput;

    @Test
    void consultarCursoPorId_ExisteId_DevuelveCursoDTO() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Curso curso = Curso.instance(1, "Nuevo Curso", new ArrayList<>(), LocalDateTime.of(2019, 12, 31, 0, 0, 0));
        ConsultarCursoPorIdAdapter consultarCursoPorIdAdapter = new ConsultarCursoPorIdAdapter(consultarCursoPorIdInput);
        when(consultarCursoPorIdInput.consultarCursoPorId(1)).thenReturn(curso);
        CursoDTO cursoDTO = consultarCursoPorIdAdapter.consultarCursoPorId(1);
        Assertions.assertEquals("Nuevo Curso", cursoDTO.titulo);
    }

}
