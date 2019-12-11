package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ConsultarPuntosAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ConsultarPuntosController {

    private ConsultarPuntosAdapter consultarPuntosAdapter;

    public ConsultarPuntosController(ConsultarPuntosAdapter consultarPuntosAdapter) {
        this.consultarPuntosAdapter = consultarPuntosAdapter;
    }

    @RequestMapping(value = "puntos/{usuario}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> consultarPuntos(@PathVariable("usuario") String usuario) {
        try {
            int puntos = this.consultarPuntosAdapter.consultarPuntosUsuario(usuario);
            if (puntos != 0) return ResponseEntity.status(HttpStatus.OK).body(puntos);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(0);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
