package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ConsultarCuentasAdapter;
import ModelDTO.CuentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ConsultarCuentasController {

    private ConsultarCuentasAdapter consultarCuentasAdapter;

    public ConsultarCuentasController(ConsultarCuentasAdapter consultarCuentasAdapter) {
        this.consultarCuentasAdapter = consultarCuentasAdapter;
    }

    @RequestMapping(value = "cuentas", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> consultarCuentas() {
        try {
            List<CuentaDTO> cuentaDTOS = this.consultarCuentasAdapter.consultarCuentas();
            if (cuentaDTOS.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return ResponseEntity.status(HttpStatus.OK).body(cuentaDTOS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
