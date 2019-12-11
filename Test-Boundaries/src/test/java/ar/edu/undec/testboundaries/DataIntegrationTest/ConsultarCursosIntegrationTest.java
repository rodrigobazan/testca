package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Curso;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCursosImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursosAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursosDespues.sql")
})
public class ConsultarCursosIntegrationTest {

    @Autowired
    IRepositorioConsultarCursosImplementacion iRepositorioConsultarCursosImplementacion;

    @Test
    public void findAll_ExistenCursos_DevuelveListaCursos() {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursosImplementacion.findAll();
        Assertions.assertEquals(3, cursos.size());
    }


    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursosDespues.sql")
    public void findAll_NoExistenCursos_DevuelveListaVacia() {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursosImplementacion.findAll();
        Assertions.assertEquals(0, cursos.size());
    }

}
