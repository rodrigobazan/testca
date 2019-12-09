package Factory;

import Model.Cuenta;
import ModelDTO.CuentaDTO;

public class CuentaFactory {

    private CuentaFactory() {
    }

    public static CuentaDTO factoryCoreDTO(Cuenta cuenta) {
        try {
            return new CuentaDTO(cuenta.getIdCuenta(), cuenta.getUsuario(), cuenta.getFechaCreacion(),
                    cuenta.getNombre(), cuenta.getPass());

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Cuenta factoryDTOCore(CuentaDTO cuentaDTO) {
        try {
            return Cuenta.instance(cuentaDTO.idCuenta, cuentaDTO.usuario, cuentaDTO.fechaCreacion, cuentaDTO.nombre, cuentaDTO.pass);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
