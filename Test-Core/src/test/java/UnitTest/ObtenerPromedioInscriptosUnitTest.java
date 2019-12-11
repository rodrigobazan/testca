package UnitTest;

import Mockito.MockitoExtension;
import Model.Cuenta;
import Model.Curso;
import Repository.IRepositorioConsultarCursos;
import UseCase.ObtenerPromedioInscriptosUseCase;
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
public class ObtenerPromedioInscriptosUnitTest {

    @Mock
    IRepositorioConsultarCursos iRepositorioConsultarCursos;

    @Test
    void obtenerPromedio_HayCursos_DevuelvePromedioDeInscriptos() {
        ObtenerPromedioInscriptosUseCase obtenerPromedioInscriptosUseCase = new ObtenerPromedioInscriptosUseCase(iRepositorioConsultarCursos);
        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursos());
        double promedio = obtenerPromedioInscriptosUseCase.obtenerPromedio();
        Assertions.assertEquals(1.33, promedio);
    }

    @Test
    void obtenerPromedio_NoHayCursos_DevuelveCero() {
        ObtenerPromedioInscriptosUseCase obtenerPromedioInscriptosUseCase = new ObtenerPromedioInscriptosUseCase(iRepositorioConsultarCursos);
        when(iRepositorioConsultarCursos.findAll()).thenReturn(new ArrayList<>());
        double promedio = obtenerPromedioInscriptosUseCase.obtenerPromedio();
        Assertions.assertEquals(0, promedio);
    }

    private List<Curso> factoryCursos() {
        try {
            List<Curso> cursos = new ArrayList<>();
            cursos.add(Curso.instance(1, "Ioni 3", factoryInscriptos(), LocalDateTime.now().plusDays(5), 10));
            cursos.add(Curso.instance(2, "Ioni 4", new ArrayList<>(), LocalDateTime.now().plusDays(5), 20));
            cursos.add(Curso.instance(3, "Ioni 5", factoryInscriptos(), LocalDateTime.now().plusDays(5), 15));
            return cursos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Cuenta> factoryInscriptos() {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(Cuenta.instance(1, "rabazan", LocalDateTime.now(), "Rodrigo Bazan", "123456"));
            cuentas.add(Cuenta.instance(2, "gtorres", LocalDateTime.now(), "German Torres", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
