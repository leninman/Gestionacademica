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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.virtualeduc.tuescuelavirtual.models.DTOS.TurnoDTO;
/**
 *
 * @author Lenin
 */

@Entity
@Table(name = "turnos")
public class Turno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TURNO")
    private Long idTurno;
    @Basic(optional = false)
    @Column(name = "TURNO")
    private String turno;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTurno")
    private Collection<Curso> cursoCollection;

    public Turno() {
    }

    public Turno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public Turno(Long idTurno, String turno) {
        this.idTurno = idTurno;
        this.turno = turno;
    }
    
    public Turno(TurnoDTO turnoDTO) {
        this.idTurno = turnoDTO.getIdTurno();
        this.turno = turnoDTO.getTurno();
    }
    

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }  
}
