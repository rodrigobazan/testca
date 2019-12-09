package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Cuenta;
import Repository.IRepositorioCrearCuenta;
import ar.edu.undec.testboundaries.TestData.Mapper.CuentaMapper;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioCrearCuentaCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioCrearCuentaImplementacion implements IRepositorioCrearCuenta {

    private final IRepositorioCrearCuentaCRUD iRepositorioCrearCuentaCRUD;

    public IRepositorioCrearCuentaImplementacion(IRepositorioCrearCuentaCRUD iRepositorioCrearCuentaCRUD) {
        this.iRepositorioCrearCuentaCRUD = iRepositorioCrearCuentaCRUD;
    }

    @Override
    public boolean persist(Cuenta cuenta) {
        return this.iRepositorioCrearCuentaCRUD.save(CuentaMapper.mapeoCoreData(cuenta)) != null;

    }
}
