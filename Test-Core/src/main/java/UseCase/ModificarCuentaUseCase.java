package UseCase;

import Excepciones.CuentaExisteException;
import Excepciones.UpdateCuentaException;
import Input.ModificarCuentaInput;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorId;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import Repository.IRepositorioModificarCuenta;

public class ModificarCuentaUseCase implements ModificarCuentaInput {
    private IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;
    private IRepositorioModificarCuenta iRepositorioModificarCuenta;
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    public ModificarCuentaUseCase(IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId,
                                  IRepositorioModificarCuenta iRepositorioModificarCuenta,
                                  IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario) {
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
        this.iRepositorioModificarCuenta = iRepositorioModificarCuenta;
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
    }

    public Cuenta modificarCuenta(Cuenta cuentaModificada) throws UpdateCuentaException, CuentaExisteException {
        Cuenta cuentaAModificar = this.iRepositorioConsultarCuentaPorId.findByIdCuenta(cuentaModificada.getIdCuenta());
        if (cuentaAModificar.getUsuario().equalsIgnoreCase(cuentaModificada.getUsuario()) || !cuentaExiste(cuentaModificada.getUsuario())) {
            cuentaAModificar.modificarDatos(cuentaModificada);
            if (this.iRepositorioModificarCuenta.update(cuentaAModificar)) {
                return cuentaModificada;
            } else throw new UpdateCuentaException();
        } else throw new CuentaExisteException();
    }

    private boolean cuentaExiste(String usuario) {
        return this.iRepositorioConsultarCuentaPorUsuario.findByUsuario(usuario) != null;
    }


}
