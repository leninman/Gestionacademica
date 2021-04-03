/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.PrePersist;

/**
 *
 * @author Lenin
 */
public class AlumnoDTO implements Serializable {

    private Long idAl;

    private String tipoDocAl;

    private String numDocAl;

    private String primNombAl;

    private String segNombAl;

    private String primApellAl;

    private String segApellAl;

    private String sexoAl;

    private Date fechNacAl;

    private String edadAl;

    private String dirPpalAl;

    private String dirSecAl;

    private String tlfPpalAl;

    private String tlfSecAl;

    private String emailAl;

    private Date fechIngAl;

    private String status;

    private Long idRpr1;

    private Long idCurso;

    private Long idRpr2;

    private Date fechaCreacion;

    private String annio;

    private String annioescolar;

    private String seccion;

    private String tipoDocRep1;

    private String numDocRep1;

    private String primNombRpr1;

    private String segNombRpr1;

    private String primApellRpr1;

    private String segApellRpr1;

    private String sexoRpr1;

    private Date fechNacRpr1;

    private String edadRpr1;

    private String edoCivRpr1;

    private String parentescoRpr1;

    private String dirPpalRpr1;

    private String dirSecRpr1;

    private String tlfPpalRpr1;

    private String tlfSecRpr1;

    private String emailRpr1;

    private String tipoDocRep2;

    private String numDocRep2;

    private String primNombRpr2;

    private String segNombRpr2;

    private String primApellRpr2;

    private String segApellRpr2;

    private String sexoRpr2;

    private Date fechNacRpr2;

    private String edadRpr2;

    private String edoCivRpr2;

    private String parentescoRpr2;

    private String dirPpalRpr2;

    private String dirSecRpr2;

    private String tlfPpalRpr2;

    private String tlfSecRpr2;

    private String emailRpr2;

//    @PrePersist
//    public void prePersist() {
//        fechaCreacion = new Date();
//
//    }
    public AlumnoDTO() {
    }

    public AlumnoDTO(Long idAl, String tipoDocAl, String numDocAl, String primNombAl, String segNombAl, String primApellAl, String segApellAl, String sexoAl, Date fechNacAl, String edadAl, String dirPpalAl, String dirSecAl, String tlfPpalAl, String tlfSecAl, String emailAl, Date fechIngAl, String status, Long idRpr1, Long idCurso, Long idRpr2, Date fechaCreacion, String annio, String annioescolar, String seccion, String tipoDocRep1, String numDocRep1, String primNombRpr1, String segNombRpr1, String primApellRpr1, String segApellRpr1, String sexoRpr1, Date fechNacRpr1, String edadRpr1, String edoCivRpr1, String parentescoRpr1, String dirPpalRpr1, String dirSecRpr1, String tlfPpalRpr1, String tlfSecRpr1, String emailRpr1, String tipoDocRep2, String numDocRep2, String primNombRpr2, String segNombRpr2, String primApellRpr2, String segApellRpr2, String sexoRpr2, Date fechNacRpr2, String edadRpr2, String edoCivRpr2, String parentescoRpr2, String dirPpalRpr2, String dirSecRpr2, String tlfPpalRpr2, String tlfSecRpr2, String emailRpr2) {
        this.idAl = idAl;
        this.tipoDocAl = tipoDocAl;
        this.numDocAl = numDocAl;
        this.primNombAl = primNombAl;
        this.segNombAl = segNombAl;
        this.primApellAl = primApellAl;
        this.segApellAl = segApellAl;
        this.sexoAl = sexoAl;
        this.fechNacAl = fechNacAl;
        this.edadAl = edadAl;
        this.dirPpalAl = dirPpalAl;
        this.dirSecAl = dirSecAl;
        this.tlfPpalAl = tlfPpalAl;
        this.tlfSecAl = tlfSecAl;
        this.emailAl = emailAl;
        this.fechIngAl = fechIngAl;
        this.status = status;
        this.idRpr1 = idRpr1;
        this.idCurso = idCurso;
        this.idRpr2 = idRpr2;
        this.fechaCreacion = fechaCreacion;
        this.annio = annio;
        this.annioescolar = annioescolar;
        this.seccion = seccion;
        this.tipoDocRep1 = tipoDocRep1;
        this.numDocRep1 = numDocRep1;
        this.primNombRpr1 = primNombRpr1;
        this.segNombRpr1 = segNombRpr1;
        this.primApellRpr1 = primApellRpr1;
        this.segApellRpr1 = segApellRpr1;
        this.sexoRpr1 = sexoRpr1;
        this.fechNacRpr1 = fechNacRpr1;
        this.edadRpr1 = edadRpr1;
        this.edoCivRpr1 = edoCivRpr1;
        this.parentescoRpr1 = parentescoRpr1;
        this.dirPpalRpr1 = dirPpalRpr1;
        this.dirSecRpr1 = dirSecRpr1;
        this.tlfPpalRpr1 = tlfPpalRpr1;
        this.tlfSecRpr1 = tlfSecRpr1;
        this.emailRpr1 = emailRpr1;
        this.tipoDocRep2 = tipoDocRep2;
        this.numDocRep2 = numDocRep2;
        this.primNombRpr2 = primNombRpr2;
        this.segNombRpr2 = segNombRpr2;
        this.primApellRpr2 = primApellRpr2;
        this.segApellRpr2 = segApellRpr2;
        this.sexoRpr2 = sexoRpr2;
        this.fechNacRpr2 = fechNacRpr2;
        this.edadRpr2 = edadRpr2;
        this.edoCivRpr2 = edoCivRpr2;
        this.parentescoRpr2 = parentescoRpr2;
        this.dirPpalRpr2 = dirPpalRpr2;
        this.dirSecRpr2 = dirSecRpr2;
        this.tlfPpalRpr2 = tlfPpalRpr2;
        this.tlfSecRpr2 = tlfSecRpr2;
        this.emailRpr2 = emailRpr2;
    }

