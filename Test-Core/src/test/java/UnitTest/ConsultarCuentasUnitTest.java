package UnitTest;

import Mockito.MockitoExtension;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentas;
import UseCase.ConsultarCuentasUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentasUnitTest {

    @Mock
    IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    @Spy
    List<Cuenta> cuentas = factoryCuentas();

    @Test
    void consultarCuentas_ExistenCuentas_DevuelveListaCuentas() {
        ConsultarCuentasUseCase consultarCuentaUseCase = new ConsultarCuentasUseCase(iRepositorioConsultarCuentas);
        when(iRepositorioConsultarCuentas.findAll()).thenReturn(cuentas);
        List<Cuenta> cuentas = consultarCuentaUseCase.consultarCuentas();
        Assertions.assertEquals(3, cuentas.size());
    }

    @Test
    void consultarCuentas_NoExistenCuentas_DevuelveListaVacia() {
        ConsultarCuentasUseCase consultarCuentaUseCase = new ConsultarCuentasUseCase(iRepositorioConsultarCuentas);
        when(iRepositorioConsultarCuentas.findAll()).thenReturn(new ArrayList<>());
        List<Cuenta> cuentas = consultarCuentaUseCase.consultarCuentas();
        Assertions.assertEquals(0, cuentas.size());
    }


    private List<Cuenta> factoryCuentas() {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(Cuenta.instance(1, "rabazan", LocalDateTime.now(), "Rodrigo Bazan", "123456"));
            cuentas.add(Cuenta.instance(2, "gtorres", LocalDateTime.now(), "German Torres", "123456"));
            cuentas.add(Cuenta.instance(3, "jruitti", LocalDateTime.now(), "Javier Ruitti", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }


}
