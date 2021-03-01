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
  
    private String seccion;

      public SeccionDTO() {
        
    }
    
    public SeccionDTO(Long idSec, String seccion) {
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

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
      
      
      
    
    
    
    
    
}
