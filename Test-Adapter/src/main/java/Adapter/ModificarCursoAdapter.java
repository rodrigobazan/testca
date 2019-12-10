package Adapter;

import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Factory.CursoFactory;
import Input.ModificarCursoInput;
import Model.Curso;
import ModelDTO.CursoDTO;

public class ModificarCursoAdapter {
    private ModificarCursoInput modificarCursoInput;

    public ModificarCursoAdapter(ModificarCursoInput modificarCursoInput) {
        this.modificarCursoInput = modificarCursoInput;
    }

    public CursoDTO modificarCurso(CursoDTO cursoDTO) throws FechaLimiteIncorrectaException, CursoExisteException, UpdateCuentaException {
        Curso curso = this.modificarCursoInput.modificarCurso(CursoFactory.factoryDTOCore(cursoDTO));
        if (curso != null) return CursoFactory.factoryCoreDTO(curso);
        return null;
    }
}
