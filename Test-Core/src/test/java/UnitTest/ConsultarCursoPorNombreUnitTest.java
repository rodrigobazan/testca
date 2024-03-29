package UnitTest;

import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;
import Mockito.MockitoExtension;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorNombre;
import UseCase.ConsultarCursoPorNombreUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCursoPorNombreUnitTest {

    @Mock
    IRepositorioConsultarCursoPorNombre iRepositorioConsultarCursoPorNombre;

    @Test
    void consultarCursoPorNombre_HayCoincidencia_DevuelveCurso() throws CursoIncompletoException {
        ConsultarCursoPorNombreUseCase consultarCursoPorNombreUseCase = new ConsultarCursoPorNombreUseCase(iRepositorioConsultarCursoPorNombre);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Nuevo Curso"))
                .thenReturn(Curso.instance(1, "Nuevo Curso", new ArrayList<>(),
                        LocalDateTime.now().plusDays(5), 10));
        Curso buscado = consultarCursoPorNombreUseCase.consultarCursoPorNombre("Nuevo Curso");
        Assertions.assertNotNull(buscado);
    }

    @Test
    void consultarCursoPorNombre_NoHayCoincidencia_DevuelveNull() {
        ConsultarCursoPorNombreUseCase consultarCursoPorNombreUseCase = new ConsultarCursoPorNombreUseCase(iRepositorioConsultarCursoPorNombre);
        when(iRepositorioConsultarCursoPorNombre.findByTituloEquals("Nuevo Curso"))
                .thenReturn(null);
        Curso buscado = consultarCursoPorNombreUseCase.consultarCursoPorNombre("Nuevo Curso");
        Assertions.assertNull(buscado);
    }

}
