package Adapter;

import Excepciones.NoExisteInscriptosException;
import Factory.CursoFactory;
import Input.ObtenerCursoMayorInscriptoInput;
import ModelDTO.CursoDTO;

public class ObtenerCursoMayorInscriptoAdapter {
    private ObtenerCursoMayorInscriptoInput obtenerCursoMayorInscriptoInput;

    public ObtenerCursoMayorInscriptoAdapter(ObtenerCursoMayorInscriptoInput obtenerCursoMayorInscriptoInput) {
        this.obtenerCursoMayorInscriptoInput = obtenerCursoMayorInscriptoInput;
    }

    public CursoDTO obtenerCursoMayorInscriptos() throws NoExisteInscriptosException {
        return CursoFactory.factoryCoreDTO(this.obtenerCursoMayorInscriptoInput.obtenerCurso());
    }
}
