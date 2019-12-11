package Adapter;

import Factory.CursoFactory;
import Input.ConsultarCursosInput;
import ModelDTO.CursoDTO;

import java.util.ArrayList;
import java.util.List;

public class ConsultarCursosAdapter {
    private ConsultarCursosInput consultarCursosInput;

    public ConsultarCursosAdapter(ConsultarCursosInput consultarCursosInput) {
        this.consultarCursosInput = consultarCursosInput;
    }

    public List<CursoDTO> consultarCursos() {
        List<CursoDTO> cursoDTOS = new ArrayList<>();
        this.consultarCursosInput.consultarCursos()
                .forEach(curso -> cursoDTOS.add(CursoFactory.factoryCoreDTO(curso)));
        return cursoDTOS;
    }
}
