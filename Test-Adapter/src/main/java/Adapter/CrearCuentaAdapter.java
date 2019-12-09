package Adapter;

import Excepciones.CuentaExisteException;
import Excepciones.PersistException;
import Factory.CuentaFactory;
import Input.CrearCuentaInput;
import ModelDTO.CuentaDTO;

public class CrearCuentaAdapter {
    private CrearCuentaInput crearCuentaInput;

    public CrearCuentaAdapter(CrearCuentaInput crearCuentaInput) {
        this.crearCuentaInput = crearCuentaInput;
    }

    public boolean crearCuenta(CuentaDTO cuentaDTO) throws PersistException, CuentaExisteException {
        return this.crearCuentaInput.crearCuenta(CuentaFactory.factoryDTOCore(cuentaDTO));
    }
}
