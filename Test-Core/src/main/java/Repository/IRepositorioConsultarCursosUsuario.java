package Repository;

import Model.Curso;

import java.util.Collection;
import java.util.List;

public interface IRepositorioConsultarCursosUsuario {
    Collection<Curso> findByUsuario(String usuario);
}
