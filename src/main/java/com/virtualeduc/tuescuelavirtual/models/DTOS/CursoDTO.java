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
    
   
    
   
     public CursoDTO() {
        
    }

    public CursoDTO(Long idCurso, Long idAnnio, Long idSec, Long idAnnioEsc) {
        this.idCurso = idCurso;
        this.idAnnio = idAnnio;
        this.idSec = idSec;
        this.idAnnioEsc = idAnnioEsc;
    }

  
    
   
    
    
    public CursoDTO(Curso curso) {
        
        this.idCurso=curso.getIdCurso();
        this.idAnnio=curso.getIdAnnio().getIdAnnio();
         this.idSec = curso.getIdSec().getIdSec();
         this.idAnnioEsc=curso.getIdAnnioEsc().getIdAnnioEsc();
         
        
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

  
    
    
    
    
    
}
