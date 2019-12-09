package Adapter;

import Factory.CuentaFactory;
import Input.ConsultarCuentaPorIdInput;
import ModelDTO.CuentaDTO;

public class ConsultarCuentaPorIdAdapter {
    private ConsultarCuentaPorIdInput consultarCuentaPorIdInput;

    public ConsultarCuentaPorIdAdapter(ConsultarCuentaPorIdInput consultarCuentaPorIdInput) {
        this.consultarCuentaPorIdInput = consultarCuentaPorIdInput;
    }

    public CuentaDTO consultarCuentaPorId(Integer idCuenta) {
        return CuentaFactory.factoryCoreDTO(this.consultarCuentaPorIdInput.consultarCuentaPorId(idCuenta));
    }
}
