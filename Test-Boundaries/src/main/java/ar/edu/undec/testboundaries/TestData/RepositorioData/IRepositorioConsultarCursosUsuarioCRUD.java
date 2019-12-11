package ar.edu.undec.testboundaries.TestData.RepositorioData;

import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IRepositorioConsultarCursosUsuarioCRUD extends CrudRepository<CursoEntity, Integer> {

    Collection<CursoEntity> findByInscriptos_UsuarioEquals(String usuario);

}
