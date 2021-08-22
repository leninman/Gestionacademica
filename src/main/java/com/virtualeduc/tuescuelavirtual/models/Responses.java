/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Lenin
 */
public class Responses implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int responseCode;

    private String responseDescription;
    
    private AlumnoDTO alumno;
    
    private CursoDTO curso;
    
    private AnnioEscolarDTO annioescolar;
    
    private List<AlumnoDTO> listadeAlumnos;
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
    
    
    public CursoDTO getCurso() {
		return curso;
	}

	public void setCurso(CursoDTO curso) {
		this.curso = curso;
	}
	
	

	public AnnioEscolarDTO getAnnioescolar() {
		return annioescolar;
	}

	public void setAnnioescolar(AnnioEscolarDTO annioescolar) {
		this.annioescolar = annioescolar;
	}
	
	

	public List<AlumnoDTO> getListadeAlumnos() {
		return listadeAlumnos;
	}

	public void setListadeAlumnos(List<AlumnoDTO> listadeAlumnos) {
		this.listadeAlumnos = listadeAlumnos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Responses() {
        
    }

  

  

   
    
    
    
    
    
    
    

 

	public Responses(int responseCode, String responseDescription, AlumnoDTO alumno, CursoDTO curso,
			AnnioEscolarDTO annioescolar, List<AlumnoDTO> listadeAlumnos) {
		super();
		this.responseCode = responseCode;
		this.responseDescription = responseDescription;
		this.alumno = alumno;
		this.curso = curso;
		this.annioescolar = annioescolar;
		this.listadeAlumnos = listadeAlumnos;
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
