package Input;

import Excepciones.CursoExisteException;
import Excepciones.PersistException;
import Model.Curso;

public interface CrearCursoInput {

    boolean crearCurso(Curso curso) throws PersistException, CursoExisteException;
}
