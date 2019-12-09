package UnitTest;

import Excepciones.FechaCreacionIncorrectaException;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import UseCase.ConsultarCuentaPorUsuarioUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import Excepciones.CuentaIncompletaException;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentaPorUsuarioUnitTest {

    @Mock
    IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    @Test
    void consultarCuentaPorUsuario_HayCoincidencia_DevuelveCuenta() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        ConsultarCuentaPorUsuarioUseCase consultarCuentaPorUsuarioUseCase = new ConsultarCuentaPorUsuarioUseCase(iRepositorioConsultarCuentaPorUsuario);
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("rabazan")).thenReturn(Cuenta.instance(1, "rabazan",
                LocalDateTime.of(2019, 12, 8, 12, 0, 0), "Rodrigo Bazan", "37415281"));
        Cuenta buscada = consultarCuentaPorUsuarioUseCase.consultarCuentaPorUsuario("rabazan");
        Assertions.assertNotNull(buscada);
    }

    @Test
    void consultarCuentaPorUsuario_NoHayCoincidencia_DevuelveNull() throws CuentaIncompletaException {
        ConsultarCuentaPorUsuarioUseCase consultarCuentaPorUsuarioUseCase = new ConsultarCuentaPorUsuarioUseCase(iRepositorioConsultarCuentaPorUsuario);
        when(iRepositorioConsultarCuentaPorUsuario.findByUsuario("rabazan")).thenReturn(null);
        Cuenta buscada = consultarCuentaPorUsuarioUseCase.consultarCuentaPorUsuario("rabazan");
        Assertions.assertNull(buscada);
    }


}
