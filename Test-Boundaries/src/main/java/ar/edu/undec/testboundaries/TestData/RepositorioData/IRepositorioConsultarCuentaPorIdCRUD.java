package ar.edu.undec.testboundaries.TestData.RepositorioData;

import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioConsultarCuentaPorIdCRUD extends CrudRepository<CuentaEntity, Integer> {

    CuentaEntity findByIdCuenta(Integer idCuenta);

}
