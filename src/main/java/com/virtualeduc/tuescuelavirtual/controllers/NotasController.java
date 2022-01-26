package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Cursos_prof;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Usuario;
import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasAsignada;

import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IProfesoresService;
import com.virtualeduc.tuescuelavirtual.services.IUsuarioService;

import com.virtualeduc.tuescuelavirtual.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/app")
public class NotasController {

    @Autowired
    IUsuarioService usuarioservice;

    @Autowired
    IProfesoresService profesoresService;

    @Autowired
    ICursoService cursoservice;

    List<ViewCursosMateriasAsignada> cursosmateriasprof;
    
    Profesor profesor;

    protected final Log logger = LogFactory.getLog(this.getClass());

    @GetMapping("/verCursos")
    public String verCursos(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            logger.info("El usuario " + auth.getName() + " ha ingresado al módulo de notas");
        }

        if (Utils.hasRole("ROLE_USER_PROFESOR")) {

            logger.info("Hola usuario ".concat(auth.getName()).concat(" tienes acceso"));

            String user = auth.getName();

            Usuario usuario = usuarioservice.findUsuarioByUserName(user);

            profesor = profesoresService.consultarProfesorPorCedula(usuario.getTipodoc(), usuario.getNrodoc());

            if (profesor != null) {

                cursosmateriasprof = cursoservice.consultarcursomateriaprofesor(profesor.getIdPrf());

            } else {
                logger.info("Hola usuario ".concat(auth.getName()).concat(" no tienes acceso"));
            }

        }
        model.addAttribute("profesor", profesor);
        model.addAttribute("cursosmateriasprof", cursosmateriasprof);
        
        return "notas/principal";
    }
}
