package UseCase;

import Input.ConsultarCuentaPorIdInput;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorId;

public class ConsultarCuentaPorIdUseCase implements ConsultarCuentaPorIdInput {
    private IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    public ConsultarCuentaPorIdUseCase(IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId) {
        this.iRepositorioConsultarCuentaPorId = iRepositorioConsultarCuentaPorId;
    }

    public Cuenta consultarCuentaPorId(Integer idCuenta) {
        return this.iRepositorioConsultarCuentaPorId.findByIdCuenta(idCuenta);
    }
}
