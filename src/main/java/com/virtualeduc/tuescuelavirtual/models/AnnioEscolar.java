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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "annio_escolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnnioEscolar.findAll", query = "SELECT a FROM AnnioEscolar a")
    , @NamedQuery(name = "AnnioEscolar.findByIdAnnioEsc", query = "SELECT a FROM AnnioEscolar a WHERE a.idAnnioEsc = :idAnnioEsc")
    , @NamedQuery(name = "AnnioEscolar.findByIntAnnioEsc", query = "SELECT a FROM AnnioEscolar a WHERE a.intAnnioEsc = :intAnnioEsc")})
public class AnnioEscolar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ANNIO_ESC")
    private Long idAnnioEsc;
    @Basic(optional = false)
    @Column(name = "INT_ANNIO_ESC")
    private String intAnnioEsc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnnioEsc")
    private Collection<Curso> cursoCollection;

    public AnnioEscolar() {
    }

    public AnnioEscolar(Long idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public AnnioEscolar(Long idAnnioEsc, String intAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
        this.intAnnioEsc = intAnnioEsc;
    }

    public Long getIdAnnioEsc() {
        return idAnnioEsc;
    }

    public void setIdAnnioEsc(Long idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public String getIntAnnioEsc() {
        return intAnnioEsc;
    }

    public void setIntAnnioEsc(String intAnnioEsc) {
        this.intAnnioEsc = intAnnioEsc;
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
        hash += (idAnnioEsc != null ? idAnnioEsc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnnioEscolar)) {
            return false;
        }
        AnnioEscolar other = (AnnioEscolar) object;
        if ((this.idAnnioEsc == null && other.idAnnioEsc != null) || (this.idAnnioEsc != null && !this.idAnnioEsc.equals(other.idAnnioEsc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.virtualeduc.tuescuelavirtual.models.AnnioEscolar[ idAnnioEsc=" + idAnnioEsc + " ]";
    }
    
}
