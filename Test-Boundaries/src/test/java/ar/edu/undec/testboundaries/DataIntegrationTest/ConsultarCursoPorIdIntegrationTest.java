package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Curso;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCursoPorIdImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursoPorIdAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursoPorIdDespues.sql")
})
public class ConsultarCursoPorIdIntegrationTest {

    @Autowired
    IRepositorioConsultarCursoPorIdImplementacion iRepositorioConsultarCursoPorIdImplementacion;

    @Test
    public void findByIdCurso_ExisteId_DevuelveCurso() {
        Curso curso = this.iRepositorioConsultarCursoPorIdImplementacion.findByIdCurso(1);
        Assertions.assertNotNull(curso);
    }
}
