package ar.edu.undec.testboundaries.TestData.Mapper;

import Model.Cuenta;
import Model.Curso;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;

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

    public static CursoEntity mapeoCoreData(Curso curso,
                                            IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD) {
        try {
            List<CuentaEntity> cuentas = new ArrayList<>();
            curso.getInscriptos().forEach(cuenta -> cuentas.add(CuentaMapper.mapeoCoreData(cuenta, iRepositorioConsultarCuentaPorIdCRUD)));
            if (curso.getIdCurso() == null) {
                return new CursoEntity(curso.getTitulo(), cuentas, curso.getFechaLimiteInscripcion());
            }
            return null; //todo consultar curso por id
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
