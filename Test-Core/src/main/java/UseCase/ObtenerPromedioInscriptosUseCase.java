package UseCase;

import Model.Curso;
import Repository.IRepositorioConsultarCursos;

import java.text.DecimalFormat;
import java.util.List;

public class ObtenerPromedioInscriptosUseCase {
    private IRepositorioConsultarCursos iRepositorioConsultarCursos;

    public ObtenerPromedioInscriptosUseCase(IRepositorioConsultarCursos iRepositorioConsultarCursos) {
        this.iRepositorioConsultarCursos = iRepositorioConsultarCursos;
    }

    public double obtenerPromedio() {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursos.findAll();
        int inscriptos = cursos.stream().map(curso -> curso.getInscriptos().size())
                .mapToInt(Integer::intValue)
                .sum();
        double resultado = (double) inscriptos / (double) cursos.size();
        return Math.round(resultado * 100.0) / 100.0;
    }
}
