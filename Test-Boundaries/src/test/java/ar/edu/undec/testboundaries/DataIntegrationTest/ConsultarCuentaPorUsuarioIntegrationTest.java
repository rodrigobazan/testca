package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCuentaPorUsuarioImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaPorUsuarioAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaPorUsuarioDespues.sql")
})
public class ConsultarCuentaPorUsuarioIntegrationTest {

    @Autowired
    IRepositorioConsultarCuentaPorUsuarioImplementacion iRepositorioConsultarCuentaPorUsuarioImplementacion;

    @Test
    public void findByUsuario_ExisteCoincidencia_DevuelveCuenta() {
        Cuenta buscada = iRepositorioConsultarCuentaPorUsuarioImplementacion.findByUsuario("rabazan");
        Assertions.assertNotNull(buscada);
    }


    @Test
    public void findByUsuario_NoExisteCoincidencia_DevuelveNull() {
        Cuenta buscada = iRepositorioConsultarCuentaPorUsuarioImplementacion.findByUsuario("r");
        Assertions.assertNull(buscada);
    }

}
