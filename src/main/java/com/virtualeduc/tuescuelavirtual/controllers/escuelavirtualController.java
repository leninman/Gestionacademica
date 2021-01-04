/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Alumno;



import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
//import javax.xml.ws.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//@CrossOrigin(origins = "http://localhost:8080")
public class escuelavirtualController {

    @Autowired
    IAlumnoService alumnoservice;

//     @RequestMapping(method = RequestMethod.POST, path = "/consultalumno",
//            consumes = "application/json",
//            produces = "application/json")
//    public @ResponseBody
//    Alumnos consultaralumno(@RequestBody AlumnosPK alumno) {
//        
//        return alumnoservice.consultaAlumno(alumno);
//        
//    }
   @CrossOrigin(origins = {"http://localhost:4200/consultaralumnos"})
    @GetMapping(path="/consultaralumnos",
            produces = "application/json")
    public @ResponseBody Optional<Alumno> consultaralumnos() {

        return alumnoservice.consultarAlumnos();

    }

    @RequestMapping(method = RequestMethod.POST, path = "/registraralumno",
            consumes = "application/json")
    public void registraralumno(@RequestBody Alumno alumno) {
        
        alumnoservice.guardaAlumno(alumno);

    }

}
