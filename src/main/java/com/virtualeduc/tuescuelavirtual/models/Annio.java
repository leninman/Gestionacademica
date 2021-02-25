/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
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

    @NamedNativeQuery(name="Annio.consultarAnnioByAnnio",
            
            query="SELECT * from annios a "
                    + "WHERE a.ANNIO=:annio",
            resultClass = Annio.class
    ),
    
})







@Entity
@Table(name = "annios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annio.findAll", query = "SELECT a FROM Annio a")
    , @NamedQuery(name = "Annio.findByIdAnnio", query = "SELECT a FROM Annio a WHERE a.idAnnio = :idAnnio")
    , @NamedQuery(name = "Annio.findByAnnio", query = "SELECT a FROM Annio a WHERE a.annio = :annio")
    , @NamedQuery(name = "Annio.findByNivel", query = "SELECT a FROM Annio a WHERE a.nivel = :nivel")
    , @NamedQuery(name = "Annio.findByEspecialidad", query = "SELECT a FROM Annio a WHERE a.especialidad = :especialidad")})
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAnnio")
    private Collection<Curso> cursoCollection;

    public Annio() {
    }

    public Annio(Long idAnnio) {
        this.idAnnio = idAnnio;
    }
    
    
     public Annio(AnnioDTO annioDTO) {
        this.idAnnio = annioDTO.getIdAnnio();
        this.annio=annioDTO.getAnnio();
        this.nivel=annioDTO.getNivel();
        this.especialidad=annioDTO.getEspecialidad();
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
        hash += (idAnnio != null ? idAnnio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annio)) {
            return false;
        }
        Annio other = (Annio) object;
        if ((this.idAnnio == null && other.idAnnio != null) || (this.idAnnio != null && !this.idAnnio.equals(other.idAnnio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.virtualeduc.tuescuelavirtual.models.Annio[ idAnnio=" + idAnnio + " ]";
    }
    
}
