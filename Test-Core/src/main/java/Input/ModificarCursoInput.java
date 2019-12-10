package Input;

import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Model.Curso;

public interface ModificarCursoInput {

    Curso modificarCurso(Curso cursoModificado) throws UpdateCuentaException, CursoExisteException, FechaLimiteIncorrectaException;
}
