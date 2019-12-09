package UseCase;

import Excepciones.CuentaExisteException;
import Input.CrearCuentaInput;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import Repository.IRepositorioCrearCuenta;
import Excepciones.PersistException;

public class CrearCuentaUseCase implements CrearCuentaInput {
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;
    private IRepositorioCrearCuenta iRepositorioCrearCuenta;

    public CrearCuentaUseCase(IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario,
                              IRepositorioCrearCuenta iRepositorioCrearCuenta) {
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
        this.iRepositorioCrearCuenta = iRepositorioCrearCuenta;
    }

    @Override
    public boolean crearCuenta(Cuenta cuenta) throws PersistException, CuentaExisteException {
        if (!existeCuenta(cuenta.getUsuario())) {
            if (this.iRepositorioCrearCuenta.persist(cuenta)) {
                return true;
            } else throw new PersistException();
        }
        throw new CuentaExisteException();

    }

    private boolean existeCuenta(String usuario) {
        return this.iRepositorioConsultarCuentaPorUsuario.findByUsuario(usuario) != null;
    }
}
