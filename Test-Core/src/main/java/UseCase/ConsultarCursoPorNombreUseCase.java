package UseCase;

import Input.ConsultarCursoPorNombreInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorNombre;

public class ConsultarCursoPorNombreUseCase implements ConsultarCursoPorNombreInput {
    private IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;

    public ConsultarCursoPorNombreUseCase(IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre) {
        this.iRepositorioConsultarCursoPorNombre = iRepositorioConsultarCursoPorNombre;
    }

    public Curso consultarCursoPorNombre(String nombre) {
        return this.iRepositorioConsultarCursoPorNombre.findByTituloEquals(nombre);
    }
}
