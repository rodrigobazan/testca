package Adapter;

import Factory.CursoFactory;
import Input.ConsultarCursoPorIdInput;
import ModelDTO.CursoDTO;

public class ConsultarCursoPorIdAdapter {
    private ConsultarCursoPorIdInput consultarCursoPorIdInput;

    public ConsultarCursoPorIdAdapter(ConsultarCursoPorIdInput consultarCursoPorIdInput) {
        this.consultarCursoPorIdInput = consultarCursoPorIdInput;
    }

    public CursoDTO consultarCursoPorId(Integer idCurso) {
        return CursoFactory.factoryCoreDTO(this.consultarCursoPorIdInput.consultarCursoPorId(idCurso));
    }
}
