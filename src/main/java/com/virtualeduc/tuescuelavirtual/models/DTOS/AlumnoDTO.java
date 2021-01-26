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

    private Character sexoAl;

    private Date fechNacAl;

    private int edadAl;

    private String dirPpalAl;

    private String dirSecAl;

    private String tlfPpalAl;

    private String tlfSecAl;

    private String emailAl;

    private Date fechIngAl;

    private String status;

    private Long idRpr1;
    
//    private Representante Rpr1;
//    
//    private Representante Rpr2;
    
    private Long idCurso;

    private Long idRpr2;

    private Date fechaCreacion;

//    @PrePersist
//    public void prePersist() {
//        fechaCreacion = new Date();
//
//    }
    public AlumnoDTO() {
    }

    public AlumnoDTO(Long idAl, String tipoDocAl, String numDocAl, String primNombAl, String segNombAl, String primApellAl, String segApellAl, Character sexoAl, Date fechNacAl, int edadAl, String dirPpalAl, String dirSecAl, String tlfPpalAl, String tlfSecAl, String emailAl, Date fechIngAl, String status, Long idRpr1, Representante Rpr1, Representante Rpr2, Long idCurso, Long idRpr2, Date fechaCreacion) {
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
//        this.Rpr1 = Rpr1;
//        this.Rpr2 = Rpr2;
        this.idCurso = idCurso;
        this.idRpr2 = idRpr2;
        this.fechaCreacion = fechaCreacion;
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

//    public Representante getRpr1() {
//        return Rpr1;
//    }

//    public void setRpr1(Representante Rpr1) {
//        this.Rpr1 = Rpr1;
//    }

//    public Representante getRpr2() {
//        return Rpr2;
//    }
//
//    public void setRpr2(Representante Rpr2) {
//        this.Rpr2 = Rpr2;
//    }
    
    
}
