/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;

import com.virtualeduc.tuescuelavirtual.models.DTOS.SeccionDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.TurnoDTO;
import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.Seccion;
import com.virtualeduc.tuescuelavirtual.models.Turno;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import com.virtualeduc.tuescuelavirtual.utils.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Personal
 */
@Controller
@RequestMapping("/app")
public class alumnoController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	IAlumnoService alumnoservice;

	@Value("${dir.base}")
	String direccionbase;

	@Autowired
	IRepresentanteService representanteservice;

	@Autowired
	ICursoService cursoservice;

	Representante representante;

	boolean buscarAlumno = false;

	boolean guardar;

	boolean guardarCurso;

	boolean guardarPeriodo;

	boolean porvalidacion = false;

	
	@GetMapping(path = "/listaralumnos")
	public String listaralumnos(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			logger.info("El usuario " + auth.getName() + " ha ingresado al módulo de alumnos");
		}
                
                if (Utils.hasRole("ROLE_USER_DIRECTIVO")) {
					if(auth!=null) {
						logger.info("Hola usuario ".concat(auth.getName()).concat(" tienes acceso"));
					}
		} else {
					if(auth!=null) {
						logger.info("Hola usuario ".concat(auth.getName()).concat(" no tienes acceso"));
					}
		}



		List<AlumnoCursoDTO> listaAlumnos;
		listaAlumnos = alumnoservice.consultarAlumnos();
		model.addAttribute("Alumnos", listaAlumnos);
		return "alumnos/listaralumnos";
	}


	@GetMapping(path = "/registroalumno")
	public String registroalumno(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (Utils.hasRole("ROLE_USER_DIRECTIVO")) {
			logger.info("Hola usuario ".concat(auth.getName()).concat(" tienes acceso"));
		} else {
			logger.info("Hola usuario ".concat(auth.getName()).concat(" no tienes acceso"));
		}

		AlumnoDTO alumnoDTO = new AlumnoDTO();


		model.addAttribute("alumnoDTO", alumnoDTO);
		model.addAttribute("direccionbase", direccionbase);
		return "alumnos/registroalumno";
	}


	@GetMapping(path = "/verAlumno/{idAl}")
	public String verAlumno(@PathVariable(value = "idAl") Long idAl, Model model) {
		AlumnoDTO alumnoDTO = new AlumnoDTO(alumnoservice.consultarAlumnoPorId(idAl));

		model.addAttribute("alumnoDTO", alumnoDTO);
		model.addAttribute("direccionbase", direccionbase);
		return "alumnos/editaralumno";
	}

	@PostMapping(path = "/modificaralumno")
	public String modificaralumno(@Valid AlumnoDTO alumnoDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "alumnos/editaralumno";
		}

		// cedula no existe
		guardar = false;

		Responses resp;

		Representante rep1;

		Representante rep2;

		String tipoDocRpr;

		String numDocRpr;

		Alumno alumnoguardado = alumnoservice.consultarAlumnoPorId(alumnoDTO.getIdAl());

		Alumno alumnoActualizar = new Alumno(alumnoDTO);

		alumnoActualizar.setIdAl(alumnoguardado.getIdAl());

		if (alumnoguardado.getIdAl() != null) {
			alumnoActualizar.setFechaCreacion(alumnoguardado.getFechaCreacion());
		}

		Curso curso = new Curso();

		AnnioDTO annioDTO = cursoservice.consultarAnnioPorAnnioYnivelYespecialidad(alumnoDTO.getAnnio(), alumnoDTO.getNivel(), alumnoDTO.getEspecialidad());

		AnnioEscolarDTO annioescolarDTO = cursoservice.consultarAnnioEscolar();

		SeccionDTO seccionDTO = cursoservice.consultarSeccionPorSeccion(alumnoDTO.getSeccion());

		CursoDTO cursoDTO = cursoservice.consultarcursoporparametros(annioDTO.getIdAnnio(),
				annioescolarDTO.getIdAnnioEsc(), seccionDTO.getIdSec());

		Annio annio = new Annio(annioDTO);

		AnnioEscolar annioescolar = new AnnioEscolar(annioescolarDTO);

		Seccion seccion = new Seccion(seccionDTO);

		curso.setIdAnnio(annio);

		curso.setIdAnnioEsc(annioescolar);

		curso.setIdSec(seccion);

		curso.setIdCurso(cursoDTO.getIdCurso());

		alumnoActualizar.setIdCurso(curso);

		if (alumnoDTO.getTipoDocRep1() != null && alumnoDTO.getNumDocRep1() != null) {
			tipoDocRpr = alumnoDTO.getTipoDocRep1();

			numDocRpr = alumnoDTO.getNumDocRep1();

			rep1 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
		} else {
			rep1 = alumnoguardado.getIdRpr1();
		}

		alumnoActualizar.setIdRpr1(rep1);

		if (alumnoDTO.getTipoDocRep2() != null && alumnoDTO.getNumDocRep2() != null) {

			tipoDocRpr = alumnoDTO.getTipoDocRep2();

			numDocRpr = alumnoDTO.getNumDocRep2();



			rep2 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
		} else {
			rep2 = alumnoguardado.getIdRpr2();
		}

		alumnoActualizar.setIdRpr2(rep2);

		resp = alumnoservice.guardaAlumno(alumnoActualizar, guardar);

		if (resp.getResponseCode() == Constantes.ALUMNO_MODIFICADO_CODE) {
			redirectAttributes.addFlashAttribute("mensaje5", resp.getResponseDescription()).addFlashAttribute("clase",
					"success");

		}
		return "redirect:listaralumnos?success";

	}

	// CONSULTA DE ALUMNO POR CEDULA
	@GetMapping(path = "/consultaralumnoporcedula/{inputTipoDoc}/{inputNumeroDeCedula}", produces = "application/json")
	public String consultaralumnoporcedula(@PathVariable(value = "inputTipoDoc") String inputTipoDoc,
			@PathVariable(value = "inputNumeroDeCedula") String inputNumeroDeCedula, Model model) {

		AlumnoDTO alumnoDTO;

		Alumno alumno;

		alumno = alumnoservice.consultarAlumnoPorCedula(inputTipoDoc, inputNumeroDeCedula);

		alumnoDTO = new AlumnoDTO(alumno);

		model.addAttribute("alumnoconsultado", alumnoDTO);

		buscarAlumno = true;

		model.addAttribute("buscarAlumno", buscarAlumno);

		return "redirect:listaralumnos";
	}

	// CONSULTA DE ALUMNO POR ID
	@GetMapping(path = "/consultaralumnoporid/{idAl}", produces = "application/json")
	public String consultaralumnoporid(@PathVariable(value = "idAl") Long idAl, Model model) {

		AlumnoDTO alumnoDTO;
		Alumno alumno;
		alumno = alumnoservice.consultarAlumnoPorId(idAl);
		alumnoDTO = new AlumnoDTO(alumno);
		model.addAttribute("alumnoDTO", alumnoDTO);
		return "alumnos/verAlumno";
	}

	// REGISTRA ALUMNO Y SUS REPRESENTANTES EN EL SISTEMA
	@PostMapping(path = "/agregaralumno")
	public String registrarestudiante(@Valid AlumnoDTO alumnoDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		String tipoDocRpr;

		String numDocRpr;

		if (result.hasErrors()) {

			porvalidacion = true;
			model.addAttribute("porvalidacion", porvalidacion);
			return "alumnos/registroalumno";
		}



		if (alumnoservice.consultarAlumnoPorCedula(alumnoDTO.getTipoDocAl(), alumnoDTO.getNumDocAl()) != null) {

			redirectAttributes.addFlashAttribute("mensaje1", Constantes.ALUMNO_EXISTE_DESC).addFlashAttribute("clase",
					"danger");

			return "alumnos/registroalumno";
		}



		guardar = true;

		Responses resp;

		Alumno alumno = new Alumno(alumnoDTO);

		Curso curso = new Curso();

		AnnioDTO annioDTO = cursoservice.consultarAnnioPorAnnioYnivelYespecialidad(alumnoDTO.getAnnio(), alumnoDTO.getNivel(),alumnoDTO.getEspecialidad());

		// CONSULTA EL AÑO ESCOLAR VIGENTE Y QUE ESTE CON STATUS ACTIVO
		AnnioEscolarDTO annioescolarDTO = cursoservice.consultarAnnioEscolar();

		SeccionDTO seccionDTO = cursoservice.consultarSeccionPorSeccion(alumnoDTO.getSeccion());

		TurnoDTO turnoDTO = cursoservice.consultarTurnoPorTurno(alumnoDTO.getTurno());

		CursoDTO cursoDTO = cursoservice.consultarcursoporparametros(annioDTO.getIdAnnio(),
				annioescolarDTO.getIdAnnioEsc(), seccionDTO.getIdSec());

		Annio annio = new Annio(annioDTO);

		AnnioEscolar annioescolar = new AnnioEscolar(annioescolarDTO);

		Seccion seccion = new Seccion(seccionDTO);

		Turno turno = new Turno(turnoDTO);

		curso.setIdAnnio(annio);

		curso.setIdAnnioEsc(annioescolar);

		curso.setIdSec(seccion);

		curso.setIdTurno(turno);

		curso.setIdCurso(cursoDTO.getIdCurso());

		alumno.setIdCurso(curso);

		// CONSULTA POR EL NUMERO DE CEDULA SI EL REPRESENTANTE ESTE REGISTRADO
		// SI NO ESTA REGISTRADO LO GUARDA Y SI YA EXISTE TOMA ESE REPRESENTANTE COMO EL
		// REPRESENTANTE DEL ALUMNO QUE SE VA A REGISTRAR
		tipoDocRpr = alumnoDTO.getTipoDocRep1();
		numDocRpr = alumnoDTO.getNumDocRep1();
		Representante rep1 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
		if (rep1 == null) {
			Representante rep = new Representante();
			rep1 = rep.setRepresentante1(alumnoDTO);
			alumno.setIdRpr1(representanteservice.guardarRepresentante(rep1));
		} else {
			alumno.setIdRpr1(rep1);
		}

		if (alumnoDTO.getTipoDocRep2() != null && !alumnoDTO.getNumDocRep2().equals("")) {
			tipoDocRpr = alumnoDTO.getTipoDocRep2();
			numDocRpr = alumnoDTO.getNumDocRep2();
			Representante rep2 = representanteservice.consultarepresentanteporcedula(tipoDocRpr, numDocRpr);
			if (rep2 == null) {
				Representante rep = new Representante();
				rep2 = rep.setRepresentante2(alumnoDTO);
				alumno.setIdRpr2(representanteservice.guardarRepresentante(rep2));
			} else {
				alumno.setIdRpr2(rep2);
			}

		} else {
			alumno.setIdRpr2(rep1);
		}

		resp = alumnoservice.guardaAlumno(alumno, guardar);
		if (resp.getResponseCode() == Constantes.ALUMNO_REGISTRADO_CODE) {
			redirectAttributes.addFlashAttribute("mensaje2", resp.getResponseDescription()).addFlashAttribute("clase",
					"success");
		}
		return "redirect:listaralumnos?success";

	}

	@ModelAttribute("Cursos")
	public List<CursoDTO> poblarCursos() {
		List<CursoDTO> cursos;
		AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolar();
		cursos = cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
		return cursos;
	}

}
