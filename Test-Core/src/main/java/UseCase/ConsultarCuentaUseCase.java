package UseCase;

import Input.ConsultarCuentaInput;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentas;

import java.util.List;

public class ConsultarCuentaUseCase implements ConsultarCuentaInput {
    private IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    public ConsultarCuentaUseCase(IRepositorioConsultarCuentas iRepositorioConsultarCuentas) {
        this.iRepositorioConsultarCuentas = iRepositorioConsultarCuentas;
    }

    public List<Cuenta> consultarCuentas() {
        return (List<Cuenta>) this.iRepositorioConsultarCuentas.findAll();
    }
}
