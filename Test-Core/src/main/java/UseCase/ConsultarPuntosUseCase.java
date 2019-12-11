package UseCase;

import Input.ConsultarPuntosInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursosPorUsuario;

import java.util.List;

public class ConsultarPuntosUseCase implements ConsultarPuntosInput {


    private IRepositorioConsultarCursosPorUsuario iRepositorioConsultarCursosPorUsuario;

    public ConsultarPuntosUseCase(IRepositorioConsultarCursosPorUsuario iRepositorioConsultarCursosPorUsuario) {
        this.iRepositorioConsultarCursosPorUsuario = iRepositorioConsultarCursosPorUsuario;
    }

    public int consultarPuntosCuenta(String usuario) {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursosPorUsuario.findByUsuario(usuario);
        return cursos.stream().mapToInt(Curso::getPuntos).sum();
    }
}
