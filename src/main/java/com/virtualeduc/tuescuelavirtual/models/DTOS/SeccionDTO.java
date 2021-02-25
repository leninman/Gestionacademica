/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Seccion;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class SeccionDTO implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
    private Long idSec;
  
    private Character seccion;

      public SeccionDTO() {
        
    }
    
    public SeccionDTO(Long idSec, Character seccion) {
        this.idSec = idSec;
        this.seccion = seccion;
    }
    
    
    
      public SeccionDTO(Seccion seccion) {
        this.idSec = seccion.getIdSec();
        this.seccion = seccion.getSeccion();
    }

    public Long getIdSec() {
        return idSec;
    }

    public void setIdSec(Long idSec) {
        this.idSec = idSec;
    }

    public Character getSeccion() {
        return seccion;
    }

    public void setSeccion(Character seccion) {
        this.seccion = seccion;
    }
      
      
      
    
    
    
    
    
}
