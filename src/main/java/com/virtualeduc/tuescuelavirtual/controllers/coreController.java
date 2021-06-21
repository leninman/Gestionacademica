/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.RepresentanteDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.Seccion;

import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Personal
 */
@RestController
@RequestMapping("/app")
@CrossOrigin(origins = {"http://localhost:8080"})
public class coreController {

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    IRepresentanteService representanteservice;

    @Autowired
    ICursoService cursoservice;

    Representante representante;



    @GetMapping(path = "/consultaralumnos",
            produces = "application/json")
    public @ResponseBody
    List<AlumnoCursoDTO> consultaralumnos() {
        return alumnoservice.consultarAlumnos();
    }
    
     @GetMapping(path = "/consultarcursosporperiodo",
            produces = "application/json")
    public @ResponseBody
    List<CursoDTO> consultarlistacursosporperiodo() {
        
        AnnioEscolarDTO annioEscolar=cursoservice.consultarAnnioEscolarPorAnnioEscolar();
        
        return cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
    }
    
     @GetMapping(path = "/consultarepresentante",
            produces = "application/json")
     public RepresentanteDTO consultarepresentante(@RequestParam("tdoc") String tdoc,@RequestParam("ndoc") String ndoc){
            return representanteservice.obtenerRepresentantePorCedula(tdoc, ndoc);
     }

    @RequestMapping(method = RequestMethod.POST, path = "/registraralumno",
            consumes = "application/json", produces = "application/json")
    public Responses registraralumno(@Valid @RequestBody AlumnoDTO alumnoDTO,BindingResult result,Model model) {

        String tipoDocRpr;

        String numDocRpr;
                
        
        /*if(result.hasErrors()) {
        	Map<String,String> errores=new HashMap<>();
        	result.getFieldErrors().forEach(err->{
        		errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ".concat(err.getDefaultMessage())));
        	});
        	model.addAttribute("error", errores);
        }*/
        
        
        
        Responses resp = new Responses();
        
        Alumno alumno = new Alumno(alumnoDTO);

        Curso curso = new Curso();

        AnnioDTO annioDTO = cursoservice.consultarAnnioPorAnnio(alumnoDTO.getAnnio());

        AnnioEscolarDTO annioescolarDTO = cursoservice.consultarAnnioEscolarPorAnnioEscolar();

        SeccionDTO seccionDTO = cursoservice.consultarSeccionPorSeccion(alumnoDTO.getSeccion());

        CursoDTO cursoDTO = cursoservice.consultarcursoporparametros(annioDTO.getIdAnnio(), annioescolarDTO.getIdAnnioEsc(), seccionDTO.getIdSec());

        Annio annio = new Annio(annioDTO);

        AnnioEscolar annioescolar = new AnnioEscolar(annioescolarDTO);

        Seccion seccion = new Seccion(seccionDTO);

        curso.setIdAnnio(annio);

        curso.setIdAnnioEsc(annioescolar);

        curso.setIdSec(seccion);

        curso.setIdCurso(cursoDTO.getIdCurso());

        alumno.setIdCurso(curso);

        //CONSULTA POR EL NUMERO DE CEDULA SI EL REPRESENTANTE ESTE REGISTRADO
        //SI NO ESTA REGISTRADO LO GUARDA Y SI YA EXISTE TOMA ESE REPRESENTANTE COMO EL
        //REPRESENTANTE DEL ALUMNO QUE SE VA A REGISTRAR
        tipoDocRpr = alumnoDTO.getTipoDocRep1();
        numDocRpr = alumnoDTO.getNumDocRep1();
        Representante rep1 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
        if (rep1 == null) {
            Representante rep = new Representante();
            rep1 = rep.setRepresentante1(alumnoDTO);
            alumno.setIdRpr1(representanteservice.guardarRepresentante(rep1));
        } else {
            alumno.setIdRpr1(rep1);
        }

        if (alumnoDTO.getTipoDocRep2() != null && alumnoDTO.getNumDocRep2() != null) {

            tipoDocRpr = alumnoDTO.getTipoDocRep2();
            numDocRpr = alumnoDTO.getNumDocRep2();
            Representante rep2 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
            if (rep2 == null) {
                Representante rep = new Representante();
                rep2 = rep.setRepresentante2(alumnoDTO);
                alumno.setIdRpr1(representanteservice.guardarRepresentante(rep2));
            } else {
                alumno.setIdRpr2(rep2);
            }

        }

        resp=alumnoservice.guardaAlumno(alumno);
        
        return resp;

    }
    
     /*@GetMapping(path = "/consultarlistalumnos",
            produces = "application/json")
    public @ResponseBody
    List<AlumnoDTO> consultarlistalumnos() {
        return alumnoservice.consultarTodosLosAlumnos();
    }

    @GetMapping(path = "/consultarannios",
            produces = "application/json")
    public @ResponseBody
    List<AnnioDTO> consultarlistannios() {
        return cursoservice.consultarannios();
    }

    @GetMapping(path = "/consultarannioescolar",
            produces = "application/json")
    public @ResponseBody
    List<AnnioEscolarDTO> consultarlistannioescolar() {
        return cursoservice.consultaranniosesc();
    }

    @GetMapping(path = "/consultarsecciones",
            produces = "application/json")
    public @ResponseBody
    List<SeccionDTO> consultarlistasecciones() {
        return cursoservice.consultarsecciones();
    }*/
    
    

}