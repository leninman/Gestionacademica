/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.DTOS.*;
import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.Curso;

import com.virtualeduc.tuescuelavirtual.models.CursoProf;
import com.virtualeduc.tuescuelavirtual.models.NotaPar;
import com.virtualeduc.tuescuelavirtual.models.Profesion;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IMateriaService;
import com.virtualeduc.tuescuelavirtual.services.INotasService;
import com.virtualeduc.tuescuelavirtual.services.IProfesoresService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import com.virtualeduc.tuescuelavirtual.services.IUsuarioService;
import com.virtualeduc.tuescuelavirtual.services.IVariosService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

/**
 *
 * @author Personal
 */
@RestController

//@CrossOrigin(origins = {"http://localhost:8080"})
@RequestMapping("/app")
public class coreController {

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    IProfesoresService profesorservice;

    @Autowired
    IRepresentanteService representanteservice;

    @Autowired
    IMateriaService materiaservice;

    @Autowired
    IUsuarioService usuarioservice;

    @Autowired
    INotasService notasservice;

    @Autowired
    INotasService notasService;

    @Value("${dir.base}")
    String direccionbase;

    @Autowired
    ICursoService cursoservice;

    @Autowired
    INotasService notaservice;

    Representante representante;

    Boolean guardarAlumno;

    boolean guardarCurso;

    List<AlumnoDTO> lista = new ArrayList<>();

    List<Notawrapper> notasresultado;

    //CONSULTA DE REPRESENTANTE POR CEDULA
    @CrossOrigin(origins = {"direccionbase/consultarepresentante"})
    @GetMapping(path = "/consultarepresentante",
            produces = "application/json")
    public @ResponseBody
    RepresentanteDTO consultarepresentante(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        return representanteservice.obtenerRepresentantePorCedula(tdoc, ndoc);
    }

    //CONSULTA DE ALUMNO POR CEDULA
    @CrossOrigin(origins = {"direccionbase/consultaAlumno"})
    @GetMapping(path = "/consultaAlumno",
            produces = "application/json")
    public @ResponseBody
    AlumnoDTO consultaAlumno(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        AlumnoDTO alumnoDTO;
        Alumno alumno = this.alumnoservice.consultarAlumnoPorCedula(tdoc, ndoc);
        alumnoDTO = new AlumnoDTO(alumno);
        return alumnoDTO;
    }

    //CONSULTA DE PROFESOR POR CEDULA
    @CrossOrigin(origins = {"direccionbase/buscarProfesor"})
    @GetMapping(path = "/buscarProfesor",
            produces = "application/json")
    public @ResponseBody
    ProfesorDTO consultaProfesor(@RequestParam("tdoc") String tdoc, @RequestParam("ndoc") String ndoc) {
        ProfesorDTO profesorDTO;
        Profesor profesor = this.profesorservice.consultarProfesorPorCedula(tdoc, ndoc);
        profesorDTO = new ProfesorDTO(profesor);
        return profesorDTO;
    }

//CONSULTA LA LISTA DE ALUMNOS ACTIVOS
    @CrossOrigin(origins = {"direccionbase/consultaralumnos"})
    @GetMapping(path = "/consultaralumnos",
            produces = "application/json")
    public @ResponseBody
    List<AlumnoCursoDTO> consultaralumnos() {
        return alumnoservice.consultarAlumnos();
    }

//CONSULTA LA LISTA DE CURSOS DEL PERIODO ACUAL VIGENTE QUE ESTE ACTIVO
    @CrossOrigin(origins = {"direccionbase/consultarcursosporperiodo"})
    @GetMapping(path = "/consultarcursosporperiodo",
            produces = "application/json")
    public @ResponseBody
    List<CursoDTO> consultarlistacursosporperiodo() {

        AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolar();

        return cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
    }

    //CONSULTA CURSO POR ID DEL CURSO
    @CrossOrigin(origins = {"direccionbase/consultarcursoporid"})
    @GetMapping(path = "/consultarcursoporid")
    public CursoDTO consultarcursoporid(@RequestParam(name = "idcurso") Long idcurso) {

        return cursoservice.consultarCursoPorId(idcurso);
    }

