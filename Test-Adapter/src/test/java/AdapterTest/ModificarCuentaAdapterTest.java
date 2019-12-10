package AdapterTest;

import Adapter.ModificarCuentaAdapter;
import Excepciones.CuentaExisteException;
import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Excepciones.UpdateCuentaException;
import Input.ModificarCuentaInput;
import Mockito.MockitoExtension;
import Model.Cuenta;
import ModelDTO.CuentaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarCuentaAdapterTest {


    @Mock
    ModificarCuentaInput modificarCuentaInput;

    @Test
    void modificarCuenta_NoExisteCuentaUsuario_ModificaCorrectamente() throws UpdateCuentaException, CuentaExisteException, CuentaIncompletaException, FechaCreacionIncorrectaException {
        CuentaDTO cuentaModificada = new CuentaDTO(10, "rabazan", LocalDateTime.now(), "Rodrigo Andres Bazan", "654321");
        ModificarCuentaAdapter modificarCuentaAdapter = new ModificarCuentaAdapter(modificarCuentaInput);
        when(modificarCuentaInput.modificarCuenta(any(Cuenta.class))).thenReturn(Cuenta.instance(10, "rabazan", LocalDateTime.now(),
                "Rodrigo Andres Bazan", "654321"));
        CuentaDTO cuenta = modificarCuentaAdapter.modificarCuenta(cuentaModificada);
        Assertions.assertEquals("rabazan", cuenta.usuario);
    }

    @Test
    void modificarCuenta_ExisteCuentaUsuario_CuentaExisteException() throws UpdateCuentaException, CuentaExisteException {
        CuentaDTO cuentaModificada = new CuentaDTO(10, "rabazan", LocalDateTime.now(), "Rodrigo Andres Bazan", "654321");
        ModificarCuentaAdapter modificarCuentaAdapter = new ModificarCuentaAdapter(modificarCuentaInput);
        when(modificarCuentaInput.modificarCuenta(any(Cuenta.class))).thenThrow(CuentaExisteException.class);
        Assertions.assertThrows(CuentaExisteException.class, () -> modificarCuentaAdapter.modificarCuenta(cuentaModificada));
    }

}
