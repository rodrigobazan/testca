package Model;

import Excepciones.CursoIncompletoException;
import Excepciones.FechaLimiteIncorrectaException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Curso {

    private Integer idCurso;
    private String titulo;
    private Collection<Cuenta> inscriptos;
    private LocalDateTime fechaLimiteInscripcion;

    private Curso(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion) {
        this.idCurso = idCurso;
        this.titulo = titulo;
        this.inscriptos = inscriptos;
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
    }

    public static Curso instance(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion) throws CursoIncompletoException, FechaLimiteIncorrectaException {
        if (titulo == null || titulo.isEmpty()) {
            throw new CursoIncompletoException();
        }
        if (fechaLimiteInscripcion.isBefore(LocalDateTime.now())) {
            throw new FechaLimiteIncorrectaException();
        }
        return new Curso(idCurso, titulo, inscriptos, fechaLimiteInscripcion);
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public Collection<Cuenta> getInscriptos() {
        return inscriptos;
    }

    public LocalDateTime getFechaLimiteInscripcion() {
        return fechaLimiteInscripcion;
    }
}
