package UnitTest;

import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorId;
import UseCase.ConsultarCuentaPorIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentaPorIdUnitTest {

    @Mock
    IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    @Test
    void consultarCuentaPorId_ExisteId_DevuelveCuenta() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        ConsultarCuentaPorIdUseCase consultarCuentaPorIdUseCase = new ConsultarCuentaPorIdUseCase(iRepositorioConsultarCuentaPorId);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(1)).thenReturn(Cuenta.instance(1, "rabazan", LocalDateTime.now(),
                "Rodrigo Bazan", "123456"));
        Cuenta buscada = consultarCuentaPorIdUseCase.consultarCuentaPorId(1);
        Assertions.assertEquals("rabazan", buscada.getUsuario());
    }

}
