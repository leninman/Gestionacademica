/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.NotasParDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.ProfesorDTO;

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

    private List<NotasParDTO> notasParciales;

    private MateriaDTO materia;

    public ProfesorDTO profesor;

    public Responses() {

    }

    public AlumnoDTO getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDTO alumno) {
        this.alumno = alumno;
    }

    public void setCurso(CursoDTO curso) {
        this.curso = curso;
    }

    public CursoDTO getCurso() {
        return curso;
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

    public List<NotasParDTO> getNotasParciales() {
        return notasParciales;
    }

    public void setNotasParciales(List<NotasParDTO> notasParciales) {
        this.notasParciales = notasParciales;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
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
