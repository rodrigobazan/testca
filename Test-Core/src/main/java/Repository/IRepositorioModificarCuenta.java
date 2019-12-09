package Repository;

import Model.Cuenta;

public interface IRepositorioModificarCuenta {
    boolean update(Cuenta cuentaAModificar);
}
