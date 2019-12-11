package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Curso;
import Repository.IRepositorioConsultarCursosUsuario;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCursosUsuarioImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursosUsuarioAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursosUsuarioDespues.sql")
})
public class ConsultarCursosUsuarioIntegrationTest {

    @Autowired
    IRepositorioConsultarCursosUsuarioImplementacion iRepositorioConsultarCursosUsuarioImplementacion;

    @Test
    public void findByUsuario_TieneCursos_DevuelveListaCursos() {
        List<Curso> cursos = (List<Curso>) this.iRepositorioConsultarCursosUsuarioImplementacion.findByUsuario("rabazan");
        Assertions.assertEquals(3, cursos.size());
    }

}
