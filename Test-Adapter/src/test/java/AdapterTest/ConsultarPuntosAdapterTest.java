package AdapterTest;

import Adapter.ConsultarPuntosAdapter;
import Input.ConsultarPuntosInput;
import Mockito.MockitoExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPuntosAdapterTest {

    @Mock
    ConsultarPuntosInput consultarPuntosInput;

    @Test
    void consultarPuntosUsuario_TieneCursos_DevuelveTotalPuntos(){
        ConsultarPuntosAdapter consultarPuntosAdapter = new ConsultarPuntosAdapter(consultarPuntosInput);
        when(consultarPuntosInput.consultarPuntosCuenta("rabazan")).thenReturn(30);
        int puntos = consultarPuntosAdapter.consultarPuntosUsuario("rabazan");
        Assertions.assertEquals(30, puntos);
    }


    @Test
    void consultarPuntosUsuario_NoTieneCursos_DevuelveCero(){
        ConsultarPuntosAdapter consultarPuntosAdapter = new ConsultarPuntosAdapter(consultarPuntosInput);
        when(consultarPuntosInput.consultarPuntosCuenta("rabazan")).thenReturn(0);
        int puntos = consultarPuntosAdapter.consultarPuntosUsuario("rabazan");
        Assertions.assertEquals(0, puntos);
    }


}
