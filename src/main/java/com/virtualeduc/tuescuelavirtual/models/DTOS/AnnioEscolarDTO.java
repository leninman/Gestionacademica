/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.AnnioEscolar;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Lenin
 */
public class AnnioEscolarDTO implements Serializable {
    
     private static final long serialVersionUID = 1L;
    
    private Long idAnnioEsc;
   
    private String intAnnioEsc;
    
    private Date FechaI;
    
    private Date FechaF;
    
    private String status;

    
     public AnnioEscolarDTO() {
        
    }
    
  
    
      
    public AnnioEscolarDTO(Long idAnnioEsc, String intAnnioEsc, Date fechaI, Date fechaF,
    		String status) {
		super();
		this.idAnnioEsc = idAnnioEsc;
		this.intAnnioEsc = intAnnioEsc;
		this.FechaI = fechaI;
		this.FechaF = fechaF;
		this.status=status;
	}




	public AnnioEscolarDTO(AnnioEscolar annioescolar) {
        this.idAnnioEsc = annioescolar.getIdAnnioEsc();
        this.intAnnioEsc = annioescolar.getIntAnnioEsc();
        this.FechaI=annioescolar.getFechaI();
        this.FechaF=annioescolar.getFechaF();
        this.status=annioescolar.getStatus();
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

	public Date getFechaI() {
		return FechaI;
	}

	public void setFechaI(Date fechaI) {
		FechaI = fechaI;
	}

	public Date getFechaF() {
		return FechaF;
	}

	public void setFechaF(Date fechaF) {
		FechaF = fechaF;
	}
	
	

	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
    
   
    
    
}
