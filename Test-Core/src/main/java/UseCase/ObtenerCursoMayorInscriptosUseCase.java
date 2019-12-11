package UseCase;

import Excepciones.NoExisteInscriptosException;
import Input.ObtenerCursoMayorInscriptoInput;
import Model.Curso;
import Repository.IRepositorioConsultarCursos;

import java.util.Comparator;
import java.util.List;

public class ObtenerCursoMayorInscriptosUseCase implements ObtenerCursoMayorInscriptoInput {
    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ObtenerCursoMayorInscriptosUseCase(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }


    public Curso obtenerCurso() throws NoExisteInscriptosException {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursos.findAll();
        Curso curso = cursos.stream()
                .max(Comparator.comparingInt(value -> value.getInscriptos().size()))
                .orElse(null);
        if (curso == null || curso.getInscriptos().isEmpty()) throw new NoExisteInscriptosException();
        return curso;
    }
}
