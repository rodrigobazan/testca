package ar.edu.undec.testboundaries.TestData.RepositorioData;

import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IRepositorioConsultarCuentasCRUD extends CrudRepository<CuentaEntity, Integer> {

    Collection<CuentaEntity> findAll();

}
