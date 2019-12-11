package UnitTest;

import Mockito.MockitoExtension;
import Model.Curso;
import Repository.IRepositorioConsultarCursosUsuario;
import UseCase.ConsultarPuntosUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPuntosUnitTest {

    @Mock
    IRepositorioConsultarCursosUsuario iRepositorioConsultarCursosUsuario;

    @Test
    void consultarPuntos_TieneCursos_DevuelveTotalPuntos() {
        ConsultarPuntosUseCase consultarPuntosUseCase = new ConsultarPuntosUseCase(iRepositorioConsultarCursosUsuario);
        when(iRepositorioConsultarCursosUsuario.findByUsuario("rabazan")).thenReturn(factoryCursos());
        int puntos = consultarPuntosUseCase.consultarPuntosCuenta("rabazan");
        Assertions.assertEquals(30, puntos);
    }

    @Test
    void consultarPuntos_NoTieneCursos_DevuelveCero() {
        ConsultarPuntosUseCase consultarPuntosUseCase = new ConsultarPuntosUseCase(iRepositorioConsultarCursosUsuario);
        when(iRepositorioConsultarCursosUsuario.findByUsuario("rabazan")).thenReturn(new ArrayList<>());
        int puntos = consultarPuntosUseCase.consultarPuntosCuenta("rabazan");
        Assertions.assertEquals(0, puntos);
    }

    private Collection<Curso> factoryCursos() {
        try {
            List<Curso> cursos = new ArrayList<>();
            cursos.add(Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(3), 10));
            cursos.add(Curso.instance(2, "Ionic 3", new ArrayList<>(), LocalDateTime.now().plusDays(4), 10));
            cursos.add(Curso.instance(3, "Ionic 5", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10));
            return cursos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
