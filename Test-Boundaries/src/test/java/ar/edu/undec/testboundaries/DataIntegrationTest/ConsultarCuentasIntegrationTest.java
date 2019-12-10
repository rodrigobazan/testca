package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Cuenta;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCuentasImplementacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaDespues.sql")
})
public class ConsultarCuentasIntegrationTest {

    @Autowired
    IRepositorioConsultarCuentasImplementacion iRepositorioConsultarCuentasImplementacion;

    @Test
    public void findAll_ExistenCuentas_DevuelveListaCuentas() {
        List<Cuenta> cuentas = (List<Cuenta>) this.iRepositorioConsultarCuentasImplementacion.findAll();
        Assertions.assertEquals(3, cuentas.size());
    }


    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCuentaDespues.sql")
    public void findAll_NoExistenCuentas_DevuelveListaVacia() {
        List<Cuenta> cuentas = (List<Cuenta>) this.iRepositorioConsultarCuentasImplementacion.findAll();
        Assertions.assertEquals(0, cuentas.size());
    }

}
