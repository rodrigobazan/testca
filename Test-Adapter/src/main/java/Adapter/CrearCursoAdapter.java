package Adapter;

import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.PersistException;
import Factory.CursoFactory;
import Input.CrearCursoInput;
import ModelDTO.CursoDTO;

public class CrearCursoAdapter {
    private CrearCursoInput crearCursoInput;

    public CrearCursoAdapter(CrearCursoInput crearCursoInput) {
        this.crearCursoInput = crearCursoInput;
    }

    public boolean crearCurso(CursoDTO cursoDTO) throws PersistException, CursoExisteException, FechaLimiteIncorrectaException {
        return this.crearCursoInput.crearCurso(CursoFactory.factoryDTOCore(cursoDTO));
    }
}
