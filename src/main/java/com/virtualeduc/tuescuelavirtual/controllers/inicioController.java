package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Notasquery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller


public class inicioController {
    
     @Value("${dir.base}")
    String direccionbase;

    // METODO PARA LA PAGINA DE INICIO
@GetMapping(path = {"/inicio"})
    public String inicio(Model model) {
        Notasquery notasquery=new Notasquery();
        model.addAttribute("direccionbase",direccionbase);
        model.addAttribute("notasquery",notasquery);
        return "inicio";
    }
}
