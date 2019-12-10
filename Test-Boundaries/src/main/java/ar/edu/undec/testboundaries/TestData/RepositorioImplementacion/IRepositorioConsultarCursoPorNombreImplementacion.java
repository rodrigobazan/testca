package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Curso;
import Repository.IRepositorioConsultarCursoPorNombre;
import ar.edu.undec.testboundaries.TestData.Mapper.CursoMapper;
import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCursoPorNombreCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioConsultarCursoPorNombreImplementacion implements IRepositorioConsultarCursoPorNombre {

    private final IRepositorioConsultarCursoPorNombreCRUD iRepositorioConsultarCursoPorNombreCRUD;

    public IRepositorioConsultarCursoPorNombreImplementacion(IRepositorioConsultarCursoPorNombreCRUD iRepositorioConsultarCursoPorNombreCRUD) {
        this.iRepositorioConsultarCursoPorNombreCRUD = iRepositorioConsultarCursoPorNombreCRUD;
    }

    @Override
    public Curso findByTituloEquals(String nombre) {
        CursoEntity cursoEntity = this.iRepositorioConsultarCursoPorNombreCRUD.findByTituloEqualsIgnoreCase(nombre);
        if (cursoEntity != null) return CursoMapper.mapeoDataCore(cursoEntity);
        return null;
    }
}
