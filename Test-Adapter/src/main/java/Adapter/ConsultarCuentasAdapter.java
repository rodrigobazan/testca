package Adapter;

import Factory.CuentaFactory;
import Input.ConsultarCuentasInput;
import ModelDTO.CuentaDTO;

import java.util.ArrayList;
import java.util.List;

public class ConsultarCuentasAdapter {
    private ConsultarCuentasInput consultarCuentasInput;

    public ConsultarCuentasAdapter(ConsultarCuentasInput consultarCuentasInput) {
        this.consultarCuentasInput = consultarCuentasInput;
    }

    public List<CuentaDTO> consultarCuentas() {
        List<CuentaDTO> cuentaDTOS = new ArrayList<>();
        this.consultarCuentasInput.consultarCuentas()
                .forEach(cuenta -> cuentaDTOS.add(CuentaFactory.factoryCoreDTO(cuenta)));
        return cuentaDTOS;
    }
}
