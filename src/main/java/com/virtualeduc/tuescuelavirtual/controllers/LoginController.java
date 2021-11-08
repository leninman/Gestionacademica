package com.virtualeduc.tuescuelavirtual.controllers;



import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	public String login(@RequestParam(name="error",required=false) String error,Model model,Principal principal,RedirectAttributes flash) {
		
		if(principal!=null) {
			
			flash.addFlashAttribute("info","Ya ha iniciado sesión anteriormente");
			return "redirect:/inicio";
		}
		
		if(error!=null) {
			model.addAttribute("error","Error en el login nombre de usuario o contraseña incorrecta,por favor vuelva a intentar!");
		
		}
		
		
		return "login";
	}

}
