package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;

import com.virtualeduc.tuescuelavirtual.models.DTOS.Notawrapperporlapso;
import com.virtualeduc.tuescuelavirtual.models.Lapso;

import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.Seccion;
import com.virtualeduc.tuescuelavirtual.models.Turno;
import com.virtualeduc.tuescuelavirtual.models.Usuario;
import com.virtualeduc.tuescuelavirtual.models.ViewCursosMateriasAsignada;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;

import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.INotasService;
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

import org.springframework.web.bind.annotation.*;

@Controller

@RequestMapping("/app")
public class notasController {

    String periodoEscolar;

    @Autowired
    IUsuarioService usuarioservice;

    @Autowired
    IProfesoresService profesoresService;

    @Autowired
    ICursoService cursoservice;

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    INotasService notaservice;

    @Value("${dir.base}")
    String direccionbase;

    List<ViewCursosMateriasAsignada> cursosmateriasprof;

    Profesor profesor;

    private boolean cursoSinAlumnos;

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

        cursoSinAlumnos = true;

        Responses resp = alumnoservice.consultarAlumnosPorCurso(idCurso);

        if (!resp.getListadeAlumnos().isEmpty()) {
            cursoSinAlumnos = false;
        }

        List<Lapso> lapsosdisponibles = notaservice.consultarLapsosHabilitados(idMat, idCurso);

        model.addAttribute("alumnos", resp.getListadeAlumnos());

        model.addAttribute("annio", annio);

        model.addAttribute("seccion", seccion);

        model.addAttribute("materia", materia);

        //model.addAttribute("primNombPrf", primNombPrf);
        //  model.addAttribute("primApellPrf", primApellPrf);
        model.addAttribute("idPrf", idPrf);

        model.addAttribute("idMat", idMat);

        model.addAttribute("idCurso", idCurso);

        model.addAttribute("lapsosdisponibles", lapsosdisponibles);

        model.addAttribute("cursoSinAlumnos", cursoSinAlumnos);

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

    @ModelAttribute("periodos")
    public List<String> obtenerPeriodosEscolares() {

        List<AnnioEscolar> anniosEscolares = notaservice.consultarPeriodos();

        List<String> periodos = new ArrayList<>();

        for (AnnioEscolar periodo : anniosEscolares) {
            String per = periodo.getIntAnnioEsc();
            periodos.add(per);
        }

        return periodos;

    }

    @ModelAttribute("lapsos")
    public List<Lapso> obtenerLapsos() {

        List<Lapso> lapsos = notaservice.consultarLapsos();

        List<String> periodos = new ArrayList<>();

        return lapsos;

    }

    @GetMapping(path = "/consultarNotas")
    //public String consultarNotas(Notasquery notasquery, Model model) {
    public String consultarNotas(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            logger.info("El usuario " + auth.getName() + " ha ingresado al módulo de consulta de notas");
        }

        String nombreusuario = auth.getName();

        Usuario usuario = usuarioservice.findUsuarioByUserName(nombreusuario);

        String tipoDocumento = usuario.getTipodoc();

        String nroDocumento = usuario.getNrodoc();

        Alumno alumno = alumnoservice.consultarAlumnoPorCedula(tipoDocumento, nroDocumento);

        String nombreAlumno = alumno.getPrimNombAl().concat(" ").concat(alumno.getPrimApellAl());

        String cedulaAlumno = tipoDocumento.concat(nroDocumento);

        Curso curso = alumno.getIdCurso();

        Annio annio = curso.getIdAnnio();

        String anniocursado = annio.getAnnio();

        Seccion sec = curso.getIdSec();

        String seccion = sec.getSeccion();

        Turno tur = curso.getIdTurno();

        String turno = tur.getTurno();

        String nivel = annio.getNivel();

        String especialidad = annio.getEspecialidad();

        //List<Notawrapper> notas = new ArrayList<>();
        //notas = notaservice.consultarNotasPorCedula(notasquery.getTipoDoc(), notasquery.getNroDoc());
        //notas = notaservice.consultarNotasPorCedula(tipoDocumento, nroDocumento);
        model.addAttribute("especialidad", especialidad);

        model.addAttribute("nombreAlumno", nombreAlumno);

        model.addAttribute("cedulaAlumno", cedulaAlumno);

        model.addAttribute("anniocursado", anniocursado);

        model.addAttribute("seccion", seccion);

        model.addAttribute("nivel", nivel);

        model.addAttribute("turno", turno);

        model.addAttribute("direccionbase", direccionbase);

        // model.addAttribute("notas", notas);
        return "notas/consultarNotas";

    }

    @GetMapping(path = "/consultarNotasDocente")
    public String consultarNotasDocente(
            @RequestParam String annio,
            @RequestParam String seccion,
            @RequestParam String materia,
            @RequestParam Long idPrf,
            @RequestParam Long idMat,
            @RequestParam Long idCurso,
            Model model) {
        
         cursoSinAlumnos = true;
         
         Responses resp = alumnoservice.consultarAlumnosPorCurso(idCurso);
         
         if (!resp.getListadeAlumnos().isEmpty()) {
            cursoSinAlumnos = false;
        }
         
         List<AlumnoDTO> alumnos=resp.getListadeAlumnos();
         
         List<Notawrapperporlapso> listadodenotas=notaservice.consultarNotasPorCursoMateria(alumnos, idMat, idCurso);
         
         model.addAttribute("listadodenotas",listadodenotas);
         
         model.addAttribute("cursoSinAlumnos",cursoSinAlumnos);

         model.addAttribute("annio",annio);

         model.addAttribute("seccion",seccion);

         model.addAttribute("materia",materia);
         
        return "notas/consultaDeNotasDocentes";
    }



}
