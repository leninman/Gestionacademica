/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author lenin
 */
public class Notawrapper implements Serializable {

    private Long idAl;

    private String tipoDocAl;

    private String numDocAl;

    private String primNombAl;

    private String segNombAl;

    private String primApellAl;

    private String segApellAl;

    private Long idCurso;

    private String annio;

    private String intAnnioEsc;

    private String seccion;

    private String turno;

    private String nivel;

    private String especialidad;
    
    private Long idMateria;
    
    private String codigoMat;
    
    private String nombreMat;
    
     private Long idPrf;
     
     private String tipoDocPrf;
     
     private String numDocPrf;
     
     private String primNombPrf;
     
     private String primApellPrf;
     
     private String segNombPrf;
     
     private String segApellPrf;
     
     private Long idLapso;
     
     private String periodo;
     
     private String lapsodescripcion;
     
     private Float nota;

    
     public Notawrapper(){
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

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getIntAnnioEsc() {
        return intAnnioEsc;
    }

    public void setIntAnnioEsc(String intAnnioEsc) {
        this.intAnnioEsc = intAnnioEsc;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getCodigoMat() {
        return codigoMat;
    }

    public void setCodigoMat(String codigoMat) {
        this.codigoMat = codigoMat;
    }

    public String getNombreMat() {
        return nombreMat;
    }

    public void setNombreMat(String nombreMat) {
        this.nombreMat = nombreMat;
    }

    public Long getIdPrf() {
        return idPrf;
    }

    public void setIdPrf(Long idPrf) {
        this.idPrf = idPrf;
    }

    public String getTipoDocPrf() {
        return tipoDocPrf;
    }

    public void setTipoDocPrf(String tipoDocPrf) {
        this.tipoDocPrf = tipoDocPrf;
    }

    public String getNumDocPrf() {
        return numDocPrf;
    }

    public void setNumDocPrf(String numDocPrf) {
        this.numDocPrf = numDocPrf;
    }

    public String getPrimNombPrf() {
        return primNombPrf;
    }

    public void setPrimNombPrf(String primNombPrf) {
        this.primNombPrf = primNombPrf;
    }

    public String getPrimApellPrf() {
        return primApellPrf;
    }

    public void setPrimApellPrf(String primApellPrf) {
        this.primApellPrf = primApellPrf;
    }

    public String getSegNombPrf() {
        return segNombPrf;
    }

    public void setSegNombPrf(String segNombPrf) {
        this.segNombPrf = segNombPrf;
    }

    public String getSegApellPrf() {
        return segApellPrf;
    }

    public void setSegApellPrf(String segApellPrf) {
        this.segApellPrf = segApellPrf;
    }

    public Long getIdLapso() {
        return idLapso;
    }

    public void setIdLapso(Long idLapso) {
        this.idLapso = idLapso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getLapsodescripcion() {
        return lapsodescripcion;
    }

    public void setLapsodescripcion(String lapsodescripcion) {
        this.lapsodescripcion = lapsodescripcion;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }
    
    
}
