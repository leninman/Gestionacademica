/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;


import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
public class cursoController {

	@Autowired
	IAlumnoService alumnoservice;

	@Autowired
	IRepresentanteService representanteservice;

	@Autowired
	ICursoService cursoservice;
	
	
	Representante representante;

	boolean buscarAlumno = false;

	boolean guardar;

	boolean guardarCurso;
	
	boolean guardarPeriodo;



	

	@GetMapping(path = "/listarcursos")
	public String listarcursos(Model model) {
		List<CursoDTO> listacursos = new ArrayList<>();
		AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolar();
		listacursos = cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
		model.addAttribute("Cursos", listacursos);
		return "cursos/listacursos";
	}

	@GetMapping(path = "/nuevocurso")
	public String nuevocurso(Model model) {
		CursoDTO cursoDTO = new CursoDTO();
		model.addAttribute("annioescolar", cursoservice.consultarAnnioEscolar());
		model.addAttribute("annios", cursoservice.consultarannios());
		model.addAttribute("secciones", cursoservice.consultarsecciones());
		model.addAttribute("turnos", cursoservice.consultarturnos());
		model.addAttribute("cursoDTO", cursoDTO);
		return "cursos/crearcurso";
	}

	@PostMapping(path = "/agregarcurso")
	public String registrarcurso(@Valid CursoDTO cursoDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		guardarCurso = true;

		Responses resp = new Responses();

		if (cursoservice.cursoporcurso(cursoDTO) != null) {

			redirectAttributes.addFlashAttribute("mensaje4", Constantes.CURSO_EXISTE_DESC).addFlashAttribute("clase",
					"danger");

			return "redirect:nuevocurso";
		}

		resp = cursoservice.guardarCurso(cursoDTO, guardarCurso);

		if (resp.getResponseCode() == Constantes.CURSO_REGISTRADO_CODE) {
			redirectAttributes.addFlashAttribute("mensaje3", Constantes.CURSO_REGISTRADO_DESC)
					.addFlashAttribute("clase", "success");
		}

		return "redirect:listarcursos?success";
	}

	@GetMapping(path = "/eliminacurso/{idCurso}")
	public String eliminacurso(@PathVariable(value = "idCurso") Long idCurso, Model model,
			RedirectAttributes redirectAttributes) {

		Responses resp = new Responses();

		if (alumnoservice.consultarIdAlumnoPorIdCurso(idCurso).length != 0) {

			resp.setResponseCode(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_CODE);

			resp.setResponseDescription(Constantes.CURSO_IMPOSIBLE_DE_ELIMINAR_DESC);

			redirectAttributes.addFlashAttribute("mensaje8", resp.getResponseDescription()).addFlashAttribute("clase",
					"success");

		} else {

			resp = cursoservice.eliminarCurso(idCurso);

			if (resp.getResponseCode() == Constantes.CURSO_ELIMINADO_CODE) {
				redirectAttributes.addFlashAttribute("mensaje7", resp.getResponseDescription())
						.addFlashAttribute("clase", "success");
			}
		}
		return "redirect:/app/listarcursos";
	}

	@GetMapping(path = "/editacurso/{idCurso}")
	public String editacurso(@PathVariable(value = "idCurso") Long idCurso, Model model) {

		CursoDTO cursoDTO = cursoservice.consultarCursoPorId(idCurso);
		model.addAttribute("annioescolar", cursoservice.consultarAnnioEscolar());
		// model.addAttribute("annios",cursoservice.consultarannios());
		model.addAttribute("secciones", cursoservice.consultarsecciones());
		model.addAttribute("turnos", cursoservice.consultarturnos());
		model.addAttribute("cursoDTO", cursoDTO);

		return "cursos/editacurso";
	}
	
	@GetMapping(path = "/vercurso/{idCurso}")
	public String vercurso(@PathVariable(value = "idCurso") Long idCurso, Model model,
			RedirectAttributes redirectAttributes) {

		Responses resp=new Responses();
		
		resp=alumnoservice.consultarAlumnosPorCurso(idCurso);
		
		if(resp.getResponseCode()==Constantes.CURSO_SIN_INSCRITOS_CODE) {
			redirectAttributes.addFlashAttribute("mensaje11", resp.getResponseDescription())
			.addFlashAttribute("clase", "danger");
		}else {
			
			CursoDTO cursoDTO = cursoservice.consultarCursoPorId(idCurso);
			model.addAttribute("Alumnosinscritos",resp.getListadeAlumnos());
			model.addAttribute("cursoDTO", cursoDTO);
		}
		
		

		return "cursos/vercurso";
	}

	@PostMapping(path = "/modificarcurso")
	public String modificarcurso(CursoDTO cursoDTO, RedirectAttributes redirectAttributes) {

		Responses resp = new Responses();

		if (alumnoservice.consultarIdAlumnoPorIdCurso(cursoDTO.getIdCurso()).length != 0) {
			resp.setResponseCode(Constantes.CURSO_IMPOSIBLE_DE_MODIFICAR_CODE);

			resp.setResponseDescription(Constantes.CURSO_IMPOSIBLE_DE_MODIFICAR_DESC);

			redirectAttributes.addFlashAttribute("mensaje9", resp.getResponseDescription()).addFlashAttribute("clase",
					"success");
		} else {

			if (cursoservice.cursoporcurso(cursoDTO) != null) {

				redirectAttributes.addFlashAttribute("mensaje4", Constantes.CURSO_EXISTE_DESC)
						.addFlashAttribute("clase", "danger");

				// return "redirect:nuevocurso";
			} else {
				guardarCurso = false;

				resp = cursoservice.guardarCurso(cursoDTO, guardarCurso);

				if (resp.getResponseCode() == Constantes.CURSO_MODIFICADO_CODE) {
					redirectAttributes.addFlashAttribute("mensaje6", resp.getResponseDescription())
							.addFlashAttribute("clase", "success");
				}
			}
		}
		return "redirect:listarcursos?success";
	}
	
	@GetMapping(path = "cargarcurso")
	public String cargarcurso(Model model) {

		List<CursoDTO> cursos = new ArrayList<>();
		AnnioEscolarDTO annioEscolar = cursoservice.consultarAnnioEscolar();
		cursos = cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
		model.addAttribute("Cursos", cursos);
		return "cursos/cargarcurso";
	}


}