package Input;

import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.PersistException;
import Model.Curso;

public interface CrearCursoInput {

    boolean crearCurso(Curso curso) throws PersistException, CursoExisteException, FechaLimiteIncorrectaException;
}
