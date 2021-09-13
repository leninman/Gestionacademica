package com.virtualeduc.tuescuelavirtual.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path={"/app","/",""})
public class inicioController {

	// METODO PARA LA PAGINA DE INICIO
		@GetMapping(path = {"/inicio","/",""})
		public String inicio(Model model) {
			return "inicio";
		}
}
