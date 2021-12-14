/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.controllers;



import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoCursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.AnnioEscolarDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.CursoDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.PersonaDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.ProfesorDTO;
import com.virtualeduc.tuescuelavirtual.models.DTOS.RepresentanteDTO;
import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.Curso;

import com.virtualeduc.tuescuelavirtual.models.Cursos_prof;
import com.virtualeduc.tuescuelavirtual.models.Profesion;
import com.virtualeduc.tuescuelavirtual.models.Profesor;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IMateriaService;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
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
  
    
    @Value("${dir.base}")
    String direccionbase;

    @Autowired
    ICursoService cursoservice;

    Representante representante;
    
    Boolean guardarAlumno;

    
  //CONSULTA DE REPRESENTANTE POR CEDULA
    @CrossOrigin(origins = {"direccionbase/consultarepresentante"})
     @GetMapping(path = "/consultarepresentante",
            produces = "application/json")
     public @ResponseBody RepresentanteDTO consultarepresentante(@RequestParam("tdoc") String tdoc,@RequestParam("ndoc") String ndoc){
            return representanteservice.obtenerRepresentantePorCedula(tdoc, ndoc);
     }
     
     
     //CONSULTA DE ALUMNO POR CEDULA
    @CrossOrigin(origins = {"direccionbase/consultaAlumno"})
     @GetMapping(path = "/consultaAlumno",
            produces = "application/json")
     public @ResponseBody AlumnoDTO consultaAlumno(@RequestParam("tdoc") String tdoc,@RequestParam("ndoc") String ndoc){
         AlumnoDTO alumnoDTO;
         Alumno alumno=this.alumnoservice.consultarAlumnoPorCedula(tdoc, ndoc);
         alumnoDTO=new AlumnoDTO(alumno);
    	 return alumnoDTO;
     }
    
    
    
    //CONSULTA DE PROFESOR POR CEDULA
    @CrossOrigin(origins = {"direccionbase/buscarProfesor"})
     @GetMapping(path = "/buscarProfesor",
            produces = "application/json")
     public @ResponseBody ProfesorDTO consultaProfesor(@RequestParam("tdoc") String tdoc,@RequestParam("ndoc") String ndoc){
         ProfesorDTO profesorDTO;
         Profesor profesor=this.profesorservice.consultarProfesorPorCedula(tdoc, ndoc);
         profesorDTO=new ProfesorDTO(profesor);
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
        
        AnnioEscolarDTO annioEscolar=cursoservice.consultarAnnioEscolar();
        
        return cursoservice.consultarcursosporperiodo(annioEscolar.getIdAnnioEsc());
    }
     
 
   //CONSULTA CURSO POR ID DEL CURSO
     @CrossOrigin(origins = {"direccionbase/consultarcursoporid"})
     @GetMapping(path = "/consultarcursoporid")
    public CursoDTO consultarcursoporid(@RequestParam(name="idcurso") Long idcurso) {
         
        return cursoservice.consultarCursoPorId(idcurso);
    }
 
     //PARA ACTUALIZAR LOS ID DE CURSO DE LOS ALUMNOS
     @CrossOrigin(origins = {"direccionbase/actualizaridalumnos"})
     @PostMapping(path = "/actualizaridalumnos")
    public Responses actualizarIdAlumnos(@RequestParam(name="idcurso") Long idcurso,
    		@RequestParam(name="cedulasAlumnos[]") String[] cedulasAlumnos,
    		RedirectAttributes redirectAttributes) {
    	 
        Responses resp=new Responses();
        
        String[] cedulas=cedulasAlumnos;
        
        guardarAlumno=false;   //Falso porque vamos a actualizar el registro
        
      
        Curso curso=this.cursoservice.consultarCursoPorIdCurso(idcurso);
        
        
        
        for(int i=0;i<cedulas.length;i++) {
        	
        	String cedula=cedulas[i];
        	
        	String tipoDoc=cedula.substring(0,1);
        	
        	String numDoc=cedula.substring(1);
        	
        	Alumno alumnoguardado=this.alumnoservice.consultarAlumnoPorCedula(tipoDoc, numDoc);
        	
        	Alumno alumnoaguardar=new Alumno();
        	
        	alumnoaguardar=alumnoguardado;
        	
        	alumnoaguardar.setIdAl(alumnoguardado.getIdAl());
        	
        	alumnoaguardar.setIdCurso(curso);
        	
        	resp=this.alumnoservice.guardaAlumno(alumnoaguardar, guardarAlumno);
        	
        }
        resp.setResponseCode(Constantes.CURSO_ACTUALIZADO_CODE);
        resp.setResponseDescription(Constantes.CURSO_ACTUALIZADO_DESC);
        return resp;
         
    }
     
     @CrossOrigin(origins = {"direccionbase/validarmateria"})
     @GetMapping(path = "/validarmateria")
    public Long validarmateria(@RequestParam(name="materia") String materia,
    		@RequestParam(name="annio") String annio,@RequestParam(name="nivel") String nivel,
    		@RequestParam(name="especialidad") String especialidad) {
    	
    		 return materiaservice.consultarIdMaterias(materia, annio, nivel, especialidad);  
    	 
    		 
    	
    	
     }
     
   
 	@CrossOrigin(origins = { "direccionbase/asignarmateriasycursos" })
 	@PostMapping(path = "/asignarmateriasycursos")
 	public Responses asignarmateriasycursos(@RequestParam(name = "idcursos[]") Long[] idcursos,
 			@RequestParam(name = "idmaterias[]") Long[] idmaterias, @RequestParam(name = "idprofesor") Long idprofesor,
 			RedirectAttributes redirectAttributes) {

 		Responses resp = new Responses();

 		List<Cursos_prof> cursosprof = new ArrayList<>();

 		for (int i = 0; i < idmaterias.length; i++) {

 			Cursos_prof cursoprof = new Cursos_prof();

 			cursoprof.setIdCurso(idcursos[i]);

 			cursoprof.setIdMat(idmaterias[i]);

 			cursoprof.setIdProf(idprofesor);

 			cursosprof.add(cursoprof);

 		}

 		resp = cursoservice.asignarCursosMaterias(cursosprof);
 		
 		return resp;

 	}
 	/*
 	  @CrossOrigin(origins = {"direccionbase/consultarpersona"})
      @GetMapping(path = "/consultarpersona")
 	  public PersonaDTO consultarpersona(@RequestParam(name="tipodoc") String tipodoc,@RequestParam(name="numdoc") String numdoc,@RequestParam(name="tipousuario") String tipousuario) {
 		  
 		  PersonaDTO persona=new PersonaDTO();
 		  
 		  persona=usuarioservice.findPersonaByCedulaAndTipoUsuario(tipodoc, numdoc, tipousuario);
 		    
 		  return persona;
 	  }
 	
 	*/
 	
 	
    
     
     
     
  
    
     
}