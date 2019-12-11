package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Curso;
import Repository.IRepositorioConsultarCursos;
import ar.edu.undec.testboundaries.TestData.Mapper.CursoMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCursosCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class IRepositorioConsultarCursosImplementacion implements IRepositorioConsultarCursos {

    private final IRepositorioConsultarCursosCRUD iRepositorioConsultarCursosCRUD;

    public IRepositorioConsultarCursosImplementacion(IRepositorioConsultarCursosCRUD iRepositorioConsultarCursosCRUD) {
        this.iRepositorioConsultarCursosCRUD = iRepositorioConsultarCursosCRUD;
    }

    @Override
    public Collection<Curso> findAll() {
        List<Curso> cursos = new ArrayList<>();
        this.iRepositorioConsultarCursosCRUD.findAll()
                .forEach(cursoEntity -> cursos.add(CursoMapper.mapeoDataCore(cursoEntity)));
        return cursos;
    }
}
