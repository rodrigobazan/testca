package ar.edu.undec.testboundaries.TestData.Mapper;

import Model.Cuenta;
import Model.Curso;
import ar.edu.undec.testboundaries.TestData.ModeloData.CuentaEntity;
import ar.edu.undec.testboundaries.TestData.ModeloData.CursoEntity;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCuentaPorIdCRUD;
import ar.edu.undec.testboundaries.TestData.RepositorioData.IRepositorioConsultarCursoPorIdCRUD;

import java.util.ArrayList;
import java.util.List;

public class CursoMapper {

    private CursoMapper() {
    }

    public static Curso mapeoDataCore(CursoEntity cursoEntity) {
        try {
            List<Cuenta> cuentas = new ArrayList<>();
            cursoEntity.getInscriptos().forEach(cuentaEntity -> cuentas.add(CuentaMapper.mapeoDataCore(cuentaEntity)));
            return Curso.instance(cursoEntity.getIdCurso(), cursoEntity.getTitulo(), cuentas, cursoEntity.getFechaLimiteInscripcion(), cursoEntity.getPuntos());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static CursoEntity mapeoCoreData(Curso curso,
                                            IRepositorioConsultarCuentaPorIdCRUD iRepositorioConsultarCuentaPorIdCRUD,
                                            IRepositorioConsultarCursoPorIdCRUD iRepositorioConsultarCursoPorIdCRUD) {
        try {
            if (curso.getIdCurso() == null) {
                List<CuentaEntity> cuentas = new ArrayList<>();
                curso.getInscriptos().forEach(cuenta -> cuentas.add(CuentaMapper.mapeoCoreData(cuenta, iRepositorioConsultarCuentaPorIdCRUD)));
                return new CursoEntity(curso.getTitulo(), cuentas, curso.getFechaLimiteInscripcion(), curso.getPuntos());
            }
            return iRepositorioConsultarCursoPorIdCRUD.findByIdCurso(curso.getIdCurso());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
