package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Cuenta;
import Repository.IRepositorioModificarCuenta;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioModificarCuentaCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioModificarCuentaImplementacion implements IRepositorioModificarCuenta {

    private final IRepositorioModificarCuentaCRUD iRepositorioModificarCuentaCRUD;

    public IRepositorioModificarCuentaImplementacion(IRepositorioModificarCuentaCRUD iRepositorioModificarCuentaCRUD) {
        this.iRepositorioModificarCuentaCRUD = iRepositorioModificarCuentaCRUD;
    }

    @Override
    public boolean update(Cuenta cuentaAModificar) {
        CuentaEntity cuentaEntity = new CuentaEntity(cuentaAModificar.getUsuario(), cuentaAModificar.getFechaCreacion(), cuentaAModificar.getNombre(), cuentaAModificar.getPass());
        cuentaEntity.setIdCuenta(cuentaAModificar.getIdCuenta());
        return this.iRepositorioModificarCuentaCRUD.save(cuentaEntity) != null;
    }
}
