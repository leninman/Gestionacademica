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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
    private Annio annio;
    @JoinColumn(name = "ID_ANNIO_ESC", referencedColumnName = "ID_ANNIO_ESC")
    @ManyToOne(optional = false)
    private AnnioEscolar annioEscolar;
    @JoinColumn(name = "ID_SEC", referencedColumnName = "ID_SEC")
    @ManyToOne(optional = false)
    private Seccion seccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private Collection<Alumno> alumnosCollection;

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

    public Annio getAnnio() {
        return annio;
    }

    public void setAnnio(Annio annio) {
        this.annio = annio;
    }

    public AnnioEscolar getAnnioEscolar() {
        return annioEscolar;
    }

    public void setAnnioEscolar(AnnioEscolar annioEscolar) {
        this.annioEscolar = annioEscolar;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Collection<Alumno> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumno> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
    }

    
}
