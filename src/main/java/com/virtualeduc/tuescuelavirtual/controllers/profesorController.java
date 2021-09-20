package com.virtualeduc.tuescuelavirtual.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.virtualeduc.tuescuelavirtual.models.Profesion;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IMateriaService;
import com.virtualeduc.tuescuelavirtual.services.IProfesoresService;
import com.virtualeduc.tuescuelavirtual.services.IVariosService;

@Controller
@RequestMapping(path="/app")
public class profesorController {
	@Autowired
	IProfesoresService profesoresService;
	
	@Autowired
	IMateriaService materiasService;
	
	  @Autowired
	  IVariosService variosservice;
	  
	  @Autowired
	  ICursoService cursoservice;
	
	 @Value("${dir.base}")
	 String direccionbase;
	
	@GetMapping(path = "/listarprofesores")
	public String listarprofesores(Model model) {
		
		List<Profesor> listaProfesores = new ArrayList<>();
		listaProfesores = profesoresService.consultarProfesores();
		model.addAttribute("Profesores", listaProfesores);
		return "profesores/listarprofesores";
	}
	
	@GetMapping(path = "/registroprofesor")
	public String registroprofesor(Model model) {
		Profesor profesor = new Profesor();
		List<Profesion> profesiones=new ArrayList<>();
		List<String> materias=new ArrayList<>();
		List<String> annios=new ArrayList<>();
		List<String> niveles=new ArrayList<>();
		List<String> especialidades=new ArrayList<>();
		materias=materiasService.nombresmaterias();
		annios=cursoservice.annios();
		niveles=cursoservice.niveles();
		especialidades=cursoservice.especialidades();
		profesiones=variosservice.consultarProfesiones();
		model.addAttribute("profesor", profesor);
		model.addAttribute("profesiones", profesiones);
		model.addAttribute("materias", materias);
		model.addAttribute("annios", annios);
		model.addAttribute("niveles", niveles);
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("direccionbase",direccionbase);
		return "profesores/registroprofesor";
	}
	
	@PostMapping(path = "/agregarprofesor")
	public String registrarprofesor(@Valid Profesor profesor, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		return "redirect:listarprofesores?success";
	}
}
