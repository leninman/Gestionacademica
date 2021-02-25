/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class Responses implements Serializable {

    private int responseCode;

    private String responseDescription;
    
    private AlumnoDTO alumno;
    
//    private Representante representante;
//    
//    private Curso curso;

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

   

//    public Representante getRepresentante() {
//        return representante;
//    }
//
//    public void setRepresentante(Representante representante) {
//        this.representante = representante;
//    }
//
//    public Curso getCurso() {
//        return curso;
//    }
//
//    public void setCurso(Curso curso) {
//        this.curso = curso;
//    }
    
    
    public Responses() {
        
    }

    public Responses(int responseCode, String responseDescription, AlumnoDTO alumno) {
        this.responseCode = responseCode;
        this.responseDescription = responseDescription;
        this.alumno = alumno;
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
