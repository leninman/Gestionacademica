/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class AnnioEscolarDTO implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
    private Long idAnnioEsc;
   
    private String intAnnioEsc;

    
     public AnnioEscolarDTO() {
        
    }
    
    public AnnioEscolarDTO(Long idAnnioEsc, String intAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
        this.intAnnioEsc = intAnnioEsc;
    }
    
    
      
    public AnnioEscolarDTO(AnnioEscolar annioescolar) {
        this.idAnnioEsc = annioescolar.getIdAnnioEsc();
        this.intAnnioEsc = annioescolar.getIntAnnioEsc();
    }

    public Long getIdAnnioEsc() {
        return idAnnioEsc;
    }

    public void setIdAnnioEsc(Long idAnnioEsc) {
        this.idAnnioEsc = idAnnioEsc;
    }

    public String getIntAnnioEsc() {
        return intAnnioEsc;
    }

    public void setIntAnnioEsc(String intAnnioEsc) {
        this.intAnnioEsc = intAnnioEsc;
    }
    
    
    
   
    
    
}