    //PARA ACTUALIZAR LOS ID DE CURSO DE LOS ALUMNOS
    @CrossOrigin(origins = {"direccionbase/actualizaridalumnos"})
    @PostMapping(path = "/actualizaridalumnos")
    public Responses actualizarIdAlumnos(@RequestParam(name = "idcurso") Long idcurso,
            @RequestParam(name = "cedulasAlumnos[]") String[] cedulasAlumnos,
            RedirectAttributes redirectAttributes) {

        Responses resp = new Responses();

        String[] cedulas = cedulasAlumnos;

        guardarAlumno = false;   //Falso porque vamos a actualizar el registro

        Curso curso = this.cursoservice.consultarCursoPorIdCurso(idcurso);

        for (int i = 0; i < cedulas.length; i++) {

            String cedula = cedulas[i];

            String tipoDoc = cedula.substring(0, 1);

            String numDoc = cedula.substring(1);

            Alumno alumnoguardado = this.alumnoservice.consultarAlumnoPorCedula(tipoDoc, numDoc);

            Alumno alumnoaguardar = new Alumno();

            alumnoaguardar = alumnoguardado;

            alumnoaguardar.setIdAl(alumnoguardado.getIdAl());

            alumnoaguardar.setIdCurso(curso);

            resp = this.alumnoservice.guardaAlumno(alumnoaguardar, guardarAlumno);

        }
        resp.setResponseCode(Constantes.CURSO_ACTUALIZADO_CODE);
        resp.setResponseDescription(Constantes.CURSO_ACTUALIZADO_DESC);
        return resp;

    }

    @CrossOrigin(origins = {"direccionbase/validarmateria"})
    @GetMapping(path = "/validarmateria")
    public Long validarmateria(@RequestParam(name = "materia") String materia,
            @RequestParam(name = "annio") String annio, @RequestParam(name = "nivel") String nivel,
            @RequestParam(name = "especialidad") String especialidad) {

        return materiaservice.consultarIdMaterias(materia, annio, nivel, especialidad);

    }

    @CrossOrigin(origins = {"direccionbase/asignarmateriasycursos"})
    @PostMapping(path = "/asignarmateriasycursos")
    public Responses asignarmateriasycursos(@RequestParam(name = "idcursos[]") Long[] idcursos,
            @RequestParam(name = "idmaterias[]") Long[] idmaterias, @RequestParam(name = "idprofesor") Long idprofesor,
            RedirectAttributes redirectAttributes) {

        Responses resp = new Responses();

        List<CursoProf> cursosprof = new ArrayList<>();

        for (int i = 0; i < idmaterias.length; i++) {

            CursoProf cursoprof = new CursoProf();

            cursoprof.setIdCurso(idcursos[i]);

            cursoprof.setIdMat(idmaterias[i]);

            cursoprof.setIdProf(idprofesor);

            cursosprof.add(cursoprof);

        }

        resp = cursoservice.asignarCursosMaterias(cursosprof);

        return resp;

    }

    @CrossOrigin(origins = {"direccionbase/guardarnotas"})
    @PostMapping(path = "/guardarnotas", consumes = "application/json", produces = "application/json")
    public @ResponseBody
    Responses guardarnotas(@RequestBody List<NotaParDTO> calificaciones,
            RedirectAttributes redirectAttributes) {

        return notasservice.guardarNotasParciales(calificaciones);

    }

