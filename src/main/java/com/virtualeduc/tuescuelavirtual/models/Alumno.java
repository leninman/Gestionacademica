/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "alumnos")

public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AL")
    private Long idAl;
    @Basic(optional = false)
    @Column(name = "TIPO_DOC_AL")
    private String tipoDocAl;
    @Basic(optional = false)
    @Column(name = "NUM_DOC_AL")
    private String numDocAl;
    @Basic(optional = false)
    @Column(name = "PRIM_NOMB_AL")
    private String primNombAl;
    @Column(name = "SEG_NOMB_AL")
    private String segNombAl;
    @Basic(optional = false)
    @Column(name = "PRIM_APELL_AL")
    private String primApellAl;
    @Column(name = "SEG_APELL_AL")
    private String segApellAl;
    @Basic(optional = false)
    @Column(name = "SEXO_AL")
    private Character sexoAl;
    @Basic(optional = false)
    @Column(name = "FECH_NAC_AL")
    @Temporal(TemporalType.DATE)
    private Date fechNacAl;
    @Basic(optional = false)
    @Column(name = "EDAD_AL")
    private int edadAl;
    @Basic(optional = false)
    @Column(name = "DIR_PPAL_AL")
    private String dirPpalAl;
    @Basic(optional = false)
    @Column(name = "DIR_SEC_AL")
    private String dirSecAl;
    @Basic(optional = false)
    @Column(name = "TLF_PPAL_AL")
    private String tlfPpalAl;
    @Basic(optional = false)
    @Column(name = "TLF_SEC_AL")
    private String tlfSecAl;
    @Column(name = "EMAIL_AL")
    private String emailAl;
    @Basic(optional = false)
    @Column(name = "FECH_ING_AL")
    @Temporal(TemporalType.DATE)
    private Date fechIngAl;
    
    @JoinColumn(name = "ID_RPR1", referencedColumnName = "ID_RPR")
    @ManyToOne(optional = false)
    private Representante representante;
    
    @JoinColumn(name = "ID_RPR2", referencedColumnName = "ID_RPR")
    @ManyToOne
    private Representante representante1;
    
    @JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(optional = false)
    private Curso curso;

    public Alumno() {
        
    }

    public Alumno(Long idAl) {
        this.idAl = idAl;
    }

    public Alumno(Long idAl, String tipoDocAl, String numDocAl, String primNombAl, String primApellAl, Character sexoAl, Date fechNacAl, int edadAl, String dirPpalAl, String dirSecAl, String tlfPpalAl, String tlfSecAl, Date fechIngAl) {
        this.idAl = idAl;
        this.tipoDocAl = tipoDocAl;
        this.numDocAl = numDocAl;
        this.primNombAl = primNombAl;
        this.primApellAl = primApellAl;
        this.sexoAl = sexoAl;
        this.fechNacAl = fechNacAl;
        this.edadAl = edadAl;
        this.dirPpalAl = dirPpalAl;
        this.dirSecAl = dirSecAl;
        this.tlfPpalAl = tlfPpalAl;
        this.tlfSecAl = tlfSecAl;
        this.fechIngAl = fechIngAl;
    }

    public Long getIdAl() {
        return idAl;
    }

    public void setIdAl(Long idAl) {
        this.idAl = idAl;
    }

    public String getTipoDocAl() {
        return tipoDocAl;
    }

    public void setTipoDocAl(String tipoDocAl) {
        this.tipoDocAl = tipoDocAl;
    }

    public String getNumDocAl() {
        return numDocAl;
    }

    public void setNumDocAl(String numDocAl) {
        this.numDocAl = numDocAl;
    }

    public String getPrimNombAl() {
        return primNombAl;
    }

    public void setPrimNombAl(String primNombAl) {
        this.primNombAl = primNombAl;
    }

    public String getSegNombAl() {
        return segNombAl;
    }

    public void setSegNombAl(String segNombAl) {
        this.segNombAl = segNombAl;
    }

    public String getPrimApellAl() {
        return primApellAl;
    }

    public void setPrimApellAl(String primApellAl) {
        this.primApellAl = primApellAl;
    }

    public String getSegApellAl() {
        return segApellAl;
    }

    public void setSegApellAl(String segApellAl) {
        this.segApellAl = segApellAl;
    }

    public Character getSexoAl() {
        return sexoAl;
    }

    public void setSexoAl(Character sexoAl) {
        this.sexoAl = sexoAl;
    }

    public Date getFechNacAl() {
        return fechNacAl;
    }

    public void setFechNacAl(Date fechNacAl) {
        this.fechNacAl = fechNacAl;
    }

    public int getEdadAl() {
        return edadAl;
    }

    public void setEdadAl(int edadAl) {
        this.edadAl = edadAl;
    }

    public String getDirPpalAl() {
        return dirPpalAl;
    }

    public void setDirPpalAl(String dirPpalAl) {
        this.dirPpalAl = dirPpalAl;
    }

    public String getDirSecAl() {
        return dirSecAl;
    }

    public void setDirSecAl(String dirSecAl) {
        this.dirSecAl = dirSecAl;
    }

    public String getTlfPpalAl() {
        return tlfPpalAl;
    }

    public void setTlfPpalAl(String tlfPpalAl) {
        this.tlfPpalAl = tlfPpalAl;
    }

    public String getTlfSecAl() {
        return tlfSecAl;
    }

    public void setTlfSecAl(String tlfSecAl) {
        this.tlfSecAl = tlfSecAl;
    }

    public String getEmailAl() {
        return emailAl;
    }

    public void setEmailAl(String emailAl) {
        this.emailAl = emailAl;
    }

    public Date getFechIngAl() {
        return fechIngAl;
    }

    public void setFechIngAl(Date fechIngAl) {
        this.fechIngAl = fechIngAl;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Representante getRepresentante1() {
        return representante1;
    }

    public void setRepresentante1(Representante representante1) {
        this.representante1 = representante1;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCursos(Curso curso) {
        this.curso = curso;
    }

   

   

   
    
}
