package UnitTest;

import Excepciones.NoExisteInscriptosException;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Model.Curso;
import Repository.IRepositorioConsultarCursos;
import UseCase.ObtenerCursoMenorInscriptosUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerCursoMenorInscriptosUnitTest {

    @Mock
    IRepositorioConsultarCursos iRepositorioConsultarCursos;

    @Test
    void obtenerCursoMenorInscriptos_HayCursosConInscriptos_DevuelveCurso() throws NoExisteInscriptosException {
        ObtenerCursoMenorInscriptosUseCase obtenerCursoMenorInscriptosUseCase = new ObtenerCursoMenorInscriptosUseCase(iRepositorioConsultarCursos);
        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursos());
        Curso curso = obtenerCursoMenorInscriptosUseCase.obtenerCurso();
        Assertions.assertEquals("Ionic 5", curso.getTitulo());
    }

    @Test
    void obtenerCursoMenorInscriptos_NoHayCursosConInscriptos_NoExisteInscriptosException() throws NoExisteInscriptosException {
        ObtenerCursoMenorInscriptosUseCase obtenerCursoMenorInscriptosUseCase = new ObtenerCursoMenorInscriptosUseCase(iRepositorioConsultarCursos);
        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursosSinInscriptos());
        Curso curso = obtenerCursoMenorInscriptosUseCase.obtenerCurso();
        Assertions.assertEquals("Ionic 3", curso.getTitulo());
    }

    private List<Curso> factoryCursosSinInscriptos() {
        try {
            List<Curso> cursos = new ArrayList<>();
            cursos.add(Curso.instance(2, "Ionic 3", new ArrayList<>(), LocalDateTime.now().plusDays(5), 15));
            cursos.add(Curso.instance(3, "Ionic 5", new ArrayList<>(), LocalDateTime.now().plusDays(5), 5));
            cursos.add(Curso.instance(1, "Ionic 4", new ArrayList<>(), LocalDateTime.now().plusDays(5), 10));
            return cursos;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Curso> factoryCursos() {
        try {
            List<Curso> cursos = new ArrayList<>();
            cursos.add(Curso.instance(2, "Ionic 3", factoryInscriptos2(), LocalDateTime.now().plusDays(5), 15));
            cursos.add(Curso.instance(3, "Ionic 5", factoryInscriptos3(), LocalDateTime.now().plusDays(5), 5));
            cursos.add(Curso.instance(1, "Ionic 4", factoryInscriptos(), LocalDateTime.now().plusDays(5), 10));
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
            cuentas.add(Cuenta.instance(3, "jruitti", LocalDateTime.now(), "Javier Ruitti", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private List<Cuenta> factoryInscriptos2() {
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

    private List<Cuenta> factoryInscriptos3() {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cuentas.add(Cuenta.instance(1, "rabazan", LocalDateTime.now(), "Rodrigo Bazan", "123456"));
            return cuentas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
