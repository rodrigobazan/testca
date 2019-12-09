package Repository;

import Model.Cuenta;

public interface IRepositorioConsultarCuentaPorUsuario {
    Cuenta findByUsuario(String usuario);
}
