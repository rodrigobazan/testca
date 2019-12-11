package Repository;

import Model.Curso;

import java.util.Collection;
import java.util.List;

public interface IRepositorioConsultarCursosPorUsuario {
    Collection<Curso> findByUsuario(String usuario);
}
