package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;
import ar.edu.undec.testboundaries.TestData.Mapper.CursoMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCursoPorIdCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioConsultarCursoPorIdImplementacion implements IRepositorioConsultarCursoPorId {

    private final IRepositorioConsultarCursoPorIdCRUD iRepositorioConsultarCursoPorIdCRUD;

    public IRepositorioConsultarCursoPorIdImplementacion(IRepositorioConsultarCursoPorIdCRUD iRepositorioConsultarCursoPorIdCRUD) {
        this.iRepositorioConsultarCursoPorIdCRUD = iRepositorioConsultarCursoPorIdCRUD;
    }

    @Override
    public Curso findByIdCurso(Integer idCurso) {
        return CursoMapper.mapeoDataCore(this.iRepositorioConsultarCursoPorIdCRUD.findByIdCurso(idCurso));
    }
}
