package AdapterTest;

import Adapter.ObtenerCursoMenorInscriptoAdapter;
import Excepciones.CursoIncompletoException;
import Excepciones.NoExisteInscriptosException;
import Input.ObtenerCursoMenorInscriptosInput;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Model.Curso;
import ModelDTO.CursoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerCursoMenorInscriptosAdapterTest {

    @Mock
    ObtenerCursoMenorInscriptosInput obtenerCursoMenorInscriptosInput;

    @Test
    void obtenerCursoMenorInscriptos_HayCursosConInscriptos_DevuelveCurso() throws NoExisteInscriptosException, CursoIncompletoException {
        ObtenerCursoMenorInscriptoAdapter obtenerCursoMenorInscriptoAdapter = new ObtenerCursoMenorInscriptoAdapter(obtenerCursoMenorInscriptosInput);
        when(obtenerCursoMenorInscriptosInput.obtenerCurso()).thenReturn(Curso.instance(1, "Ionic 5", factoryInscriptos(),
                LocalDateTime.now().plusDays(5), 10));
        CursoDTO cursoDTO = obtenerCursoMenorInscriptoAdapter.obtenerCursoMenorInscriptos();
        Assertions.assertEquals("Ionic 5", cursoDTO.titulo);
    }

    @Test
    void obtenerCursoMenorInscriptos_NoHayCursosConInscriptos_NoExisteInscriptosException() throws NoExisteInscriptosException, CursoIncompletoException {
        ObtenerCursoMenorInscriptoAdapter obtenerCursoMenorInscriptoAdapter = new ObtenerCursoMenorInscriptoAdapter(obtenerCursoMenorInscriptosInput);
        when(obtenerCursoMenorInscriptosInput.obtenerCurso()).thenThrow(NoExisteInscriptosException.class);
        Assertions.assertThrows(NoExisteInscriptosException.class, obtenerCursoMenorInscriptoAdapter::obtenerCursoMenorInscriptos);
    }

    private List<Cuenta> factoryInscriptos() {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(Cuenta.instance(1, "rabazan", LocalDateTime.now(), "Rodrigo Bazan", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
