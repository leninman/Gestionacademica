/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.services;

import com.virtualeduc.tuescuelavirtual.models.Alumno;


import java.util.Collection;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Personal
 */
public interface IAlumnoService {
    
    public Alumno consultaAlumno(Long id);
    
    public Optional<Alumno> consultarAlumnos();
    
    public void guardaAlumno(Alumno alumno);
    
    
}
