package Input;

import Excepciones.CuentaExisteException;
import Excepciones.UpdateCuentaException;
import Model.Cuenta;

public interface ModificarCuentaInput {

    Cuenta modificarCuenta(Cuenta cuentaModificada) throws UpdateCuentaException, CuentaExisteException;
}
