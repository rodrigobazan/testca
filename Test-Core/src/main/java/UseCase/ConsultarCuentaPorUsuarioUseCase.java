package UseCase;

import Input.ConsultarCuentaPorUsuarioInput;
import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorUsuario;

public class ConsultarCuentaPorUsuarioUseCase implements ConsultarCuentaPorUsuarioInput {
    private IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario;

    public ConsultarCuentaPorUsuarioUseCase(IRepositorioConsultarCuentaPorUsuario iRepositorioConsultarCuentaPorUsuario) {
        this.iRepositorioConsultarCuentaPorUsuario = iRepositorioConsultarCuentaPorUsuario;
    }

    public Cuenta consultarCuentaPorUsuario(String usuario) {
        return this.iRepositorioConsultarCuentaPorUsuario.findByUsuario(usuario);

    }
}
