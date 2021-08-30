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
import com.virtualeduc.tuescuelavirtual.models.DTOS.RepresentanteDTO;
import com.virtualeduc.tuescuelavirtual.models.Alumno;
import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Representante;
import com.virtualeduc.tuescuelavirtual.models.Responses;
import com.virtualeduc.tuescuelavirtual.services.IAlumnoService;
import com.virtualeduc.tuescuelavirtual.services.ICursoService;
import com.virtualeduc.tuescuelavirtual.services.IRepresentanteService;
import com.virtualeduc.tuescuelavirtual.utils.Constantes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/app")
//@CrossOrigin(origins = {"http://localhost:8080"})
public class coreController {

    @Autowired
    IAlumnoService alumnoservice;

    @Autowired
    IRepresentanteService representanteservice;
    
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
    public void actualizarIdAlumnos(@RequestParam(name="idcurso") Long idcurso,
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
        
        
        if (resp.getResponseCode()==Constantes.CURSO_ACTUALIZADO_CODE) {
			redirectAttributes.addFlashAttribute("mensaje12", resp.getResponseDescription()).addFlashAttribute("clase",
					"success");
		}
        
     

        
    }
     
     
     

//CONSULTA DE ALUMNO POR CEDULA
    /* @GetMapping(path = "/consultaralumno",
            produces = "application/json")
     public @ResponseBody AlumnoDTO consultaralumno(@RequestParam("tdoc") String tdoc,@RequestParam("ndoc") String ndoc){
         
    	 AlumnoDTO alumnoDTO;
         
         Alumno alumno=new Alumno();
    	 
         alumno= alumnoservice.consultarAlumnoPorCedula(tdoc, ndoc);
         
         alumnoDTO=new AlumnoDTO(alumno);
         
         return alumnoDTO;
     }*/
    
//REGISTRA ALUMNO Y SUS REPRESENTANTES EN EL SISTEMA  
    /*@PostMapping(path = "/registraralumno",consumes = "application/json", produces = "application/json")
    public @ResponseBody Responses registraralumno(@RequestBody AlumnoDTO alumnoDTO,Model model) {

        String tipoDocRpr;

        String numDocRpr;
        
        model.addAttribute("alumnoDTO", new AlumnoDTO());
                  
        Responses resp = new Responses();
        
        Alumno alumno = new Alumno(alumnoDTO);

        Curso curso = new Curso();

        AnnioDTO annioDTO = cursoservice.consultarAnnioPorAnnio(alumnoDTO.getAnnio());

        AnnioEscolarDTO annioescolarDTO = cursoservice.consultarAnnioEscolarPorAnnioEscolar();

        SeccionDTO seccionDTO = cursoservice.consultarSeccionPorSeccion(alumnoDTO.getSeccion());

        CursoDTO cursoDTO = cursoservice.consultarcursoporparametros(annioDTO.getIdAnnio(), annioescolarDTO.getIdAnnioEsc(), seccionDTO.getIdSec());

        Annio annio = new Annio(annioDTO);

        AnnioEscolar annioescolar = new AnnioEscolar(annioescolarDTO);

        Seccion seccion = new Seccion(seccionDTO);

        curso.setIdAnnio(annio);

        curso.setIdAnnioEsc(annioescolar);

        curso.setIdSec(seccion);

        curso.setIdCurso(cursoDTO.getIdCurso());

        alumno.setIdCurso(curso);

        //CONSULTA POR EL NUMERO DE CEDULA SI EL REPRESENTANTE ESTE REGISTRADO
        //SI NO ESTA REGISTRADO LO GUARDA Y SI YA EXISTE TOMA ESE REPRESENTANTE COMO EL
        //REPRESENTANTE DEL ALUMNO QUE SE VA A REGISTRAR
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

        if (alumnoDTO.getTipoDocRep2() != null && alumnoDTO.getNumDocRep2() != null) {
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

        }else {
        	alumno.setIdRpr2(rep1);
        }

        resp=alumnoservice.guardaAlumno(alumno);
        
        return resp;

    }*/
   
}