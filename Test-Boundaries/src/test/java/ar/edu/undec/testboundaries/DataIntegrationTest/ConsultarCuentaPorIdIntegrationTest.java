package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCuentaPorIdImplementacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaPorIdAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaPorIdDespues.sql")
})
public class ConsultarCuentaPorIdIntegrationTest {

    @Autowired
    IRepositorioConsultarCuentaPorIdImplementacion iRepositorioConsultarCuentaPorIdImplementacion;

    @Test
    public void consultarCuentaPorId_ExisteId_DevuelveCuenta(){
        Cuenta cuenta = this.iRepositorioConsultarCuentaPorIdImplementacion.findByIdCuenta(1);
        Assertions.assertEquals("rabazan", cuenta.getUsuario());
    }

}
