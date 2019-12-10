package AdapterTest;

import Adapter.ConsultarCuentasAdapter;
import Input.ConsultarCuentasInput;
import Mockito.MockitoExtension;
import Model.Cuenta;
import ModelDTO.CuentaDTO;
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
public class ConsultarCuentasAdapterTest {

    @Mock
    ConsultarCuentasInput consultarCuentasInput;

    @Spy
    List<Cuenta> cuentas = factoryCuentas();

    @Test
    void consultaCuentas_ExisteCuentas_DevuelveListaCuentasDTO() {
        ConsultarCuentasAdapter consultarCuentasAdapter = new ConsultarCuentasAdapter(consultarCuentasInput);
        when(consultarCuentasInput.consultarCuentas()).thenReturn(cuentas);
        List<CuentaDTO> cuentaDTOS = consultarCuentasAdapter.consultarCuentas();
        Assertions.assertEquals(3, cuentaDTOS.size());
    }

    @Test
    void consultaCuentas_NoExisteCuentas_DevuelveListaVacia() {
        ConsultarCuentasAdapter consultarCuentasAdapter = new ConsultarCuentasAdapter(consultarCuentasInput);
        when(consultarCuentasInput.consultarCuentas()).thenReturn(new ArrayList<>());
        List<CuentaDTO> cuentaDTOS = consultarCuentasAdapter.consultarCuentas();
        Assertions.assertEquals(0, cuentaDTOS.size());
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
