package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.InscripcionCursoAdapter;
import Excepciones.EstaInscriptoException;
import Excepciones.FechaLimiteException;
import Excepciones.UpdateCursoException;
import ModeloWrapperDTO.InscripcionWrapperDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class InscripcionCursoController {

    private InscripcionCursoAdapter inscripcionCursoAdapter;

    public InscripcionCursoController(InscripcionCursoAdapter inscripcionCursoAdapter) {
        this.inscripcionCursoAdapter = inscripcionCursoAdapter;
    }

    @RequestMapping(value = "inscripcion", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> inscripcionCurso(@RequestBody InscripcionWrapperDTO inscripcionWrapperDTO) {
        try {
            boolean resultado = this.inscripcionCursoAdapter.inscripcion(inscripcionWrapperDTO.cursoDTO, inscripcionWrapperDTO.cuentaDTO);
            if (resultado) return new ResponseEntity<>(HttpStatus.OK);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (EstaInscriptoException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        } catch (UpdateCursoException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (FechaLimiteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        }
    }
}
