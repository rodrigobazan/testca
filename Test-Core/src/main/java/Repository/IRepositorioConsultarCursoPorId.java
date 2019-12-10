package Repository;

import Model.Curso;

public interface IRepositorioConsultarCursoPorId {
    Curso findByIdCurso(Integer idCurso);
}
