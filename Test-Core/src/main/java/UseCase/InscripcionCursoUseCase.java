package UseCase;

import Excepciones.EstaInscriptoException;
import Excepciones.FechaLimiteException;
import Excepciones.UpdateCursoException;
import Input.InscripcionCursoInput;
import Model.Cuenta;
import Model.Curso;
import Repository.IRepositorioConsultarCursoPorId;
import Repository.IRepositorioModificarCurso;

import java.time.LocalDateTime;

public class InscripcionCursoUseCase implements InscripcionCursoInput {
    private IRepositorioModificarCurso iRepositorioModificarCurso;
    private IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    public InscripcionCursoUseCase(IRepositorioModificarCurso iRepositorioModificarCurso,
                                   IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId) {
        this.iRepositorioModificarCurso = iRepositorioModificarCurso;
        this.iRepositorioConsultarCursoPorId = iRepositorioConsultarCursoPorId;
    }

    public boolean inscripcion(Curso curso, Cuenta cuenta) throws FechaLimiteException, EstaInscriptoException, UpdateCursoException {
        if (curso.getFechaLimiteInscripcion().isBefore(LocalDateTime.now())) {
            throw new FechaLimiteException();
        } else {
            Curso cursoAInscribir = this.iRepositorioConsultarCursoPorId.findByIdCurso(curso.getIdCurso());
            if (!cursoAInscribir.estaInscripto(cuenta.getIdCuenta())) {
                cursoAInscribir.inscribir(cuenta);
                if (this.iRepositorioModificarCurso.update(cursoAInscribir)) {
                    return true;
                } else throw new UpdateCursoException();
            } else throw new EstaInscriptoException();
        }
    }
}
