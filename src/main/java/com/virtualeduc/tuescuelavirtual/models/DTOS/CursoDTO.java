/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import com.virtualeduc.tuescuelavirtual.models.Curso;
import com.virtualeduc.tuescuelavirtual.models.Seccion;

/**
 *
 * @author Lenin
 */
public class CursoDTO {
    
    private Long idCurso;
    
    private Long idAnnio;
    
    private Long idSec;
    
    private Long idAnnioEsc;
    
    private Long idTurno;
    
    
    
    private String annio;
    
    private String intAnnioEsc;
    
    private String seccion;
    
    private String turno;
    
    private String nivel;
    
    private String especialidad;
    
   
    
   
     public CursoDTO() {
        
    }

    public CursoDTO(Long idCurso, Long idAnnio, Long idSec, Long idAnnioEsc, Long idTurno, String annio, String intAnnioEsc, String seccion, String turno, String nivel, String especialidad) {
        this.idCurso = idCurso;
        this.idAnnio = idAnnio;
        this.idSec = idSec;
        this.idAnnioEsc = idAnnioEsc;
        this.idTurno = idTurno;
        this.annio = annio;
        this.intAnnioEsc = intAnnioEsc;
        this.seccion = seccion;
        this.turno = turno;
        this.nivel = nivel;
        this.especialidad = especialidad;
    }

   
     
     

  

    
  
    
   
    
    
    public CursoDTO(Curso curso,String annio,String annioesco,String sec,String turn) {
        
        this.idCurso=curso.getIdCurso();
        this.idAnnio=curso.getIdAnnio().getIdAnnio();
         this.idSec = curso.getIdSec().getIdSec();
         this.idAnnioEsc=curso.getIdAnnioEsc().getIdAnnioEsc();
         this.nivel=curso.getIdAnnio().getNivel();
         this.especialidad=curso.getIdAnnio().getEspecialidad();
         this.idTurno=curso.getIdTurno().getIdTurno();
         this.annio=annio;
         this.intAnnioEsc=annioesco;
         this.seccion=sec;
         this.turno=turn;
         
        
    }
    
    
    

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdAnnio() {
        return idAnnio;
    }

    public void setIdAnnio(Long idAnnio) {
        this.idAnnio = idAnnio;
    }

    public Long getIdSec() {
        return idSec;
    }

    public void setIdSec(Long idSec) {
        this.idSec = idSec;
    }

    public Long getIdAnnioEsc() {
        return idAnnioEsc;
    }

    public void setIdAnnioEsc(Long idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }
    
    

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
    }

    public String getIntAnnioEsc() {
        return intAnnioEsc;
    }

    public void setIntAnnioEsc(String intAnnioEsc) {
        this.intAnnioEsc = intAnnioEsc;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
