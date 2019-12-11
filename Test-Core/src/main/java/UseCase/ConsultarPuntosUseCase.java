package UseCase;

import Input.ConsultarPuntosInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursosUsuario;

import java.util.List;

public class ConsultarPuntosUseCase implements ConsultarPuntosInput {


    private IRepositorioConsultarCursosUsuario iRepositorioConsultarCursosUsuario;

    public ConsultarPuntosUseCase(IRepositorioConsultarCursosUsuario iRepositorioConsultarCursosUsuario) {
        this.iRepositorioConsultarCursosUsuario = iRepositorioConsultarCursosUsuario;
    }

    public int consultarPuntosCuenta(String usuario) {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursosUsuario.findByUsuario(usuario);
        return cursos.stream().mapToInt(Curso::getPuntos).sum();
    }
}
