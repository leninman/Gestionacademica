/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class Responses implements Serializable {

    private int responseCode;

    private String responseDescription;
    
    private Alumno alumno;
    
    private Representante representante;
    
    private Curso curso;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    public Responses() {
        
    }

    public Responses(int responseCode, String responseDescription, Alumno alumno, Representante representante, Curso curso) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.alumno = alumno;
        this.representante = representante;
        this.curso = curso;
    }
    
    
    
    
    
    
    

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }
    
    
    
    

    
}