    @CrossOrigin(origins = {"direccionbase/obtenerNotas"})
    @GetMapping(path = "/obtenerNotas")
    public List<Notawrapper> obtenerNotas(@RequestParam(name = "cedula") String cedula,
            String periodo, String lapso, String tipodeconsulta, Model model) {

        String tipoDoc = cedula.substring(0, 1);
        String numDoc = cedula.substring(1);
        Responses response = new Responses();
        
        notasresultado = new ArrayList<>();

        if (tipodeconsulta.equalsIgnoreCase("Parciales")) {

            notasresultado = notaservice.consultarNotasPorCedulaPeriodoYlapso(tipoDoc, numDoc, periodo, lapso);

            if (!notasresultado.isEmpty()) {
                response.setNotasWrapper(notasresultado);
                response.setResponseCode(Constantes.CONSULTA_EXITOSA_DE_NOTAS);
                response.setResponseDescription(Constantes.CONSULTA_EXITOSA_DE_NOTAS_DESC);
            }else{
                notasresultado=null;
                response.setNotasWrapper(null);
                response.setResponseCode(Constantes.PERIODO_LAPSO_SIN_REGISTROS_DE_NOTAS);
                response.setResponseDescription(Constantes.PERIODO_LAPSO_SIN_REGISTROS_DE_NOTAS_DESC);
                
            }

        }

        if (tipodeconsulta.equalsIgnoreCase("Definitivas")) {
             notasresultado=null;
        }

        return notasresultado;

    }
    @CrossOrigin(origins = {"direccionbase/actualizarNota"})
    @PostMapping(path = "/actualizarNota",produces = "application/json")
    public @ResponseBody Responses actualizarNota(@RequestParam(name="idAlumno") Long idAlumno,
                                    @RequestParam(name="idMateria") Long idMateria,
                                    @RequestParam(name="idCurso") Long idCurso,
                                    @RequestParam(name="notaLapso1", required=false) Float notaLapso1,
                                    @RequestParam(name="notaLapso2",required=false) Float notaLapso2,
                                    @RequestParam(name="notaLapso3",required=false) Float notaLapso3){
        return notaservice.actualizarNotasParciales(idAlumno,idMateria,idCurso,notaLapso1,notaLapso2,notaLapso3);

    }

    @CrossOrigin(origins = {"direccionbase/crearCurso"})
    @PostMapping(path = "/crearCurso",consumes= "application/json",produces = "application/json")
    public @ResponseBody Responses crearCurso(@Valid @RequestBody CursoDTO cursoDTO,BindingResult result){


        guardarCurso = true;
        Responses resp = new Responses();


        if (cursoservice.cursoporcurso(cursoDTO) != null) {
            resp.setResponseCode(Constantes.CURSO_EXISTE_CODE);
            resp.setResponseDescription(Constantes.CURSO_EXISTE_DESC);

        }else{
            resp = cursoservice.guardarCurso(cursoDTO, guardarCurso);
        }

        return resp;
    }

 /*   @CrossOrigin(origins = {"direccionbase/eliminarcurso"})
    @DeleteMapping(path = "/eliminarcurso/{idCurso}")
    public @ResponseBody Responses eliminarcurso(@RequestParam(value = "idCurso") Long idCurso) {

        Responses resp = new Responses();

        Long[] alumnosPorCurso = alumnoservice.consultarIdAlumnoPorIdCurso(idCurso);
        Long[] profesoresPorCurso = profesorservice.consultarProfesoresPorIdCurso(idCurso);
        Long[] notasPorCurso = notasService.consultarNotasPorIdCurso(idCurso);

        if(alumnosPorCurso.length == 0 && profesoresPorCurso.length ==0 && notasPorCurso.length == 0){
            resp = cursoservice.eliminarCurso(idCurso);
            if (resp.getResponseCode() == Constantes.CURSO_ELIMINADO_CODE) {
                redirectAttributes.addFlashAttribute("mensaje7", resp.getResponseDescription())
                        .addFlashAttribute("clase", "success");
            }
        }else{

            if (alumnosPorCurso.length != 0) {

                resp.setResponseCode(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_CODE);

                resp.setResponseDescription(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_DESC);

                redirectAttributes.addFlashAttribute("mensaje8", resp.getResponseDescription()).addFlashAttribute("clase",
                        "success");

            } else if (profesoresPorCurso.length!=0) {

                resp.setResponseCode(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_CODE_1);

                resp.setResponseDescription(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_DESC_1);

                redirectAttributes.addFlashAttribute("mensaje29", resp.getResponseDescription()).addFlashAttribute("clase",
                        "success");

            }else if(notasPorCurso.length!=0){
                resp.setResponseCode(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_CODE_2);

                resp.setResponseDescription(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_DESC_2);

                redirectAttributes.addFlashAttribute("mensaje30", resp.getResponseDescription()).addFlashAttribute("clase",
                        "success");
            }

        }
        return resp;
    }*/





}
