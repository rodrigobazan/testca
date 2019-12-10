package ar.edu.undec.testboundaries.TestData.RepositorioData;

import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface IRepositorioConsultarCursoPorIdCRUD extends CrudRepository<CursoEntity, Integer> {

    CursoEntity findByIdCurso(Integer idCurso);

}
