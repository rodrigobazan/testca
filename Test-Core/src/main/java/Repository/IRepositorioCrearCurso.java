package Repository;

import Model.Curso;

public interface IRepositorioCrearCurso {
    boolean persist(Curso curso);
}
