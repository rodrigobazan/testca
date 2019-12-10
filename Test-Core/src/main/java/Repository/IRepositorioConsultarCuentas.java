package Repository;

import Model.Cuenta;

import java.util.Collection;
import java.util.List;

public interface IRepositorioConsultarCuentas {
    Collection<Cuenta> findAll();
}
