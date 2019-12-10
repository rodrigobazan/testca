package AdapterTest;

import Adapter.CrearCursoAdapter;
import Excepciones.CursoExisteException;
import Excepciones.PersistException;
import Input.CrearCursoInput;
import Mockito.MockitoExtension;
import Model.Curso;
import ModelDTO.CursoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoAdapterTest {

    @Mock
    CrearCursoInput crearCursoInput;

    @Test
    void crearCurso_NoExisteNombreCurso_CreaCorrectamente() throws PersistException, CursoExisteException {
        CursoDTO cursoDTO = new CursoDTO(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.of(2019, 12, 31, 0, 0, 0));
        CrearCursoAdapter crearCursoAdapter = new CrearCursoAdapter(crearCursoInput);
        when(crearCursoInput.crearCurso(any(Curso.class))).thenReturn(true);
        boolean resultado = crearCursoAdapter.crearCurso(cursoDTO);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearCurso_ExisteNombreCurso_CursoExisteException() throws PersistException, CursoExisteException {
        CursoDTO cursoDTO = new CursoDTO(null, "Nuevo Curso", new ArrayList<>(),
                LocalDateTime.of(2019, 12, 31, 0, 0, 0));
        CrearCursoAdapter crearCursoAdapter = new CrearCursoAdapter(crearCursoInput);
        when(crearCursoInput.crearCurso(any(Curso.class))).thenThrow(CursoExisteException.class);
        Assertions.assertThrows(CursoExisteException.class, () -> crearCursoAdapter.crearCurso(cursoDTO));
    }


}
