package Input;

import Excepciones.EstaInscriptoException;
import Excepciones.FechaLimiteException;
import Excepciones.UpdateCursoException;
import Model.Cuenta;
import Model.Curso;

public interface InscripcionCursoInput {
    boolean inscripcion(Curso curso, Cuenta cuenta) throws FechaLimiteException, EstaInscriptoException, UpdateCursoException;
}
