package ar.edu.undec.testboundaries.DataIntegrationTest;

import Excepciones.CuentaIncompletaException;
import Excepciones.FechaCreacionIncorrectaException;
import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioCrearCuentaImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/CrearCuentaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/CrearCuentaDespues.sql")
})
public class CrearCuentaIntegrationTest {

    @Autowired
    IRepositorioCrearCuentaImplementacion iRepositorioCrearCuentaImplementacion;

    @Test
    public void persist_DatosCorrectos_GuardaCorrectamente() throws CuentaIncompletaException, FechaCreacionIncorrectaException {
        Cuenta cuenta = Cuenta.instance(null, "rabazan", LocalDateTime.now(),
                "Rodrigo Bazan", "123456");
        boolean resultado = this.iRepositorioCrearCuentaImplementacion.persist(cuenta);
        Assertions.assertTrue(resultado);
    }

}
