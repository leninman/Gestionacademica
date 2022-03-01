package com.virtualeduc.tuescuelavirtual.controllers;



import java.security.Principal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	
    @Value("${dir.base}")
    String direccionbase;
    
    @Value("${dir.registro.usuario}")
    String direccionregistrousuario;

	
//	@GetMapping("/login")
        @GetMapping(path = {"/login",""})
	public String login(@RequestParam(name="error",required=false) String error,
			Model model,Principal principal,RedirectAttributes flash,@RequestParam(name="logout",required=false) String logout) {
		
		if(principal!=null) {
			
			flash.addFlashAttribute("info","Ya ha iniciado sesión anteriormente");
			return "redirect:/inicio";
		}
		
		if(error!=null) {
			model.addAttribute("error","Error en el login nombre de usuario o contraseña incorrecta,por favor vuelva a intentar!");
		
		}
		
		if(logout!=null) {
			model.addAttribute("logout","Has cerrado sesión con éxito!");
			
			//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			
			
			//logger.info("El usuario "+auth.getName()+" ha cerrado sesión");
	
		
		}
		
		model.addAttribute("direccionbase", direccionbase);
		
		model.addAttribute("direccionregistrousuario", direccionregistrousuario);
		
		
		
		
		
		return "login";
	}

}
