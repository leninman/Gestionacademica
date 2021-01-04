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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "secciones")

public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SEC")
    private Long idSec;
    @Basic(optional = false)
    @Column(name = "SECCION")
    private Character seccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seccion")
    private Collection<Curso> cursosCollection;

    public Seccion() {
    }

    public Seccion(Long idSec) {
        this.idSec = idSec;
    }

    public Seccion(Long idSec, Character seccion) {
        this.idSec = idSec;
        this.seccion = seccion;
    }

    public Long getIdSec() {
        return idSec;
    }

    public void setIdSec(Long idSec) {
        this.idSec = idSec;
    }

    public Character getSeccion() {
        return seccion;
    }

    public void setSeccion(Character seccion) {
        this.seccion = seccion;
    }

    public Collection<Curso> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Curso> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

}
