package Input;

import Excepciones.NoExisteInscriptosException;
import Model.Curso;

public interface ObtenerCursoMenorInscriptosInput {
    Curso obtenerCurso() throws NoExisteInscriptosException;
}
