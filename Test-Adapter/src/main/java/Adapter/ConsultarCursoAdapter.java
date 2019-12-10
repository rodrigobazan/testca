package Adapter;

import Factory.CursoFactory;
import Input.ConsultarCursoPorNombreInput;
import Model.Curso;
import ModelDTO.CursoDTO;

public class ConsultarCursoAdapter {
    private ConsultarCursoPorNombreInput consultarCursoPorNombreInput;

    public ConsultarCursoAdapter(ConsultarCursoPorNombreInput consultarCursoPorNombreInput) {
        this.consultarCursoPorNombreInput = consultarCursoPorNombreInput;
    }

    public CursoDTO consultarCurso(String nombre) {
        Curso curso = this.consultarCursoPorNombreInput.consultarCursoPorNombre(nombre);
        if (curso != null) return CursoFactory.factoryCoreDTO(curso);
        return null;
    }
}
