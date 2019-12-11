package AdapterTest;

import Adapter.ObtenerPromedioInscriptosAdapter;
import Input.ObtenerPromedioInscriptosInput;
import Mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerPromedioInscriptosAdapterTest {

    @Mock
    ObtenerPromedioInscriptosInput obtenerPromedioInscriptosInput;

    @Test
    void obtenerPromedioInscriptos_HayCursos_DevuelvePromedio() {
        ObtenerPromedioInscriptosAdapter obtenerPromedioInscriptosAdapter = new ObtenerPromedioInscriptosAdapter(obtenerPromedioInscriptosInput);
        when(obtenerPromedioInscriptosInput.obtenerPromedio()).thenReturn(1.33);
        double promedio = obtenerPromedioInscriptosAdapter.obtenerPromedio();
        Assertions.assertEquals(1.33, promedio);
    }

    @Test
    void obtenerPromedioInscriptos_NoHayCursos_DevuelveCero() {
        ObtenerPromedioInscriptosAdapter obtenerPromedioInscriptosAdapter = new ObtenerPromedioInscriptosAdapter(obtenerPromedioInscriptosInput);
        when(obtenerPromedioInscriptosInput.obtenerPromedio()).thenReturn(0.0);
        double promedio = obtenerPromedioInscriptosAdapter.obtenerPromedio();
        Assertions.assertEquals(0.0, promedio);
    }

}
