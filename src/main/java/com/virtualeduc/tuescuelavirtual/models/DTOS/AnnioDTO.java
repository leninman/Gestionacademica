/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Annio;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class AnnioDTO implements Serializable{
    
     private static final long serialVersionUID = 1L;
  
    private Long idAnnio;
  
    private String annio;
    
    private String nivel;
   
    private String especialidad;

    public AnnioDTO() {
       
    }
    
    public AnnioDTO(Long idAnnio, String annio, String nivel, String especialidad) {
        this.idAnnio = idAnnio;
        this.annio = annio;
        this.nivel = nivel;
        this.especialidad = especialidad;
    }
    
    
    
        public AnnioDTO(Annio annio) {
        this.idAnnio = annio.getIdAnnio();
        this.annio = annio.getAnnio();
        this.nivel = annio.getNivel();
        this.especialidad = annio.getEspecialidad();
    }

    public Long getIdAnnio() {
        return idAnnio;
    }

    public void setIdAnnio(Long idAnnio) {
        this.idAnnio = idAnnio;
    }

    public String getAnnio() {
        return annio;
    }

    public void setAnnio(String annio) {
        this.annio = annio;
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
