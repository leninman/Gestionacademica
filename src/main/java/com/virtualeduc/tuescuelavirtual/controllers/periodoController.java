/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;


import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;
import com.virtualeduc.tuescuelavirtual.utils.Utils;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Personal
 */
@Controller
@RequestMapping("/app")
public class periodoController {

	@Autowired
	IAlumnoService alumnoservice;

	@Autowired
	IRepresentanteService representanteservice;

	@Autowired
	ICursoService cursoservice;
	
	 @Value("${dir.base}")
	 String direccionbase;
	
	
	Representante representante;

	boolean buscarAlumno = false;

	boolean guardar;

	boolean guardarCurso;
	
	boolean guardarPeriodo;

		
	@GetMapping("/periodosescolares")
	public String periodos(Model model) {
		
		model.addAttribute("Periodos",cursoservice.consultarPeriodos());
		
		return "periodos/listaperiodos";
	}
	
	@GetMapping("/nuevoperiodo")
	public String nuevoperiodo(Model model){
		
		AnnioEscolarDTO annioescolarDTO=new AnnioEscolarDTO();
		
		model.addAttribute("annioescolarDTO",annioescolarDTO);
		
		return "periodos/crearperiodo";
	}
	
	@PostMapping("/guardarperiodo")
	public String guardarperiodo(@Valid AnnioEscolarDTO annioescolarDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		this.guardarPeriodo=true;
		
		Responses resp=new Responses();
		
		annioescolarDTO.setIntAnnioEsc(Utils.extraePeriodoEscolar(annioescolarDTO.getFechaI(), annioescolarDTO.getFechaF()));
		
		annioescolarDTO.setStatus("A");
		
		resp=cursoservice.guardarPeriodo(annioescolarDTO, guardarPeriodo);
		
		if(resp.getResponseCode()==Constantes.ANNIO_ESCOLAR_REGISTRADO_CODE) {
			redirectAttributes.addFlashAttribute("mensaje10", resp.getResponseDescription()).addFlashAttribute("clase",
					"success");
		}
		
		return "redirect:periodosescolares?success";
	}

	 

}
