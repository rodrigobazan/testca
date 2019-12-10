package AdapterTest;

import Adapter.ConsultarCursoAdapter;
import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Input.ConsultarCursoPorNombreInput;
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
public class ConsultarCursoPorTitutloAdapterTest {

    @Mock
    ConsultarCursoPorNombreInput consultarCursoPorNombreInput;

    @Test
    void consultarCursoPorTitulo_HayCoincidencia_DevuelveCursoDTO() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        ConsultarCursoAdapter consultarCursoAdapter = new ConsultarCursoAdapter(consultarCursoPorNombreInput);
        when(consultarCursoPorNombreInput.consultarCursoPorNombre("Nuevo Curso"))
                .thenReturn(Curso.instance(1, "Nuevo Curso", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10));
        CursoDTO buscado = consultarCursoAdapter.consultarCurso("Nuevo Curso");
        Assertions.assertEquals(1, buscado.idCurso.intValue());
    }

    @Test
    void consultarCursoPorTitulo_NoHayCoincidencia_DevuelveNull() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        ConsultarCursoAdapter consultarCursoAdapter = new ConsultarCursoAdapter(consultarCursoPorNombreInput);
        when(consultarCursoPorNombreInput.consultarCursoPorNombre("Nuevo Curso"))
                .thenReturn(null);
        CursoDTO buscado = consultarCursoAdapter.consultarCurso("Nuevo Curso");
        Assertions.assertNull(buscado);
    }

}