    public AlumnoDTO(Long idAl) {
        this.idAl = idAl;
    }

    public AlumnoDTO(Alumno alumno) {
        this.idAl = alumno.getIdAl();
        this.tipoDocAl = alumno.getTipoDocAl();
        this.numDocAl = alumno.getNumDocAl();
        this.primNombAl = alumno.getPrimNombAl();
        this.segNombAl = alumno.getSegNombAl();
        this.primApellAl = alumno.getPrimApellAl();
        this.segApellAl = alumno.getSegNombAl();
        this.sexoAl = alumno.getSexoAl();
        this.fechNacAl = alumno.getFechNacAl();
        this.edadAl = alumno.getEdadAl();
        this.dirPpalAl = alumno.getDirPpalAl();
        this.dirSecAl = alumno.getDirSecAl();
        this.tlfPpalAl = alumno.getTlfPpalAl();
        this.tlfSecAl = alumno.getTlfSecAl();
        this.emailAl = alumno.getEmailAl();
        this.fechIngAl = alumno.getFechIngAl();
        this.status = alumno.getStatus();
        this.idRpr1 = alumno.getIdRpr1().getIdRpr();
        this.idCurso = alumno.getIdCurso().getIdCurso();
        this.idRpr2 = alumno.getIdRpr2().getIdRpr();
        
        this.fechaCreacion = alumno.getFechaCreacion();
        this.annio=alumno.getIdCurso().getIdAnnio().getAnnio();
        this.annioescolar=alumno.getIdCurso().getIdAnnioEsc().getIntAnnioEsc();
        this.seccion=alumno.getIdCurso().getIdSec().getSeccion();
        
        this.tipoDocRep1 = alumno.getIdRpr1().getTipoDocRpr();
        this.numDocRep1 = alumno.getIdRpr1().getNumDocRpr();
        this.primNombRpr1 = alumno.getIdRpr1().getPrimNombRpr();
        this.segNombRpr1 = alumno.getIdRpr1().getSegNombRpr();
        this.primApellRpr1 = alumno.getIdRpr1().getPrimApellRpr();
        this.segApellRpr1 = alumno.getIdRpr1().getSegApellRpr();
        this.sexoRpr1 = alumno.getIdRpr1().getSexoRpr();
        this.fechNacRpr1 = alumno.getIdRpr1().getFechNacRpr();
        this.edadRpr1 = alumno.getIdRpr1().getEdadRpr();
        this.edoCivRpr1 = alumno.getIdRpr1().getEdoCivRpr();
        this.parentescoRpr1 = alumno.getIdRpr1().getParentescoRpr();
        this.dirPpalRpr1 = alumno.getIdRpr1().getDirPpalRpr();
        this.dirSecRpr1 = alumno.getIdRpr1().getDirSecRpr();
        this.tlfPpalRpr1 = alumno.getIdRpr1().getTlfPpalRpr();
        this.tlfSecRpr1 = alumno.getIdRpr1().getTlfSecRpr();
        this.emailRpr1 = alumno.getIdRpr1().getEmailRpr();
        
        this.tipoDocRep2 =  alumno.getIdRpr2().getTipoDocRpr();
        this.numDocRep2 = alumno.getIdRpr2().getNumDocRpr();
        this.primNombRpr2 = alumno.getIdRpr2().getPrimNombRpr();
        this.segNombRpr2 = alumno.getIdRpr2().getSegNombRpr();
        this.primApellRpr2 = alumno.getIdRpr2().getPrimApellRpr();
        this.segApellRpr2 = alumno.getIdRpr2().getSegApellRpr();
        this.sexoRpr2 = alumno.getIdRpr2().getSexoRpr();
        this.fechNacRpr2 = alumno.getIdRpr2().getFechNacRpr();
        this.edadRpr2 = alumno.getIdRpr2().getEdadRpr();
        this.edoCivRpr2 = alumno.getIdRpr2().getEdoCivRpr();
        this.parentescoRpr2 = alumno.getIdRpr2().getParentescoRpr();
        this.dirPpalRpr2 = alumno.getIdRpr2().getDirPpalRpr();
        this.dirSecRpr2 =  alumno.getIdRpr2().getDirSecRpr();
        this.tlfPpalRpr2 = alumno.getIdRpr2().getTlfPpalRpr();
        this.tlfSecRpr2 = alumno.getIdRpr2().getTlfSecRpr();
        this.emailRpr2 = alumno.getIdRpr2().getEmailRpr();
        
        

//        this.setRpr1(alumno.getIdRpr1());
//        this.setRpr2(alumno.getIdRpr1());
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

    public String getSexoAl() {
        return sexoAl;
    }

    public void setSexoAl(String sexoAl) {
        this.sexoAl = sexoAl;
    }

    public Date getFechNacAl() {
        return fechNacAl;
    }

    public void setFechNacAl(Date fechNacAl) {
        this.fechNacAl = fechNacAl;
    }

    public String getEdadAl() {
        return edadAl;
    }

    public void setEdadAl(String edadAl) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Long getIdRpr1() {
        return idRpr1;
    }

    public void setIdRpr1(Long idRpr1) {
        this.idRpr1 = idRpr1;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdRpr2() {
        return idRpr2;
    }

    public void setIdRpr2(Long idRpr2) {
        this.idRpr2 = idRpr2;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getAnnioescolar() {
        return annioescolar;
    }

    public void setAnnioescolar(String annioescolar) {
        this.annioescolar = annioescolar;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTipoDocRep1() {
        return tipoDocRep1;
    }

    public void setTipoDocRep1(String tipoDocRep1) {
        this.tipoDocRep1 = tipoDocRep1;
    }

    public String getNumDocRep1() {
        return numDocRep1;
    }

    public void setNumDocRep1(String numDocRep1) {
        this.numDocRep1 = numDocRep1;
    }

    public String getTipoDocRep2() {
        return tipoDocRep2;
    }

    public void setTipoDocRep2(String tipoDocRep2) {
        this.tipoDocRep2 = tipoDocRep2;
    }

    public String getNumDocRep2() {
        return numDocRep2;
    }

    public void setNumDocRep2(String numDocRep2) {
        this.numDocRep2 = numDocRep2;
    }

    public String getPrimNombRpr1() {
        return primNombRpr1;
    }

    public void setPrimNombRpr1(String primNombRpr1) {
        this.primNombRpr1 = primNombRpr1;
    }

    public String getSegNombRpr1() {
        return segNombRpr1;
    }

    public void setSegNombRpr1(String segNombRpr1) {
        this.segNombRpr1 = segNombRpr1;
    }

    public String getPrimApellRpr1() {
        return primApellRpr1;
    }

    public void setPrimApellRpr1(String primApellRpr1) {
        this.primApellRpr1 = primApellRpr1;
    }

    public String getSegApellRpr1() {
        return segApellRpr1;
    }

    public void setSegApellRpr1(String segApellRpr1) {
        this.segApellRpr1 = segApellRpr1;
    }

    public String getSexoRpr1() {
        return sexoRpr1;
    }

    public void setSexoRpr1(String sexoRpr1) {
        this.sexoRpr1 = sexoRpr1;
    }

    public Date getFechNacRpr1() {
        return fechNacRpr1;
    }

    public void setFechNacRpr1(Date fechNacRpr1) {
        this.fechNacRpr1 = fechNacRpr1;
    }

    public String getEdadRpr1() {
        return edadRpr1;
    }

    public void setEdadRpr1(String edadRpr1) {
        this.edadRpr1 = edadRpr1;
    }

    public String getEdoCivRpr1() {
        return edoCivRpr1;
    }

    public void setEdoCivRpr1(String edoCivRpr1) {
        this.edoCivRpr1 = edoCivRpr1;
    }

    public String getParentescoRpr1() {
        return parentescoRpr1;
    }

    public void setParentescoRpr1(String parentescoRpr1) {
        this.parentescoRpr1 = parentescoRpr1;
    }

    public String getDirPpalRpr1() {
        return dirPpalRpr1;
    }

    public void setDirPpalRpr1(String dirPpalRpr1) {
        this.dirPpalRpr1 = dirPpalRpr1;
    }

    public String getDirSecRpr1() {
        return dirSecRpr1;
    }

    public void setDirSecRpr1(String dirSecRpr1) {
        this.dirSecRpr1 = dirSecRpr1;
    }

    public String getTlfPpalRpr1() {
        return tlfPpalRpr1;
    }

    public void setTlfPpalRpr1(String tlfPpalRpr1) {
        this.tlfPpalRpr1 = tlfPpalRpr1;
    }

    public String getTlfSecRpr1() {
        return tlfSecRpr1;
    }

    public void setTlfSecRpr1(String tlfSecRpr1) {
        this.tlfSecRpr1 = tlfSecRpr1;
    }

    public String getEmailRpr1() {
        return emailRpr1;
    }

    public void setEmailRpr1(String emailRpr1) {
        this.emailRpr1 = emailRpr1;
    }

    public String getPrimNombRpr2() {
        return primNombRpr2;
    }

    public void setPrimNombRpr2(String primNombRpr2) {
        this.primNombRpr2 = primNombRpr2;
    }

    public String getSegNombRpr2() {
        return segNombRpr2;
    }

    public void setSegNombRpr2(String segNombRpr2) {
        this.segNombRpr2 = segNombRpr2;
    }

    public String getPrimApellRpr2() {
        return primApellRpr2;
    }

    public void setPrimApellRpr2(String primApellRpr2) {
        this.primApellRpr2 = primApellRpr2;
    }

    public String getSegApellRpr2() {
        return segApellRpr2;
    }

    public void setSegApellRpr2(String segApellRpr2) {
        this.segApellRpr2 = segApellRpr2;
    }

    public String getSexoRpr2() {
        return sexoRpr2;
    }

    public void setSexoRpr2(String sexoRpr2) {
        this.sexoRpr2 = sexoRpr2;
    }

    public Date getFechNacRpr2() {
        return fechNacRpr2;
    }

    public void setFechNacRpr2(Date fechNacRpr2) {
        this.fechNacRpr2 = fechNacRpr2;
    }

    public String getEdadRpr2() {
        return edadRpr2;
    }

    public void setEdadRpr2(String edadRpr2) {
        this.edadRpr2 = edadRpr2;
    }

    public String getEdoCivRpr2() {
        return edoCivRpr2;
    }

    public void setEdoCivRpr2(String edoCivRpr2) {
        this.edoCivRpr2 = edoCivRpr2;
    }

    public String getParentescoRpr2() {
        return parentescoRpr2;
    }

    public void setParentescoRpr2(String parentescoRpr2) {
        this.parentescoRpr2 = parentescoRpr2;
    }

    public String getDirPpalRpr2() {
        return dirPpalRpr2;
    }

    public void setDirPpalRpr2(String dirPpalRpr2) {
        this.dirPpalRpr2 = dirPpalRpr2;
    }

    public String getDirSecRpr2() {
        return dirSecRpr2;
    }

    public void setDirSecRpr2(String dirSecRpr2) {
        this.dirSecRpr2 = dirSecRpr2;
    }

    public String getTlfPpalRpr2() {
        return tlfPpalRpr2;
    }

    public void setTlfPpalRpr2(String tlfPpalRpr2) {
        this.tlfPpalRpr2 = tlfPpalRpr2;
    }

    public String getTlfSecRpr2() {
        return tlfSecRpr2;
    }

    public void setTlfSecRpr2(String tlfSecRpr2) {
        this.tlfSecRpr2 = tlfSecRpr2;
    }

    public String getEmailRpr2() {
        return emailRpr2;
    }

    public void setEmailRpr2(String emailRpr2) {
        this.emailRpr2 = emailRpr2;
    }

}
