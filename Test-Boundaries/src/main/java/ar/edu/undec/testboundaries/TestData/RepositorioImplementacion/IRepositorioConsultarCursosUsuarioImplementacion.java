package ar.edu.undec.testboundaries.TestData.RepositorioImplementacion;

import Model.Curso;
import Repository.IRepositorioConsultarCursosUsuario;
import ar.edu.undec.testboundaries.TestData.Mapper.CursoMapper;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCursosUsuarioCRUD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class IRepositorioConsultarCursosUsuarioImplementacion implements IRepositorioConsultarCursosUsuario {

    private final IRepositorioConsultarCursosUsuarioCRUD iRepositorioConsultarCursosUsuarioCRUD;

    public IRepositorioConsultarCursosUsuarioImplementacion(IRepositorioConsultarCursosUsuarioCRUD iRepositorioConsultarCursosUsuarioCRUD) {
        this.iRepositorioConsultarCursosUsuarioCRUD = iRepositorioConsultarCursosUsuarioCRUD;
    }

    @Override
    public Collection<Curso> findByUsuario(String usuario) {
        List<Curso> cursos = new ArrayList<>();
        this.iRepositorioConsultarCursosUsuarioCRUD.findByInscriptos_UsuarioEquals(usuario)
                .forEach(cursoEntity -> cursos.add(CursoMapper.mapeoDataCore(cursoEntity)));
        return cursos;
    }
}
