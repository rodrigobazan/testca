package Adapter;

import Excepciones.NoExisteInscriptosException;
import Factory.CursoFactory;
import Input.ObtenerCursoMenorInscriptosInput;
import ModelDTO.CursoDTO;

public class ObtenerCursoMenorInscriptoAdapter {
    private ObtenerCursoMenorInscriptosInput obtenerCursoMenorInscriptosInput;

    public ObtenerCursoMenorInscriptoAdapter(ObtenerCursoMenorInscriptosInput obtenerCursoMenorInscriptosInput) {
        this.obtenerCursoMenorInscriptosInput = obtenerCursoMenorInscriptosInput;
    }

    public CursoDTO obtenerCursoMenorInscriptos() throws NoExisteInscriptosException {
        return CursoFactory.factoryCoreDTO(this.obtenerCursoMenorInscriptosInput.obtenerCurso());
    }
}
