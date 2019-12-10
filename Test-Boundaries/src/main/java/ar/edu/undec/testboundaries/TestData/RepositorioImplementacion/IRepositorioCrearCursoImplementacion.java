package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Curso;
import Repository.IRepositorioCrearCurso;
import ar.edu.undec.testboundaries.TestData.Mapper.CursoMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCursoPorIdCRUD;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioCrearCursoCRUD;
import org.springframework.stereotype.Service;

@Service
public class IRepositorioCrearCursoImplementacion implements IRepositorioCrearCurso {

    private final IRepositorioCrearCursoCRUD iRepositorioCrearCursoCRUD;

    private final IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD;

    private final IRepositorioConsultarCursoPorIdCRUD iRepositorioConsultarCursoPorIdCRUD;

    public IRepositorioCrearCursoImplementacion(IRepositorioCrearCursoCRUD iRepositorioCrearCursoCRUD,
                                                IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD,
                                                IRepositorioConsultarCursoPorIdCRUD iRepositorioConsultarCursoPorIdCRUD) {
        this.iRepositorioCrearCursoCRUD = iRepositorioCrearCursoCRUD;
        this.iRepositorioConsultarCuentaPorIdCRUD = iRepositorioConsultarCuentaPorIdCRUD;
        this.iRepositorioConsultarCursoPorIdCRUD = iRepositorioConsultarCursoPorIdCRUD;
    }

    @Override
    public boolean persist(Curso curso) {
        return this.iRepositorioCrearCursoCRUD
                .save(CursoMapper.mapeoCoreData(curso, iRepositorioConsultarCuentaPorIdCRUD,
                        iRepositorioConsultarCursoPorIdCRUD)) != null;
    }
}
