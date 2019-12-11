package UseCase;

import Input.ConsultarCursosInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursos;

import java.util.List;

public class ConsultarCursosUseCase implements ConsultarCursosInput {
    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ConsultarCursosUseCase(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    public List<Curso> consultarCursos() {
        return (List<Curso>) this.iRepositorioConsultarCursos.findAll();
    }
}
