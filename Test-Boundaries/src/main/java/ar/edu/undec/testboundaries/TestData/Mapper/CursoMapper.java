package ar.edu.undec.testboundaries.TestData.Mapper;

import Model.Cuenta;
import Model.Curso;
import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;

import java.util.ArrayList;
import java.util.List;

public class CursoMapper {

    private CursoMapper() {
    }

    public static Curso mapeoDataCore(CursoEntity cursoEntity) {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cursoEntity.getInscriptos().forEach(cuentaEntity -> cuentas.add(CuentaMapper.mapeoDataCore(cuentaEntity)));
            return Curso.instance(cursoEntity.getIdCurso(), cursoEntity.getTitulo(), cuentas, cursoEntity.getFechaLimiteInscripcion());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
