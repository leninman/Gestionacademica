/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Turno;
import java.io.Serializable;

/**
 *
 * @author Lenin
 */
public class TurnoDTO implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
    private Long idTurno;
  
    private String turno;
    
    
    public TurnoDTO() {
      
    }
    
    
    public TurnoDTO(Turno turno) {
      
        this.idTurno=turno.getIdTurno();
        this.turno=turno.getTurno();
    }
    
    

    public TurnoDTO(Long idTurno, String turno) {
        this.idTurno = idTurno;
        this.turno = turno;
    }

    public Long getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(Long idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
    
    
    
    
}
