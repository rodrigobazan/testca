package AdapterTest;

import Adapter.InscripcionCursoAdapter;
import Excepciones.EstaInscriptoException;
import Excepciones.FechaLimiteException;
import Excepciones.UpdateCursoException;
import Input.InscripcionCursoInput;
import Mockito.MockitoExtension;
import Model.Cuenta;
import Model.Curso;
import ModelDTO.CuentaDTO;
import ModelDTO.CursoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InscripcionCursoAdapterTest {

    @Mock
    InscripcionCursoInput inscripcionCursoInput;

    @Test
    void inscripcionCurso_NoEstaInscripto_InscribeCorrectamente() throws UpdateCursoException, FechaLimiteException, EstaInscriptoException {
        CursoDTO cursoDTO = new CursoDTO(1, "Ionic 5", new ArrayList<>(), LocalDateTime.now().plusDays(5), 15);
        CuentaDTO cuentaDTO = new CuentaDTO(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456");
        InscripcionCursoAdapter inscripcionCursoAdapter = new InscripcionCursoAdapter(inscripcionCursoInput);
        when(inscripcionCursoInput.inscripcion(any(Curso.class), any(Cuenta.class))).thenReturn(true);
        boolean resultado = inscripcionCursoAdapter.inscripcion(cursoDTO, cuentaDTO);
        Assertions.assertTrue(resultado);
    }

    @Test
    void inscripcionCurso_EstaInscripto_EstaInscriptoException() throws UpdateCursoException, FechaLimiteException, EstaInscriptoException {
        CursoDTO cursoDTO = new CursoDTO(1, "Ionic 5", factoryInscripto(), LocalDateTime.now().plusDays(5), 15);
        CuentaDTO cuentaDTO = new CuentaDTO(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456");
        InscripcionCursoAdapter inscripcionCursoAdapter = new InscripcionCursoAdapter(inscripcionCursoInput);
        when(inscripcionCursoInput.inscripcion(any(Curso.class), any(Cuenta.class))).thenThrow(EstaInscriptoException.class);
        Assertions.assertThrows(EstaInscriptoException.class, () -> inscripcionCursoAdapter.inscripcion(cursoDTO, cuentaDTO));
    }

    @Test
    void inscripcionCurso_FechaLimitePaso_FechaLimiteException() throws UpdateCursoException, FechaLimiteException, EstaInscriptoException {
        CursoDTO cursoDTO = new CursoDTO(1, "Ionic 5", factoryInscripto(), LocalDateTime.now().plusDays(5), 15);
        CuentaDTO cuentaDTO = new CuentaDTO(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456");
        InscripcionCursoAdapter inscripcionCursoAdapter = new InscripcionCursoAdapter(inscripcionCursoInput);
        when(inscripcionCursoInput.inscripcion(any(Curso.class), any(Cuenta.class))).thenThrow(FechaLimiteException.class);
        Assertions.assertThrows(FechaLimiteException.class, () -> inscripcionCursoAdapter.inscripcion(cursoDTO, cuentaDTO));
    }

    private List<CuentaDTO> factoryInscripto() {
        try {
            List<CuentaDTO> cuentaDTOS = new ArrayList<>();
            cuentaDTOS.add(new CuentaDTO(1, "rabazan", LocalDateTime.now().minusDays(5), "Rodrigo Bazan", "123456"));
            return cuentaDTOS;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
