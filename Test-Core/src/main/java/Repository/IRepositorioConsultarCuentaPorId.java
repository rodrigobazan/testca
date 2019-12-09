package Repository;

import Model.Cuenta;

public interface IRepositorioConsultarCuentaPorId {
    Cuenta findByIdCuenta(Integer idCuenta);
}
