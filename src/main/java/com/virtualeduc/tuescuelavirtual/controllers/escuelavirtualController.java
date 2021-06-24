/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.RepresentanteDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author Personal
 */
@Controller
@RequestMapping("/app")
public class escuelavirtualController {

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    IRepresentanteService representanteservice;

    @Autowired
    ICursoService cursoservice;

    Representante representante;

    @GetMapping(path = "/inicio")
    public String inicio(Model model) {
        return "inicio";
    }

    @GetMapping(path = "/registroalumno")
    public String registrolumno(Model model) {
        List<CursoDTO> cursos = new ArrayList<>();
        AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolarPorAnnioEscolar();
        cursos = cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
        model.addAttribute("Cursos", cursos);
        return "alumnos/registroalumno";
    }

    @GetMapping(path = "/listaralumnos")
    public String listaralumnos(Model model) {
        List<AlumnoCursoDTO> listaAlumnos = new ArrayList<>();
        listaAlumnos = alumnoservice.consultarAlumnos();
        model.addAttribute("Alumnos", listaAlumnos);
        return "alumnos/listaralumnos";
    }

    @RequestMapping(path = "/consrepresentante",method = RequestMethod.GET)
    public String consultarepresentante(@RequestParam String tipoDeDocumento,@RequestParam String numeroDeDocumento, Model model){
        RepresentanteDTO rep = new RepresentanteDTO();
        rep=representanteservice.obtenerRepresentantePorCedula(tipoDeDocumento, numeroDeDocumento);
        model.addAttribute("representante",rep);
        return "redirect:alumnos/registroalumno";
    }
    
}
