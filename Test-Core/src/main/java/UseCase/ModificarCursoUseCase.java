package UseCase;

import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Excepciones.UpdateCursoException;
import Input.ModificarCursoInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;
import Repository.IRepositorioConsultarCursoPorNombre;
import Repository.IRepositorioModificarCurso;

import java.time.LocalDateTime;

public class ModificarCursoUseCase implements ModificarCursoInput {
    private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;
    private IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;
    private IRepositorioModificarCurso iRepositorioModificarCurso;

    public ModificarCursoUseCase(IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId,
                                 IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre,
                                 IRepositorioModificarCurso iRepositorioModificarCurso) {
        this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
        this.iRepositorioConsultarCursoPorNombre = iRepositorioConsultarCursoPorNombre;
        this.iRepositorioModificarCurso = iRepositorioModificarCurso;
    }

    public Curso modificarCurso(Curso cursoModificado) throws CursoExisteException, FechaLimiteIncorrectaException, UpdateCursoException {
        Curso cursoAModificar = this.iRepositorioConsultarCursoPorId.findByIdCurso(cursoModificado.getIdCurso());
        if ((cursoAModificar.getTitulo().equalsIgnoreCase(cursoModificado.getTitulo()) ||
                !cursoExiste(cursoModificado.getTitulo()))) {
            if(verificarFechaCorrecta(cursoAModificar, cursoModificado)){
                cursoAModificar.modificarDatos(cursoModificado);
                if (this.iRepositorioModificarCurso.update(cursoAModificar)) {
                    return cursoAModificar;
                } else throw new UpdateCursoException();
            }else throw new FechaLimiteIncorrectaException();

        } else throw new CursoExisteException();

    }

    private boolean verificarFechaCorrecta(Curso cursoAModificar, Curso cursoModificado) {
        if (cursoAModificar.getFechaLimiteInscripcion().equals(cursoModificado.getFechaLimiteInscripcion()))
            return true;
        else {
            return cursoModificado.getFechaLimiteInscripcion().isAfter(LocalDateTime.now());
        }
    }

    private boolean cursoExiste(String titulo) {
        return this.iRepositorioConsultarCursoPorNombre.findByTituloEquals(titulo) != null;
    }
}
