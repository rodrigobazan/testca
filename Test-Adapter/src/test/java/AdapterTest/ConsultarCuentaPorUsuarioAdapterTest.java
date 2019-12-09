package AdapterTest;

import Adapter.ConsultarCuentaPorUsuarioAdapter;
import Excepciones.FechaCreacionIncorrectaException;
import Input.ConsultarCuentaPorUsuarioInput;
import Mockito.MockitoExtension;
import Model.Cuenta;
import ModelDTO.CuentaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import Excepciones.CuentaIncompletaException;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentaPorUsuarioAdapterTest {

    @Mock
    ConsultarCuentaPorUsuarioInput consultarCuentaPorUsuarioInput;

    @Test
    void consultarCuentaPorUsuario_HayCoincidencia_DevuelveCuentaDTO() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        ConsultarCuentaPorUsuarioAdapter consultarCuentaPorUsuarioAdapter = new ConsultarCuentaPorUsuarioAdapter(consultarCuentaPorUsuarioInput);
        when(consultarCuentaPorUsuarioInput.consultarCuentaPorUsuario("rabazan")).thenReturn(Cuenta.instance(1, "rabazan",
                LocalDateTime.of(2019, 12, 8, 12, 0, 0), "Rodrigo Bazan", "123456"));
        CuentaDTO buscada = consultarCuentaPorUsuarioAdapter.consultarCuentaPorUsuario("rabazan");
        Assertions.assertNotNull(buscada);
    }

    @Test
    void consultarCuentaPorUsuario_NoHayCoincidencia_DevuelveNull() throws CuentaIncompletaException {
        ConsultarCuentaPorUsuarioAdapter consultarCuentaPorUsuarioAdapter = new ConsultarCuentaPorUsuarioAdapter(consultarCuentaPorUsuarioInput);
        when(consultarCuentaPorUsuarioInput.consultarCuentaPorUsuario("rabazan")).thenReturn(null);
        CuentaDTO buscada = consultarCuentaPorUsuarioAdapter.consultarCuentaPorUsuario("rabazan");
        Assertions.assertNull(buscada);
    }
}
