package ModelTest;

import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Mockito.MockitoExtension;
import Model.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class CuentaUnitTest {

    @Test
    void crearCuenta_TodosLosCamposObligatorios_CrearInstancia() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        Cuenta cuenta = Cuenta.instance(null, "rabazan", LocalDateTime.of(2019, 12, 8, 12, 0, 0),
                "Rodrigo Bazan", "123456");
        Assertions.assertNotNull(cuenta);
    }

    @Test
    void crearCuenta_faltanCamposObligatorios_CuentaIncompletaException() {
        Assertions.assertThrows(CuentaIncompletaException.class, () -> Cuenta.instance(null, "rabazan", LocalDateTime.of(2019, 12, 8, 12, 0, 0),
                null, ""));
    }


    @Test
    void crearCuenta_fechaCreacionCorrecta_CreaInstancia() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        Cuenta cuenta = Cuenta.instance(null, "rabazan", LocalDateTime.now(),
                "Rodrigo Bazan", "123456");
        Assertions.assertNotNull(cuenta);
    }

    @Test
    void crearCuenta_fechaCreacionIncorrecta_FechaCreacionIncorrectaException() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        Assertions.assertThrows(FechaCreacionIncorrectaException.class, () -> Cuenta.instance(null, "rabazan",
                LocalDateTime.now().plusDays(1), "Rodrigo Bazan", "123456"));
    }

}
