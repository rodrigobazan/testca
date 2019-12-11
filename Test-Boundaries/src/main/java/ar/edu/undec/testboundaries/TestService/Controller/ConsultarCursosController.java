package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ConsultarCursosAdapter;
import ModelDTO.CursoDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConsultarCursosController {

    private ConsultarCursosAdapter consultarCursosAdapter;

    public ConsultarCursosController(ConsultarCursosAdapter consultarCursosAdapter) {
        this.consultarCursosAdapter = consultarCursosAdapter;
    }

    @RequestMapping(value = "cursos", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarCursos() {
        try {
            List<CursoDTO> cursoDTOS = this.consultarCursosAdapter.consultarCursos();
            if (cursoDTOS.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(cursoDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
