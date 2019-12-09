package AdapterTest;

import Adapter.CrearCuentaAdapter;
import Excepciones.CuentaExisteException;
import Excepciones.PersistException;
import Input.CrearCuentaInput;
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
public class CrearCuentaAdapterTest {

    @Mock
    CrearCuentaInput crearCuentaInput;

    @Test
    void creacCuenta_NoExisteUsuarioCuenta_DevuelveTrue() throws PersistException, CuentaExisteException {
        CuentaDTO cuentaDTO = new CuentaDTO(null, "rabazan", LocalDateTime.now(),
                "Rodrigo Bazan", "123456");
        CrearCuentaAdapter crearCuentaAdapter = new CrearCuentaAdapter(crearCuentaInput);
        when(crearCuentaInput.crearCuenta(any(Cuenta.class))).thenReturn(true);
        boolean resultado = crearCuentaAdapter.crearCuenta(cuentaDTO);
        Assertions.assertTrue(resultado);
    }

    @Test
    void creacCuenta_ExisteUsuarioCuenta_CuentaExisteException() throws PersistException, CuentaExisteException {
        CuentaDTO cuentaDTO = new CuentaDTO(null, "rabazan", LocalDateTime.now(),
                "Rodrigo Bazan", "123456");
        CrearCuentaAdapter crearCuentaAdapter = new CrearCuentaAdapter(crearCuentaInput);
        when(crearCuentaInput.crearCuenta(any(Cuenta.class))).thenThrow(CuentaExisteException.class);
        Assertions.assertThrows(CuentaExisteException.class, () -> crearCuentaAdapter.crearCuenta(cuentaDTO));
    }

}
