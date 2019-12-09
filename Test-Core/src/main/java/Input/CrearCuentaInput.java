package Input;

import Excepciones.CuentaExisteException;
import Model.Cuenta;
import Excepciones.PersistException;

public interface CrearCuentaInput {
    boolean crearCuenta(Cuenta cuenta) throws PersistException, CuentaExisteException;
}
