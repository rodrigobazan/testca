package AdapterTest;

import Adapter.ModificarCursoAdapter;
import Excepciones.CursoExisteException;
import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Input.ModificarCursoInput;
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
public class ModificarCursoAdapterTest {

    @Mock
    ModificarCursoInput modificarCursoInput;

    @Test
    void modificarCurso_NoExisteCursoNombre_ModificaCorrectamente() throws FechaLimiteIncorrectaException, CursoExisteException, UpdateCuentaException, CursoIncompletoException {
        CursoDTO cursoDTO = new CursoDTO(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        ModificarCursoAdapter modificarCursoAdapter = new ModificarCursoAdapter(modificarCursoInput);
        when(modificarCursoInput.modificarCurso(any(Curso.class))).thenReturn(Curso.instance(1, "Ionic 4", new ArrayList<>(),
                LocalDateTime.now().plusDays(5), 10));
        CursoDTO modificado = modificarCursoAdapter.modificarCurso(cursoDTO);
        Assertions.assertEquals("Ionic 4", modificado.titulo);
    }


    @Test
    void modificarCurso_ExisteCursoNombre_CursoExisteException() throws FechaLimiteIncorrectaException, CursoExisteException, UpdateCuentaException {
        CursoDTO cursoDTO = new CursoDTO(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10);
        ModificarCursoAdapter modificarCursoAdapter = new ModificarCursoAdapter(modificarCursoInput);
        when(modificarCursoInput.modificarCurso(any(Curso.class))).thenThrow(CursoExisteException.class);
        Assertions.assertThrows(CursoExisteException.class, () -> modificarCursoAdapter.modificarCurso(cursoDTO));
    }

}
