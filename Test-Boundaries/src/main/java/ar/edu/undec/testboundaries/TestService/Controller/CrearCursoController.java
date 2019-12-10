package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.CrearCursoAdapter;
import Excepciones.CursoExisteException;
import Excepciones.PersistException;
import ModelDTO.CursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CrearCursoController {

    private CrearCursoAdapter crearCursoAdapter;

    public CrearCursoController(CrearCursoAdapter crearCursoAdapter) {
        this.crearCursoAdapter = crearCursoAdapter;
    }

    @RequestMapping(value = "curso", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCurso(@RequestBody CursoDTO cursoDTO) {
        try {
            boolean resultado = this.crearCursoAdapter.crearCurso(cursoDTO);
            if (resultado) return new ResponseEntity<>(HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (PersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (CursoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        }
    }
}
