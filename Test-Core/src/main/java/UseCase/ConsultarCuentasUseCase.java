package UseCase;

import Input.ConsultarCuentasInput;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentas;

import java.util.List;

public class ConsultarCuentasUseCase implements ConsultarCuentasInput {
    private IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    public ConsultarCuentasUseCase(IRepositorioConsultarCuentas iRepositorioConsultarCuentas) {
        this.iRepositorioConsultarCuentas = iRepositorioConsultarCuentas;
    }

    public List<Cuenta> consultarCuentas() {
        return (List<Cuenta>) this.iRepositorioConsultarCuentas.findAll();
    }
}
