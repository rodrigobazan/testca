package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Cuenta;
import Repository.IRepositorioCrearCuenta;
import ar.edu.undec.testboundaries.TestData.Mapper.CuentaMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioCrearCuentaCRUD;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioCrearCuentaImplementacion implements IRepositorioCrearCuenta {

    private final IRepositorioCrearCuentaCRUD iRepositorioCrearCuentaCRUD;

    private final IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD;

    public IRepositorioCrearCuentaImplementacion(IRepositorioCrearCuentaCRUD iRepositorioCrearCuentaCRUD,
                                                 IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD) {
        this.iRepositorioCrearCuentaCRUD = iRepositorioCrearCuentaCRUD;
        this.iRepositorioConsultarCuentaPorIdCRUD = iRepositorioConsultarCuentaPorIdCRUD;
    }

    @Override
    public boolean persist(Cuenta cuenta) {
        return this.iRepositorioCrearCuentaCRUD.save(CuentaMapper.mapeoCoreData(cuenta,
                iRepositorioConsultarCuentaPorIdCRUD)) != null;

    }
}
