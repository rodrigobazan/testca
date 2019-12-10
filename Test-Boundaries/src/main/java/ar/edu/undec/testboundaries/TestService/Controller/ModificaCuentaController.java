package ar.edu.undec.testboundaries.TestService.Controller;

import Adapter.ModificarCuentaAdapter;
import Excepciones.CuentaExisteException;
import Excepciones.UpdateCuentaException;
import ModelDTO.CuentaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ModificaCuentaController {

    private ModificarCuentaAdapter modificarCuentaAdapter;


    public ModificaCuentaController(ModificarCuentaAdapter modificarCuentaAdapter) {
        this.modificarCuentaAdapter = modificarCuentaAdapter;
    }

    @RequestMapping(value = "cuenta", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> modificarCuenta(@RequestBody CuentaDTO cuentaDTO) {
        try {
            CuentaDTO resultado = this.modificarCuentaAdapter.modificarCuenta(cuentaDTO);
            if (resultado != null) return ResponseEntity.status(HttpStatus.OK).body(resultado);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UpdateCuentaException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (CuentaExisteException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(e.mensaje());
        }
    }
}
