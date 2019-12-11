package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ModificarCursoAdapter;
import Excepciones.CursoExisteException;
import Excepciones.FechaLimiteIncorrectaException;
import Excepciones.UpdateCuentaException;
import Excepciones.UpdateCursoException;
import ModelDTO.CursoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ModificarCursoController {

    private ModificarCursoAdapter modificarCursoAdapter;

    public ModificarCursoController(ModificarCursoAdapter modificarCursoAdapter) {
        this.modificarCursoAdapter = modificarCursoAdapter;
    }

    @RequestMapping(value = "curso", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarCurso(@RequestBody CursoDTO cursoDTO) {
        try {
            CursoDTO resultado = this.modificarCursoAdapter.modificarCurso(cursoDTO);
            if (resultado != null) return ResponseEntity.status(HttpStatus.OK).body(resultado);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FechaLimiteIncorrectaException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        } catch (CursoExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        } catch (UpdateCursoException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
