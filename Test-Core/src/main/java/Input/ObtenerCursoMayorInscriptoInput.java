package Input;

import Excepciones.NoExisteInscriptosException;
import Model.Curso;

public interface ObtenerCursoMayorInscriptoInput {

    Curso obtenerCurso() throws NoExisteInscriptosException;
}
