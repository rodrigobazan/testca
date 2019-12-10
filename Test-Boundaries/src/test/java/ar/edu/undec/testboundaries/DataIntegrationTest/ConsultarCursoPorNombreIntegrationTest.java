package ar.edu.undec.testboundaries.DataIntegrationTest;

import Model.Curso;
import Repository.IRepositorioConsultarCursoPorNombre;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioConsultarCursoPorNombreImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursoPorTituloAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ConsultarCursoPorTituloDespues.sql")
})
public class ConsultarCursoPorNombreIntegrationTest {

    @Autowired
    IRepositorioConsultarCursoPorNombreImplementacion iRepositorioConsultarCursoPorNombreImplementacion;

    @Test
    public void findByTitulo_HayCoincidencia_DevuelveCurso() {
        Curso curso = this.iRepositorioConsultarCursoPorNombreImplementacion.findByTituloEquals("Nuevo Curso");
        Assertions.assertEquals(1, curso.getIdCurso());
    }

    @Test
    public void findByTitulo_NoHayCoincidencia_DevuelveNull() {
        Curso curso = this.iRepositorioConsultarCursoPorNombreImplementacion.findByTituloEquals("asdad");
        Assertions.assertNull(curso);
    }

}
