package UseCase;

import Excepciones.NoExisteInscriptosException;
import Input.ObtenerCursoMenorInscriptosInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursos;

import java.util.Comparator;

public class ObtenerCursoMenorInscriptosUseCase implements ObtenerCursoMenorInscriptosInput {
    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ObtenerCursoMenorInscriptosUseCase(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    public Curso obtenerCurso() throws NoExisteInscriptosException {
        Curso curso = this.iRepositorioConsultarCursos.findAll()
                .stream()
                .min(Comparator.comparing(value -> value.getInscriptos().size()))
                .orElse(null);
        if (curso == null || curso.getInscriptos().isEmpty()) throw new NoExisteInscriptosException();
        return curso;
    }
}
