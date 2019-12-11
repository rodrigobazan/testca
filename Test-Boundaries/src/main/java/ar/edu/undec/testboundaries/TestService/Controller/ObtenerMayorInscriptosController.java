package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ObtenerCursoMayorInscriptoAdapter;
import Excepciones.NoExisteInscriptosException;
import ModelDTO.CursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ObtenerMayorInscriptosController {

    private ObtenerCursoMayorInscriptoAdapter obtenerCursoMayorInscriptoAdapter;

    public ObtenerMayorInscriptosController(ObtenerCursoMayorInscriptoAdapter obtenerCursoMayorInscriptoAdapter) {
        this.obtenerCursoMayorInscriptoAdapter = obtenerCursoMayorInscriptoAdapter;
    }

    @RequestMapping(value = "mayor", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> obtenerMayorInscriptos() {
        try {
            CursoDTO cursoDTO = this.obtenerCursoMayorInscriptoAdapter.obtenerCursoMayorInscriptos();
            if (cursoDTO == null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return ResponseEntity.status(HttpStatus.OK).body(cursoDTO);
        } catch (NoExisteInscriptosException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
}
