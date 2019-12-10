package UseCase;

import Excepciones.CursoExisteException;
import Excepciones.PersistException;
import Input.CrearCursoInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorNombre;
import Repository.IRepositorioCrearCurso;

public class CrearCursoUseCase implements CrearCursoInput {
    private IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;
    private IRepositorioCrearCurso iRepositorioCrearCurso;

    public CrearCursoUseCase(IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre,
                             IRepositorioCrearCurso iRepositorioCrearCurso) {
        this.iRepositorioConsultarCursoPorNombre = iRepositorioConsultarCursoPorNombre;
        this.iRepositorioCrearCurso = iRepositorioCrearCurso;
    }

    public boolean crearCurso(Curso curso) throws PersistException, CursoExisteException {
        if (!existeCurso(curso.getTitulo())) {
            if (this.iRepositorioCrearCurso.persist(curso)) {
                return true;
            } else throw new PersistException();
        }
        throw new CursoExisteException();
    }

    private boolean existeCurso(String titulo) {
        return this.iRepositorioConsultarCursoPorNombre.findByTituloEquals(titulo) != null;
    }
}
