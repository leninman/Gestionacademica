/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

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
    private String seccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSec")
    private Collection<Curso> cursoCollection;

    public Seccion() {
    }

    public Seccion(Long idSec) {
        this.idSec = idSec;
    }

    public Seccion(Long idSec, String seccion) {
        this.idSec = idSec;
        this.seccion = seccion;
    }
    
    public Seccion(SeccionDTO seccionDTO) {
        this.idSec = seccionDTO.getIdSec();
        this.seccion = seccionDTO.getSeccion();
    }

    public Long getIdSec() {
        return idSec;
    }

    public void setIdSec(Long idSec) {
        this.idSec = idSec;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }
}
