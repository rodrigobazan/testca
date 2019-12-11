package UseCase;

import Excepciones.EstaInscriptoException;
import Excepciones.FechaLimiteException;
import Excepciones.UpdateCursoException;
import Input.InscripcionCursoInput;
import Model.Cuenta;
import Model.Curso;
import Repository.IRepositorioModificarCurso;

import java.time.LocalDateTime;

public class InscripcionCursoUseCase implements InscripcionCursoInput {
    private IRepositorioModificarCurso iRepositorioModificarCurso;

    public InscripcionCursoUseCase(IRepositorioModificarCurso iRepositorioModificarCurso) {
        this.iRepositorioModificarCurso = iRepositorioModificarCurso;
    }

    public boolean inscripcion(Curso curso, Cuenta cuenta) throws FechaLimiteException, EstaInscriptoException, UpdateCursoException {
        if (curso.getFechaLimiteInscripcion().isBefore(LocalDateTime.now())) {
            throw new FechaLimiteException();
        } else {
            if (!curso.estaInscripto(cuenta.getIdCuenta())) {
                curso.inscribir(cuenta);
                if (this.iRepositorioModificarCurso.update(curso)) {
                    return true;
                } else throw new UpdateCursoException();
            } else throw new EstaInscriptoException();
        }
    }
}
