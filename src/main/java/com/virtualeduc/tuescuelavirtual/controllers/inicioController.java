package com.virtualeduc.tuescuelavirtual.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller


public class inicioController {

    // METODO PARA LA PAGINA DE INICIO
@GetMapping(path = {"/inicio"})
    public String inicio(Model model) {
        return "inicio";
    }
}
