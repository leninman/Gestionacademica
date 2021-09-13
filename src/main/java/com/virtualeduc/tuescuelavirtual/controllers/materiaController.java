package com.virtualeduc.tuescuelavirtual.controllers;

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

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.Materia;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IMateriaService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

@Controller
@RequestMapping("/app")
public class materiaController {
	
	@Autowired
	IMateriaService materiaservice;
	
	@Autowired
	ICursoService cursoservice;
	
	
	boolean guardar;
	
	@GetMapping(path = "/listarmaterias")
	public String listarcursos(Model model) {
		List<MateriaDTO> listamaterias = new ArrayList<>();
		listamaterias = materiaservice.listaMaterias();
		model.addAttribute("materias", listamaterias);
		return "materias/listamaterias";
	}
	
	
	@GetMapping(path = "/nuevamateria")
	public String nuevocurso(Model model) {
		MateriaDTO materiaDTO = new MateriaDTO();
		model.addAttribute("materiaDTO", materiaDTO);
		model.addAttribute("crear",true);
		return "materias/crearmateria";
	}
	
	@PostMapping(path = "/agregarmateria")
	public String registrarmateria(@Valid MateriaDTO materiaDTO, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {
		
		guardar=true;
		
		Responses resp=new Responses();
		
		String annio=materiaDTO.getAnnio();
		
		String nivel=materiaDTO.getNivel();
		
		String especialidad=materiaDTO.getEspecialidad();
		
		AnnioDTO annioDTO=cursoservice.consultarAnnioPorAnnioYnivelYespecialidad(annio, nivel, especialidad);
		
		Annio annioAguardar=new Annio(annioDTO);
		
		Materia materiaAguardar=new Materia(materiaDTO);
		
		materiaAguardar.setAnnio(annioAguardar);
		
		materiaAguardar.setStatus("A");
		
		resp=materiaservice.guardarMateria(materiaAguardar, guardar);
		
		if(resp.getResponseCode()==Constantes.MATERIA_REGISTRADA_CODE) {
			redirectAttributes.addFlashAttribute("mensaje13", Constantes.MATERIA_REGSTRADA_DESC)
			.addFlashAttribute("clase", "success");
		}
		
		
		
		return "redirect:listarmaterias?success";
	}
	
	
	@GetMapping(path = "/editarmateria/{idMat}")
	public String editarmateria(@PathVariable(value = "idMat") Long idMat, Model model) {
		
		MateriaDTO materiaDTO = materiaservice.consultarMateriaPorId(idMat);
		
		model.addAttribute("crear",false);
		
		model.addAttribute("materiaDTO",materiaDTO);
		
		return "materias/crearmateria";
	}
	
	@PostMapping(path = "/modificarmateria")
	public String modificarmateria(MateriaDTO materiaDTO, RedirectAttributes redirectAttributes) {
		
		guardar=false;
		
		Responses resp = new Responses();
		
		Long idMateria=materiaDTO.getIdMat();
		
		AnnioDTO annioDTO=cursoservice.consultarAnnioPorAnnioYnivelYespecialidad(materiaDTO.getAnnio(), materiaDTO.getNivel(), materiaDTO.getEspecialidad());
		
		Annio annio=new Annio(annioDTO);
		
		Materia materiaAguardar=new Materia(materiaDTO);
		
		materiaAguardar.setIdMat(idMateria);
		
		materiaAguardar.setAnnio(annio);
				
		resp=materiaservice.guardarMateria(materiaAguardar, guardar);
		
		
		if(resp.getResponseCode()==Constantes.MATERIA_MODIFICADA_CODE) {
			redirectAttributes.addFlashAttribute("mensaje15", Constantes.MATERIA_MODIFICADA_DESC)
			.addFlashAttribute("clase", "success");
		}
		
		
		
		return "redirect:listarmaterias?success";
		
	}
	
	@GetMapping(path = "/desactivarmateria/{idMat}")
	public String desactivarmateria(@PathVariable(value="idMat") Long idMat, RedirectAttributes redirectAttributes) {
		
		Responses resp=new Responses();
		
	
		resp=materiaservice.desactivarMateria(idMat);
		
		if(resp.getResponseCode()==Constantes.MATERIA_DESACTIVADA_CODE) {
			redirectAttributes.addFlashAttribute("mensaje16", Constantes.MATERIA_DESACTIVADA_DESC)
			.addFlashAttribute("clase", "success");
		}
		
		return "redirect:/app/listarmaterias?success";
	}

}
