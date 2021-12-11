package com.virtualeduc.tuescuelavirtual.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/app")
public class NotasController {
	
	
	@GetMapping("/verCursos")
	public String verCursos(Model model) {
		
		
		
		return "notas/principal";
		
		
		
	}
	

}
