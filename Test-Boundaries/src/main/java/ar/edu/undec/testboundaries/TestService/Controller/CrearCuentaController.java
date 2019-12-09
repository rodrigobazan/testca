package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.CrearCuentaAdapter;
import Excepciones.CuentaExisteException;
import Excepciones.PersistException;
import ModelDTO.CuentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CrearCuentaController {


    private CrearCuentaAdapter crearCuentaAdapter;

    public CrearCuentaController(CrearCuentaAdapter crearCuentaAdapter) {
        this.crearCuentaAdapter = crearCuentaAdapter;
    }

    @RequestMapping(value = "cuenta", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> crearCuenta(@RequestBody CuentaDTO cuentaDTO) {
        try {
            boolean resultado = this.crearCuentaAdapter.crearCuenta(cuentaDTO);
            if (resultado) return ResponseEntity.status(HttpStatus.OK).body(true);
            else return new ResponseEntity<>(HttpStatus.PRECONDITION_FAILED);
        } catch (PersistException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (CuentaExisteException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        }


    }

}
