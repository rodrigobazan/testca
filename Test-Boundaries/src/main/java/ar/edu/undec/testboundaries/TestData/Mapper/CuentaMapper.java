package ar.edu.undec.testboundaries.TestData.Mapper;

import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;

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
}
