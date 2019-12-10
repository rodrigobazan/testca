package ar.edu.undec.testboundaries.TestData.RepositorioData;

import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioModificarCursoCRUD extends CrudRepository<CursoEntity, Integer> {

    CursoEntity save(CursoEntity cursoEntity);

}
