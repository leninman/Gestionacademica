/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Alumno;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;

import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;

import java.util.List;

//import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Personal
 */
@RestController
@RequestMapping("/app")
@CrossOrigin(origins = {"http://localhost:4200"})
public class escuelavirtualController {

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    IRepresentanteService representanteservice;

    Representante representante;

    @GetMapping(path = "/consultaralumnos",
            produces = "application/json")
    public @ResponseBody
    List<AlumnoCursoDTO> consultaralumnos() {
        return alumnoservice.consultarAlumnos();
    }
    
    
    @GetMapping(path = "/consultarlistalumnos",
            produces = "application/json")
    public @ResponseBody
    List<AlumnoDTO> consultarlistalumnos() {
        return alumnoservice.consultarTodosLosAlumnos();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registraralumno",
            consumes = "application/json", produces = "application/json")
    public Responses registraralumno(@RequestBody Alumno alumno) {

        return alumnoservice.guardaAlumno(alumno);

    }

}
