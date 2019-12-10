package Factory;

import Model.Curso;
import ModelDTO.CursoDTO;

public class CursoFactory {

    private CursoFactory() {
    }

    public static CursoDTO factoryCoreDTO(Curso curso) {
        try {
            return new CursoDTO(curso.getIdCurso(), curso.getTitulo(), curso.getInscriptos(), curso.getFechaLimiteInscripcion());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
