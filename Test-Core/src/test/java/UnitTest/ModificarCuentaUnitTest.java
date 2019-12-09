package UnitTest;

import Excepciones.CuentaExisteException;
import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Excepciones.UpdateCuentaException;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorId;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import Repository.IRepositorioModificarCuenta;
import UseCase.ModificarCuentaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModificarCuentaUnitTest {

    @Mock
    IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    @Mock
    IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Mock
    IRepositorioModificarCuenta iRepositorioModificarCuenta;

    @Test
    void modificarCuenta_NoExisteCuentaUsuario_ModificaCorrectamente() throws CuentaIncompletaException, FechaCreacionIncorrectaException, UpdateCuentaException, CuentaExisteException {
        Cuenta cuentaModificada = Cuenta.instance(10, "rabazan", LocalDateTime.now(), "Rodrigo Andres Bazan", "654321");
        Cuenta cuentaAModificar = Cuenta.instance(10, "rbazan", LocalDateTime.now(), "Rodrigo Bazan", "123456");
        ModificarCuentaUseCase modificarCuentaUseCase = new ModificarCuentaUseCase(iRepositorioConsultarCuentaPorId, iRepositorioModificarCuenta,
                iRepositorioConsultarCuentaPorUsuario);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(10)).thenReturn(cuentaAModificar);
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("rabazan")).thenReturn(null);
        when(iRepositorioModificarCuenta.update(cuentaAModificar)).thenReturn(true);
        Cuenta modificada = modificarCuentaUseCase.modificarCuenta(cuentaModificada);
        Assertions.assertEquals("rabazan", modificada.getUsuario());
    }

    @Test
    void modificarCuenta_ExisteCuentaUsuario_CuentaExisteException() throws CuentaIncompletaException, FechaCreacionIncorrectaException, UpdateCuentaException, CuentaExisteException {
        Cuenta cuentaModificada = Cuenta.instance(10, "rabazan", LocalDateTime.now(), "Rodrigo Andres Bazan", "654321");
        Cuenta cuentaAModificar = Cuenta.instance(10, "rbazan", LocalDateTime.now(), "Rodrigo Bazan", "123456");
        ModificarCuentaUseCase modificarCuentaUseCase = new ModificarCuentaUseCase(iRepositorioConsultarCuentaPorId, iRepositorioModificarCuenta,
                iRepositorioConsultarCuentaPorUsuario);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(10)).thenReturn(cuentaAModificar);
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("rabazan")).thenReturn(Cuenta.instance(1, "rabazan", LocalDateTime.now(),
                "Raquel Bazan", "987654"));
        Assertions.assertThrows(CuentaExisteException.class, () -> modificarCuentaUseCase.modificarCuenta(cuentaModificada));
    }

}
