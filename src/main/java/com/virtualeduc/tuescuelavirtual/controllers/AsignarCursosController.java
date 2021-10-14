package com.virtualeduc.tuescuelavirtual.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasSinAsignar;

import com.virtualeduc.tuescuelavirtual.services.ICursoService;

@Controller
@RequestMapping(path="/app")
public class AsignarCursosController {
	
	@Value("${dir.base}")
	String direccionbase;
	
	@Autowired
	ICursoService cursoservice;
	
	
	
	@GetMapping(path = "/verasignarcurso")
	public String verasignarcurso(Model model) {
		
		List<ViewCursosMateriasSinAsignar> materias=new ArrayList<>();
		
		materias=cursoservice.consultarMateriasSinAsignar();
		
		String periodoescolar=materias.get(0).getPeriodoEscolar();
		
		model.addAttribute("direccionbase",direccionbase);
		
		model.addAttribute("materias",materias);
		
		model.addAttribute("periodoescolar",periodoescolar);
		
		return "cursos/verasignarcurso";
	}

}
