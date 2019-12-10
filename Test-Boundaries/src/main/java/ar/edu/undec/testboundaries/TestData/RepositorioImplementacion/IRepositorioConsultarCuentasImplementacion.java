package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Cuenta;
import Repository.IRepositorioConsultarCuentas;
import ar.edu.undec.testboundaries.TestData.Mapper.CuentaMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentasCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class IRepositorioConsultarCuentasImplementacion implements IRepositorioConsultarCuentas {

    private final IRepositorioConsultarCuentasCRUD iRepositorioConsultarCuentasCRUD;

    public IRepositorioConsultarCuentasImplementacion(IRepositorioConsultarCuentasCRUD iRepositorioConsultarCuentasCRUD) {
        this.iRepositorioConsultarCuentasCRUD = iRepositorioConsultarCuentasCRUD;
    }

    @Override
    public Collection<Cuenta> findAll() {
        List<Cuenta> cuentas = new ArrayList<>();
        this.iRepositorioConsultarCuentasCRUD.findAll()
                .forEach(cuentaEntity -> cuentas.add(CuentaMapper.mapeoDataCore(cuentaEntity)));
        return cuentas;
    }
}
