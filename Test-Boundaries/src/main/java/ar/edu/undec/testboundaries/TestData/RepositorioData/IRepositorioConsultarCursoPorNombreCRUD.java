package ar.edu.undec.testboundaries.TestData.RepositorioData;

import Model.Curso;
import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioConsultarCursoPorNombreCRUD extends CrudRepository<CursoEntity, Integer> {

    CursoEntity findByTituloEqualsIgnoreCase(String titulo);
}
