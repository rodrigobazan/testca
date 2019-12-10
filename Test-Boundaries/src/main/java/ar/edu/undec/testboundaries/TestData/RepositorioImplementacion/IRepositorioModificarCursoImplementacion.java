package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Curso;
import Repository.IRepositorioModificarCurso;
import ar.edu.undec.testboundaries.TestData.Mapper.CuentaMapper;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioModificarCursoCRUD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRepositorioModificarCursoImplementacion implements IRepositorioModificarCurso {

    private final IRepositorioModificarCursoCRUD iRepositorioModificarCursoCRUD;

    private final IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD;

    public IRepositorioModificarCursoImplementacion(IRepositorioModificarCursoCRUD iRepositorioModificarCursoCRUD,
                                                    IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD) {
        this.iRepositorioModificarCursoCRUD = iRepositorioModificarCursoCRUD;
        this.iRepositorioConsultarCuentaPorIdCRUD = iRepositorioConsultarCuentaPorIdCRUD;
    }

    @Override
    public boolean update(Curso cursoAModificar) {
        List<CuentaEntity> cuentaEntities = new ArrayList<>();
        cursoAModificar.getInscriptos().forEach(cuenta -> cuentaEntities.add(CuentaMapper.mapeoCoreData(cuenta, iRepositorioConsultarCuentaPorIdCRUD)));
        CursoEntity cursoEntity = new CursoEntity(cursoAModificar.getTitulo(), cuentaEntities, cursoAModificar.getFechaLimiteInscripcion(),
                cursoAModificar.getPuntos());
        cursoEntity.setIdCurso(cursoAModificar.getIdCurso());
        return this.iRepositorioModificarCursoCRUD.save(cursoEntity) != null;
    }
}
