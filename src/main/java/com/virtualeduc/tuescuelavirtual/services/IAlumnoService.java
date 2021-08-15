/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;

import com.virtualeduc.tuescuelavirtual.models.Responses;

import java.util.List;

/**
 *
 * @author Personal
 */
public interface IAlumnoService {

    public Alumno consultarAlumnoPorCedula(String tipoDocAl, String numDocAl);

    public Alumno consultarAlumnoPorId(Long id);

    public List<AlumnoCursoDTO> consultarAlumnos();
    
    public List<AlumnoDTO> consultarTodosLosAlumnos();

    public Responses guardaAlumno(Alumno alumno,Boolean guardar);
    
    public Long[] consultarAlumnoPorIdCurso(Long idcurso);
    
    public String consultarCedulasDeAlumnos(String tipoDocAl, String numDocAl);
    

}
