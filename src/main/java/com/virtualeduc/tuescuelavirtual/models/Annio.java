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
@Table(name = "annios")

public class Annio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANNIO")
    private Long idAnnio;
    @Basic(optional = false)
    @Column(name = "ANNIO")
    private String annio;
    @Basic(optional = false)
    @Column(name = "NIVEL")
    private String nivel;
    @Basic(optional = false)
    @Column(name = "ESPECIALIDAD")
    private String especialidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "annio")
    private Collection<Curso> cursosCollection;

    public Annio() {
    }

    public Annio(Long idAnnio) {
        this.idAnnio = idAnnio;
    }

    public Annio(Long idAnnio, String annio, String nivel, String especialidad) {
        this.idAnnio = idAnnio;
        this.annio = annio;
        this.nivel = nivel;
        this.especialidad = especialidad;
    }

    public Long getIdAnnio() {
        return idAnnio;
    }

    public void setIdAnnio(Long idAnnio) {
        this.idAnnio = idAnnio;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Collection<Curso> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Curso> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    
}
