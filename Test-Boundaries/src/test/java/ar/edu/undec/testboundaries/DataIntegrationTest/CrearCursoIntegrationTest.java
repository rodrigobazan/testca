package ar.edu.undec.testboundaries.DataIntegrationTest;

import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Model.Curso;
import ar.edu.undec.testboundaries.TestData.RepositorioImplementacion.IRepositorioCrearCursoImplementacion;
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
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/CrearCursoAntes.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:ScriptSql/DataSql/CrearCursoDespues.sql")
})
public class CrearCursoIntegrationTest {

    @Autowired
    IRepositorioCrearCursoImplementacion iRepositorioCrearCursoImplementacion;

    @Test
    public void persist_DatosCorrectos_GuardaCorrectamente() throws FechaLimiteIncorrectaException, CursoIncompletoException {
        Curso curso = Curso.instance(null, "Nuevo Curso", new ArrayList<>(), LocalDateTime.of(2019, 12, 31, 0, 0, 0));
        boolean resultado = iRepositorioCrearCursoImplementacion.persist(curso);
        Assertions.assertTrue(resultado);
    }

}
