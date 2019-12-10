package ar.edu.undec.testboundaries.TestData.RepositorioData;

import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioCrearCursoCRUD extends CrudRepository<CursoEntity, Integer> {

    CursoEntity save(CursoEntity cursoEntity);
}
