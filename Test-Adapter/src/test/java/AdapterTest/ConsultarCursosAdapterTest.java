package AdapterTest;

import Adapter.ConsultarCursosAdapter;
import Input.ConsultarCursosInput;
import Mockito.MockitoExtension;
import Model.Curso;
import ModelDTO.CursoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCursosAdapterTest {

    @Mock
    ConsultarCursosInput consultarCursosInput;

    @Spy
    List<Curso> cursos = factoryCursos();

    @Test
    void consultarCursos_ExistenCursos_DevuelveCursosDTO() {
        ConsultarCursosAdapter consultarCursosAdapter = new ConsultarCursosAdapter(consultarCursosInput);
        when(consultarCursosInput.consultarCursos()).thenReturn(cursos);
        List<CursoDTO> cursoDTOS = consultarCursosAdapter.consultarCursos();
        Assertions.assertEquals(3, cursoDTOS.size());
    }

    @Test
    void consultarCursos_NoExistenCursos_DevuelveListaVacia() {
        ConsultarCursosAdapter consultarCursosAdapter = new ConsultarCursosAdapter(consultarCursosInput);
        when(consultarCursosInput.consultarCursos()).thenReturn(new ArrayList<>());
        List<CursoDTO> cursoDTOS = consultarCursosAdapter.consultarCursos();
        Assertions.assertEquals(0, cursoDTOS.size());
    }

    private List<Curso> factoryCursos() {
        try {
            List<Curso> cursos = new ArrayList<>();
            cursos.add(Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(3), 10));
            cursos.add(Curso.instance(2, "Ionic 3", new ArrayList<>(), LocalDateTime.now().plusDays(4), 10));
            cursos.add(Curso.instance(3, "Ionic 5", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10));
            return cursos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
