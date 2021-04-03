/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenin
 */

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CURSO")
    private Long idCurso;
    @JoinColumn(name = "ID_ANNIO", referencedColumnName = "ID_ANNIO")
    @ManyToOne(optional = false)
    private Annio idAnnio;
    @JoinColumn(name = "ID_ANNIO_ESC", referencedColumnName = "ID_ANNIO_ESC")
    @ManyToOne(optional = false)
    private AnnioEscolar idAnnioEsc;
    @JoinColumn(name = "ID_SEC", referencedColumnName = "ID_SEC")
    @ManyToOne(optional = false)
    private Seccion idSec;
    
    @JoinColumn(name = "ID_TURNO", referencedColumnName = "ID_TURNO")
    @ManyToOne(optional = false)
    private Turno idTurno;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCurso")
    private Collection<Alumno> alumnoCollection;

    public Curso() {
    }
    
    public Curso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Annio getIdAnnio() {
        return idAnnio;
    }

    public void setIdAnnio(Annio idAnnio) {
        this.idAnnio = idAnnio;
    }

    public AnnioEscolar getIdAnnioEsc() {
        return idAnnioEsc;
    }

    public void setIdAnnioEsc(AnnioEscolar idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public Seccion getIdSec() {
        return idSec;
    }

    public void setIdSec(Seccion idSec) {
        this.idSec = idSec;
    }

    public Turno getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Turno idTurno) {
        this.idTurno = idTurno;
    }
    
    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }
}
