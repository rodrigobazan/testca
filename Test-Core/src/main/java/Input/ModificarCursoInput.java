package Input;

import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Excepciones.UpdateCursoException;
import Model.Curso;

public interface ModificarCursoInput {

    Curso modificarCurso(Curso cursoModificado) throws CursoExisteException, FechaLimiteIncorrectaException, UpdateCursoException;
}
