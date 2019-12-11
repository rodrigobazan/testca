package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ObtenerPromedioInscriptosAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ObtenerPromedioInscriptosController {

    private ObtenerPromedioInscriptosAdapter obtenerPromedioInscriptosAdapter;

    public ObtenerPromedioInscriptosController(ObtenerPromedioInscriptosAdapter obtenerPromedioInscriptosAdapter) {
        this.obtenerPromedioInscriptosAdapter = obtenerPromedioInscriptosAdapter;
    }

    @RequestMapping(value = "promedio", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> obtenerPromedio() {
        try {
            double promedio = this.obtenerPromedioInscriptosAdapter.obtenerPromedio();
            if (promedio == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(promedio);
            return ResponseEntity.status(HttpStatus.OK).body(promedio);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
