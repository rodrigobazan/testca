package UnitTest;

import Excepciones.CuentaExisteException;
import Excepciones.PersistException;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import Repository.IRepositorioCrearCuenta;
import UseCase.CrearCuentaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCuentaUnitTest {

    @Mock
    IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Mock
    IRepositorioCrearCuenta iRepositorioCrearCuenta;

    @Test
    void crearCuenta_NoExisteUsuarioCuenta_CreaCorrectamente() throws CuentaIncompletaException, FechaCreacionIncorrectaException, PersistException, CuentaExisteException {
        Cuenta cuenta = Cuenta.instance(null, "rabazan", LocalDateTime.of(2019, 12, 8, 12, 0, 0),
                "Rodrigo Bazan", "123456");
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("rabazan")).thenReturn(null);
        when(iRepositorioCrearCuenta.persist(cuenta)).thenReturn(true);
        CrearCuentaUseCase crearCuentaUseCase = new CrearCuentaUseCase(iRepositorioConsultarCuentaPorUsuario, iRepositorioCrearCuenta);
        boolean resultado = crearCuentaUseCase.crearCuenta(cuenta);
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearCuenta_ExisteUsuarioCuenta_CuentaExisteException() throws CuentaIncompletaException, FechaCreacionIncorrectaException, PersistException, CuentaExisteException {
        Cuenta cuenta = Cuenta.instance(1, "rabazan", LocalDateTime.of(2019, 12, 8, 12, 0, 0),
                "Rodrigo Bazan", "123456");
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("rabazan")).thenReturn(cuenta);
        CrearCuentaUseCase crearCuentaUseCase = new CrearCuentaUseCase(iRepositorioConsultarCuentaPorUsuario, iRepositorioCrearCuenta);
        Assertions.assertThrows(CuentaExisteException.class, () -> crearCuentaUseCase.crearCuenta(cuenta));
    }

}
