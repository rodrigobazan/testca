package Factory;

import Model.Cuenta;
import Model.Curso;
import ModelDTO.CuentaDTO;
import ModelDTO.CursoDTO;

import java.util.ArrayList;
import java.util.List;

public class CursoFactory {

    private CursoFactory() {
    }

    public static CursoDTO factoryCoreDTO(Curso curso) {
        try {
            List<CuentaDTO> cuentas = new ArrayList<>();
            curso.getInscriptos().forEach(cuenta -> cuentas.add(CuentaFactory.factoryCoreDTO(cuenta)));
            return new CursoDTO(curso.getIdCurso(), curso.getTitulo(), cuentas, curso.getFechaLimiteInscripcion(), curso.getPuntos());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Curso factoryDTOCore(CursoDTO cursoDTO) {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cursoDTO.inscriptos.forEach(cuentaDTO -> cuentas.add(CuentaFactory.factoryDTOCore(cuentaDTO)));
            return Curso.instance(cursoDTO.idCurso, cursoDTO.titulo, cuentas, cursoDTO.fechaLimiteInscripcion, cursoDTO.puntos);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
