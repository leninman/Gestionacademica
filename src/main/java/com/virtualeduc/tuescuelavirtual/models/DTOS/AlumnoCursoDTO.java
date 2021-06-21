/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

/**
 *
 * @author Lenin
 */
import com.virtualeduc.tuescuelavirtual.models.Alumno;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class AlumnoCursoDTO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long IdAl;

    private String tipoDocAl;

    private String numDocAl;

    private String primNombAl;

    private String segNombAl;

    private String primApellAl;

    private String segApellAl;

    private String annio;

    private String seccion;

    public AlumnoCursoDTO() {
    }

    public AlumnoCursoDTO(Alumno alumno) {
        this.IdAl = alumno.getIdAl();
        this.tipoDocAl = alumno.getTipoDocAl();
        this.numDocAl = alumno.getNumDocAl();
        this.primNombAl = alumno.getPrimNombAl();
        this.segNombAl = alumno.getSegNombAl();
        this.primApellAl = alumno.getPrimApellAl();
        this.segApellAl = alumno.getSegApellAl();
        this.annio = alumno.getIdCurso().getIdAnnio().getAnnio();
        this.seccion = alumno.getIdCurso().getIdSec().getSeccion();

    }

    public AlumnoCursoDTO(Long IdAl, String tipoDocAl, String numDocAl, String primNombAl, String segNombAl, String primApellAl, String segApellAl, String annio, String seccion) {
        this.IdAl = IdAl;
        this.tipoDocAl = tipoDocAl;
        this.numDocAl = numDocAl;
        this.primNombAl = primNombAl;
        this.segNombAl = segNombAl;
        this.primApellAl = primApellAl;
        this.segApellAl = segApellAl;
        this.annio = annio;
        this.seccion = seccion;

    }

    public Long getIdAl() {
        return IdAl;
    }

    public void setIdAl(Long IdAl) {
        this.IdAl = IdAl;
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

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

}
