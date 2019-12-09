package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Cuenta;
import Repository.IRepositorioConsultarCuentaPorId;
import ar.edu.undec.testboundaries.TestData.Mapper.CuentaMapper;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioConsultarCuentaPorIdImplementacion implements IRepositorioConsultarCuentaPorId {

    private final
    IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD;

    public IRepositorioConsultarCuentaPorIdImplementacion(IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD) {
        this.iRepositorioConsultarCuentaPorIdCRUD = iRepositorioConsultarCuentaPorIdCRUD;
    }

    @Override
    public Cuenta findByIdCuenta(Integer idCuenta) {
        CuentaEntity cuentaEntity = this.iRepositorioConsultarCuentaPorIdCRUD.findByIdCuenta(idCuenta);
        if (cuentaEntity != null) return CuentaMapper.mapeoDataCore(cuentaEntity);
        return null;
    }
}
