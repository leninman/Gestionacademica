/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
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

    @NamedNativeQuery(name="Curso.consultarCursoByParametros",
            
            query="SELECT * from cursos a "
                    + "WHERE a.ID_ANNIO=:idannio and a.ID_SEC=:idseccion and a.ID_ANNIO_ESC=:idannioesc",
            resultClass = Curso.class
    ),
    
})



@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso")})
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


    
    @XmlTransient
    public Collection<Alumno> getAlumnoCollection() {
        return alumnoCollection;
    }

    public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
        this.alumnoCollection = alumnoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.virtualeduc.tuescuelavirtual.models.Curso[ idCurso=" + idCurso + " ]";
    }
    
}
