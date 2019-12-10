package UseCase;

import Input.ConsultarCursoPorIdInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;

public class ConsultarCursoPorIdUseCase implements ConsultarCursoPorIdInput {
    private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    public ConsultarCursoPorIdUseCase(IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId) {
        this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
    }

    public Curso consultarCursoPorId(Integer idCurso) {
        return this.iRepositorioConsultarCursoPorId.findByIdCurso(idCurso);
    }
}
