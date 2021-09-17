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

import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.services.IProfesoresService;

@Controller
@RequestMapping(path="/app")
public class profesorController {
	@Autowired
	IProfesoresService profesoresService;
	
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
		model.addAttribute("profesor", profesor);
		model.addAttribute("direccionbase",direccionbase);
		return "profesores/registroprofesor";
	}
	
	@PostMapping(path = "/agregarprofesor")
	public String registrarprofesor(@Valid Profesor profesor, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		return "redirect:listarprofesores?success";
	}
}
