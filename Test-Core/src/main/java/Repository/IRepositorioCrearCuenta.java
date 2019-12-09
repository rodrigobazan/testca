package Repository;

import Model.Cuenta;

public interface IRepositorioCrearCuenta {
    boolean persist(Cuenta cuenta);
}
