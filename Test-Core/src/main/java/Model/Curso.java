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
    private Integer puntos;

    private Curso(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion,
                  Integer puntos) {
        this.idCurso = idCurso;
        this.titulo = titulo;
        this.inscriptos = inscriptos;
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
        this.puntos = puntos;
    }

    public static Curso instance(Integer idCurso, String titulo, Collection<Cuenta> inscriptos,
                                 LocalDateTime fechaLimiteInscripcion, Integer puntos) throws CursoIncompletoException {
        if (titulo == null || titulo.isEmpty() || fechaLimiteInscripcion == null || puntos == null) {
            throw new CursoIncompletoException();
        }
        return new Curso(idCurso, titulo, inscriptos, fechaLimiteInscripcion, puntos);
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

    public Integer getPuntos() {
        return puntos;
    }

    public void modificarDatos(Curso cursoModificado) {
        this.inscriptos = cursoModificado.inscriptos;
        this.titulo = cursoModificado.titulo;
        this.fechaLimiteInscripcion = cursoModificado.fechaLimiteInscripcion;
    }

    public boolean estaInscripto(Integer idCuenta) {
        return this.inscriptos.stream().filter(cuenta -> cuenta.getIdCuenta().intValue() == idCuenta)
                .findAny().orElse(null) != null;
    }

    public void inscribir(Cuenta cuenta) {
        this.inscriptos.add(cuenta);
    }
}
