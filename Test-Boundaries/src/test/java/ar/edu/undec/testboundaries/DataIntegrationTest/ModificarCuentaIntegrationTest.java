package ar.edu.undec.testboundaries.DataIntegrationTest;

import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioModificarCuentaImplementacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ModificarCuentaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ModificarCuentaDespues.sql")
})
public class ModificarCuentaIntegrationTest {

    @Autowired
    IRepositorioModificarCuentaImplementacion iRepositorioModificarCuentaImplementacion;

    @Test
    public void update_DatosCorrectos_ModificaCorrectamente() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        Cuenta cuentaModificada = Cuenta.instance(10, "rabazan", LocalDateTime.now(),
                "Rodrigo Andres Bazan", "654321");
        Assertions.assertEquals("rabazan", cuentaModificada.getUsuario());
    }

}
