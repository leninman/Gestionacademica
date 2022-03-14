package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Cursos_prof;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.Usuario;
import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasAsignada;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;

import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IProfesoresService;
import com.virtualeduc.tuescuelavirtual.services.IUsuarioService;

import com.virtualeduc.tuescuelavirtual.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

@RequestMapping("/app")
public class NotasController {

    String periodoEscolar;

    @Autowired
    IUsuarioService usuarioservice;

    @Autowired
    IProfesoresService profesoresService;

    @Autowired
    ICursoService cursoservice;

    @Autowired
    IAlumnoService alumnoservice;

    @Value("${dir.base}")
    String direccionbase;

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

    @GetMapping("/cargaNotas")
    public String cargaNotas(
            @RequestParam String annio,
            @RequestParam String seccion,
            @RequestParam String materia,
            @RequestParam Long idPrf,
            @RequestParam Long idMat,
            @RequestParam Long idCurso,
            Model model) {

        Responses resp = alumnoservice.consultarAlumnosPorCurso(idCurso);

        model.addAttribute("alumnos", resp.getListadeAlumnos());

        model.addAttribute("annio", annio);

        model.addAttribute("seccion", seccion);

        model.addAttribute("materia", materia);

        //model.addAttribute("primNombPrf", primNombPrf);

      //  model.addAttribute("primApellPrf", primApellPrf);
        
        model.addAttribute("idPrf", idPrf);
        
        model.addAttribute("idMat", idMat);
        
        model.addAttribute("idCurso", idCurso);
        
        // model.addAttribute("idLapso", idLapso);
        
        model.addAttribute("direccionbase", direccionbase);

        return "notas/formulariocarga";

    }

    @ModelAttribute("periodoEscolar")
    public String obtenerPeriodoEscolar() {

        AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolar();

        this.periodoEscolar = annioEscolar.getIntAnnioEsc();

        return periodoEscolar;

    }
}
