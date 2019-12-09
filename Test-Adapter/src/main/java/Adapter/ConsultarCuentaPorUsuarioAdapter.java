package Adapter;

import Factory.CuentaFactory;
import Input.ConsultarCuentaPorUsuarioInput;
import Model.Cuenta;
import ModelDTO.CuentaDTO;

public class ConsultarCuentaPorUsuarioAdapter {
    private ConsultarCuentaPorUsuarioInput consultarCuentaPorUsuarioInput;

    public ConsultarCuentaPorUsuarioAdapter(ConsultarCuentaPorUsuarioInput consultarCuentaPorUsuarioInput) {
        this.consultarCuentaPorUsuarioInput = consultarCuentaPorUsuarioInput;
    }

    public CuentaDTO consultarCuentaPorUsuario(String usuario) {
        return CuentaFactory.factoryCoreDTO(this.consultarCuentaPorUsuarioInput.consultarCuentaPorUsuario(usuario));
    }
}
