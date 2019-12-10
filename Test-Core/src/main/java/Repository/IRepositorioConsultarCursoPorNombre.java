package Repository;

import Model.Curso;

public interface IRepositorioConsultarCursoPorNombre {
    Curso findByTituloEquals(String nombre);
}
