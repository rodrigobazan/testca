package AdapterTest;

import Adapter.ObtenerCursoMayorInscriptoAdapter;
import Excepciones.CursoIncompletoException;
import Excepciones.NoExisteInscriptosException;
import Input.ObtenerCursoMayorInscriptoInput;
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
public class ObtenerCursoMayorInscriptosAdapterTest {

    @Mock
    ObtenerCursoMayorInscriptoInput obtenerCursoMayorInscriptoInput;

    @Test
    void obtenerCursoMayorInscriptos_HayCursosConInscriptos_DevuelveCurso() throws NoExisteInscriptosException, CursoIncompletoException {
        ObtenerCursoMayorInscriptoAdapter obtenerCursoMayorInscriptoAdapter = new ObtenerCursoMayorInscriptoAdapter(obtenerCursoMayorInscriptoInput);
        when(obtenerCursoMayorInscriptoInput.obtenerCurso()).thenReturn(Curso.instance(1, "Ionic 4", factoryInscriptos(),
                LocalDateTime.now().plusDays(5), 10));
        CursoDTO cursoDTO = obtenerCursoMayorInscriptoAdapter.obtenerCursoMayorInscriptos();
        Assertions.assertEquals("Ionic 4", cursoDTO.titulo);
    }

    @Test
    void obtenerCursoMayorInscriptos_NoHayCursosConInscriptos_NoExisteInscriptosException() throws NoExisteInscriptosException, CursoIncompletoException {
        ObtenerCursoMayorInscriptoAdapter obtenerCursoMayorInscriptoAdapter = new ObtenerCursoMayorInscriptoAdapter(obtenerCursoMayorInscriptoInput);
        when(obtenerCursoMayorInscriptoInput.obtenerCurso()).thenThrow(NoExisteInscriptosException.class);
        Assertions.assertThrows(NoExisteInscriptosException.class, obtenerCursoMayorInscriptoAdapter::obtenerCursoMayorInscriptos);
    }

    private List<Cuenta> factoryInscriptos() {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(Cuenta.instance(1, "rabazan", LocalDateTime.now(), "Rodrigo Bazan", "123456"));
            cuentas.add(Cuenta.instance(2, "gtorres", LocalDateTime.now(), "German Torres", "123456"));
            cuentas.add(Cuenta.instance(3, "jruitti", LocalDateTime.now(), "Javier Ruitti", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
