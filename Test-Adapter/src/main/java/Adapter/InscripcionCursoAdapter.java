package Adapter;

import Excepciones.EstaInscriptoException;
import Excepciones.FechaLimiteException;
import Excepciones.UpdateCursoException;
import Factory.CuentaFactory;
import Factory.CursoFactory;
import Input.InscripcionCursoInput;
import ModelDTO.CuentaDTO;
import ModelDTO.CursoDTO;

public class InscripcionCursoAdapter {
    private InscripcionCursoInput inscripcionCursoInput;

    public InscripcionCursoAdapter(InscripcionCursoInput inscripcionCursoInput) {
        this.inscripcionCursoInput = inscripcionCursoInput;
    }

    public boolean inscripcion(CursoDTO cursoDTO, CuentaDTO cuentaDTO) throws EstaInscriptoException, UpdateCursoException, FechaLimiteException {
        return this.inscripcionCursoInput.inscripcion(CursoFactory.factoryDTOCore(cursoDTO), CuentaFactory.factoryDTOCore(cuentaDTO));
    }
}
