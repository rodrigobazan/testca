package AdapterTest;

import Adapter.ConsultarCuentaPorIdAdapter;
import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Input.ConsultarCuentaPorIdInput;
import Mockito.MockitoExtension;
import Model.Cuenta;
import ModelDTO.CuentaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentaPorIdAdapterTest {

    @Mock
    ConsultarCuentaPorIdInput consultarCuentaPorIdInput;

    @Test
    void consultarCuentaPorId_existeId_DevuelveCuentaDTO() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        ConsultarCuentaPorIdAdapter consultarCuentaPorIdAdapter = new ConsultarCuentaPorIdAdapter(consultarCuentaPorIdInput);
        when(consultarCuentaPorIdInput.consultarCuentaPorId(1)).thenReturn(Cuenta.instance(1, "rabazan",
                LocalDateTime.now(), "Rodrigo Bazan", "123546"));
        CuentaDTO buscada = consultarCuentaPorIdAdapter.consultarCuentaPorId(1);
        Assertions.assertEquals("rabazan", buscada.usuario);
    }

}
