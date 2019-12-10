package Adapter;

import Excepciones.CuentaExisteException;
import Excepciones.UpdateCuentaException;
import Factory.CuentaFactory;
import Input.ModificarCuentaInput;
import Model.Cuenta;
import ModelDTO.CuentaDTO;

public class ModificarCuentaAdapter {
    private ModificarCuentaInput modificarCuentaInput;

    public ModificarCuentaAdapter(ModificarCuentaInput modificarCuentaInput) {
        this.modificarCuentaInput = modificarCuentaInput;
    }

    public CuentaDTO modificarCuenta(CuentaDTO cuentaModificada) throws UpdateCuentaException, CuentaExisteException {
        Cuenta cuenta = this.modificarCuentaInput.modificarCuenta(CuentaFactory.factoryDTOCore(cuentaModificada));
        if (cuenta != null) return CuentaFactory.factoryCoreDTO(cuenta);
        return null;
    }
}
