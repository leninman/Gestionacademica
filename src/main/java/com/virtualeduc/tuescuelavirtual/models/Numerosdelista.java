package com.virtualeduc.tuescuelavirtual.models;

import javax.persistence.*;

@Entity
@Table(name = "numerodelista")
public class Numerosdelista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @Column(name = "ID_CURSO")
    private Long idCurso;

    @Basic(optional = false)
    @Column(name = "ID_ALUMNO")
    private Long idAlumno;

    @Basic(optional = false)
    @Column(name = "NROLISTA")
    private Long nroLista;

    public Numerosdelista(Long id, Long idCurso, Long idAlumno, Long nroLista) {
        this.id = id;
        this.idCurso = idCurso;
        this.idAlumno = idAlumno;
        this.nroLista = nroLista;
    }

    public Numerosdelista() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getNroLista() {
        return nroLista;
    }

    public void setNroLista(Long nroLista) {
        this.nroLista = nroLista;
    }
}
