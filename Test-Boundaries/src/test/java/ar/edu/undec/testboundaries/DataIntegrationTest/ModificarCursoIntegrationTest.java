package ar.edu.undec.testboundaries.DataIntegrationTest;

import Excepciones.CursoIncompletoException;
import Model.Curso;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioModificarCursoImplementacion;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ModificarCursoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/ModificarCursoDespues.sql")
})
public class ModificarCursoIntegrationTest {

    @Autowired
    IRepositorioModificarCursoImplementacion iRepositorioModificarCursoImplementacion;

    @Test
    public void update_DatosCorrectos_ModificaCorrectamente() throws CursoIncompletoException {
        Curso cursoModificado = Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(1),
                15);
        boolean resultado = this.iRepositorioModificarCursoImplementacion.update(cursoModificado);
        Assertions.assertTrue(resultado);
    }

}
