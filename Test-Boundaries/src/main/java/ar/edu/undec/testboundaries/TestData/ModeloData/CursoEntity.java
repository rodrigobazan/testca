package ar.edu.undec.testboundaries.TestData.ModeloData;

import Model.Cuenta;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity(name = "curso")
@SequenceGenerator(name = "curso_idcurso_seq", initialValue = 1, sequenceName = "curso_idcurso_seq", allocationSize = 1)
public class CursoEntity {

    @Id
    @Column(name = "idcurso")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_idcurso_seq")
    private Integer idCurso;

    @Column(name = "titulo")
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<CuentaEntity> inscriptos;

    @Column(name = "fechalimiteinscripcion")
    private LocalDateTime fechaLimiteInscripcion;

    public CursoEntity() {
    }

    public CursoEntity(String titulo, Collection<CuentaEntity> inscriptos, LocalDateTime fechaLimiteInscripcion) {
        this.titulo = titulo;
        this.inscriptos = inscriptos;
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Collection<CuentaEntity> getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(Collection<CuentaEntity> inscriptos) {
        this.inscriptos = inscriptos;
    }

    public LocalDateTime getFechaLimiteInscripcion() {
        return fechaLimiteInscripcion;
    }

    public void setFechaLimiteInscripcion(LocalDateTime fechaLimiteInscripcion) {
        this.fechaLimiteInscripcion = fechaLimiteInscripcion;
    }
}
