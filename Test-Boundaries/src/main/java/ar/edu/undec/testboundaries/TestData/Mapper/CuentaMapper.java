package ar.edu.undec.testboundaries.TestData.Mapper;

import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;

public class CuentaMapper {

    private CuentaMapper() {
    }

    public static Cuenta mapeoDataCore(CuentaEntity cuenta) {
        try {
            return Cuenta.instance(cuenta.getIdCuenta(), cuenta.getUsuario(), cuenta.getFechaCreacion(), cuenta.getNombre(),
                    cuenta.getPass());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CuentaEntity mapeoCoreData(Cuenta cuenta,
                                             IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD) {
        try {
            if (cuenta.getIdCuenta() == null) {
                return new CuentaEntity(cuenta.getUsuario(), cuenta.getFechaCreacion(), cuenta.getNombre(), cuenta.getPass());
            }
            return iRepositorioConsultarCuentaPorIdCRUD.findByIdCuenta(cuenta.getIdCuenta());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
