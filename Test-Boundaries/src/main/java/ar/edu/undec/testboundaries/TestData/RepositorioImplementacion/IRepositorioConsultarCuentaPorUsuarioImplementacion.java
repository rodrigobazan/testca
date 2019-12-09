package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorUsuario;
import ar.edu.undec.testboundaries.TestData.Mapper.CuentaMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorUsuarioCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioConsultarCuentaPorUsuarioImplementacion implements IRepositorioConsultarCuentaPorUsuario {

    private final IRepositorioConsultarCuentaPorUsuarioCRUD iRepositorioConsultarCuentaPorUsuarioCRUD;

    public IRepositorioConsultarCuentaPorUsuarioImplementacion(IRepositorioConsultarCuentaPorUsuarioCRUD iRepositorioConsultarCuentaPorUsuarioCRUD) {
        this.iRepositorioConsultarCuentaPorUsuarioCRUD = iRepositorioConsultarCuentaPorUsuarioCRUD;
    }

    @Override
    public Cuenta findByUsuario(String usuario) {
        return CuentaMapper.mapeoDataCore(this.iRepositorioConsultarCuentaPorUsuarioCRUD.findByUsuarioEquals(usuario));
    }
}
