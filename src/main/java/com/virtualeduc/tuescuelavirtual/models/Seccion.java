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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenin
 */

@NamedNativeQueries({

    @NamedNativeQuery(name="Seccion.consultarSeccionBySeccion",
            
            query="SELECT * from secciones a "
                    + "WHERE a.SECCION=:seccion",
            resultClass = Seccion.class
    ),
    
})



@Entity
@Table(name = "secciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")
    , @NamedQuery(name = "Seccion.findByIdSec", query = "SELECT s FROM Seccion s WHERE s.idSec = :idSec")
    , @NamedQuery(name = "Seccion.findBySeccion", query = "SELECT s FROM Seccion s WHERE s.seccion = :seccion")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSec")
    private Collection<Curso> cursoCollection;

    public Seccion() {
    }

    public Seccion(Long idSec) {
        this.idSec = idSec;
    }

    public Seccion(Long idSec, Character seccion) {
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

    public Character getSeccion() {
        return seccion;
    }

    public void setSeccion(Character seccion) {
        this.seccion = seccion;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSec != null ? idSec.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seccion)) {
            return false;
        }
        Seccion other = (Seccion) object;
        if ((this.idSec == null && other.idSec != null) || (this.idSec != null && !this.idSec.equals(other.idSec))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.virtualeduc.tuescuelavirtual.models.Seccion[ idSec=" + idSec + " ]";
    }
    
}
