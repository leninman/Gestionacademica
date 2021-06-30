/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Representante;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lenin
 */
public class RepresentanteDTO implements Serializable{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long idRpr;
    
   
    private String tipoDocRpr;
    
  
    private String numDocRpr;
    
   
    private String primNombRpr;
    
   
    private String segNombRpr;
    
    
    private String primApellRpr;
    
 
    private String segApellRpr;
    
   
    private String sexoRpr;
    
  
    private Date fechNacRpr;
    
  
    private String edadRpr;
    
   
    private String edoCivRpr;
    
  
    private String parentescoRpr;
    
   
    //private String dirPpalRpr;
    
    private String textoDirPpalRpr;
    
    private String estadodirppalrep;
    
    private String municipiodirppalrep;
    
    private String ciudaddirppalrep;
    
    private String parroquiadirppalrep;
    
    private String codpostaldirppalrep;
    
   
   // private String dirSecRpr;
    
    private String textoDirSecRpr;
    
    private String estadodirsecrep;
    
    private String municipiodirsecrep;
    
    private String ciudaddirsecrep;
    
    private String parroquiadirsecrep;
    
    private String codpostaldirsecrep;
    
    private String codoperadorappalrep;
    
    private String textoTlfPpalRpr;
    
    private String codoperadorasecrep;
    
    private String textoTlfSecRpr;
        
    private String emailRpr;
    
     public RepresentanteDTO(){
     }
     
      public RepresentanteDTO(Long idRpr) {
        this.idRpr = idRpr;
    }
     
       public RepresentanteDTO(Representante representante){
    	   
        String strDirPpalRpr=representante.getDirPpalRpr();
   		String[] arrOfStrDirPpalRpr=strDirPpalRpr.split(",");
   		
   		String strDirSecRpr=representante.getDirSecRpr();
   		String[] arrOfStrDirSecRpr=strDirSecRpr.split(",");
   		
   		String strTlfPpalRpr=representante.getTlfPpalRpr();
   		String[] arrOfStrTlfPpalRpr=strTlfPpalRpr.split("-");
   		
   		String strTlfSecRpr=representante.getTlfSecRpr();
   		String[] arrOfStrTlfSecRpr=strTlfSecRpr.split("-");   
    	   
    	   
    	   
        this.idRpr=representante.getIdRpr();
        this.tipoDocRpr = representante.getTipoDocRpr();
        this.numDocRpr = representante.getNumDocRpr();
        this.primNombRpr = representante.getPrimNombRpr();
        this.segNombRpr = representante.getSegNombRpr();
        this.primApellRpr = representante.getPrimApellRpr();
        this.segApellRpr = representante.getSegApellRpr();
        this.sexoRpr = representante.getSexoRpr();
        this.fechNacRpr = representante.getFechNacRpr();
        this.edadRpr = representante.getEdadRpr();
        this.edoCivRpr = representante.getEdoCivRpr();
        this.parentescoRpr = representante.getParentescoRpr();
        
        this.textoDirPpalRpr=arrOfStrDirPpalRpr[0];
        this.estadodirppalrep=arrOfStrDirPpalRpr[1];
        this.municipiodirppalrep=arrOfStrDirPpalRpr[2];
        this.ciudaddirppalrep=arrOfStrDirPpalRpr[3];
        this.parroquiadirppalrep=arrOfStrDirPpalRpr[4];
        this.codpostaldirppalrep=arrOfStrDirPpalRpr[5];
        
        this.textoDirSecRpr=arrOfStrDirSecRpr[0];
        this.estadodirsecrep=arrOfStrDirSecRpr[1];
        this.municipiodirsecrep=arrOfStrDirSecRpr[2];
        this.ciudaddirsecrep=arrOfStrDirSecRpr[3];
        this.parroquiadirsecrep=arrOfStrDirSecRpr[4];
        this.codpostaldirsecrep=arrOfStrDirSecRpr[5];
        
        
        this.codoperadorappalrep=arrOfStrTlfPpalRpr[0];
        this.textoTlfPpalRpr=arrOfStrTlfPpalRpr[1];
       
        this.codoperadorasecrep=arrOfStrTlfSecRpr[0];
        this.textoTlfSecRpr=arrOfStrTlfSecRpr[1];
       
        this.emailRpr = representante.getEmailRpr();
        
        
        
        //this.dirPpalRpr = representante.getDirPpalRpr();
        //this.dirSecRpr = representante.getDirSecRpr();
        //this.tlfPpalRpr = representante.getTlfPpalRpr();
       // this.tlfSecRpr = representante.getTlfSecRpr();
        
        
        
        
       
       }



	public RepresentanteDTO(Long idRpr, String tipoDocRpr, String numDocRpr, String primNombRpr, String segNombRpr,
			String primApellRpr, String segApellRpr, String sexoRpr, Date fechNacRpr, String edadRpr, String edoCivRpr,
			String parentescoRpr, String textoDirPpalRpr, String estadodirppalrep, String municipiodirppalrep,
			String ciudaddirppalrep, String parroquiadirppalrep, String codpostaldirppalrep, String textoDirSecRpr,
			String estadodirsecrep, String municipiodirsecrep, String ciudaddirsecrep, String parroquiadirsecrep,
			String codpostaldirsecrep, String codoperadorappalrep, String textoTlfPpalRpr, String codoperadorasecrep,
			String textoTlfSecRpr, String emailRpr) {
		super();
		this.idRpr = idRpr;
		this.tipoDocRpr = tipoDocRpr;
		this.numDocRpr = numDocRpr;
		this.primNombRpr = primNombRpr;
		this.segNombRpr = segNombRpr;
		this.primApellRpr = primApellRpr;
		this.segApellRpr = segApellRpr;
		this.sexoRpr = sexoRpr;
		this.fechNacRpr = fechNacRpr;
		this.edadRpr = edadRpr;
		this.edoCivRpr = edoCivRpr;
		this.parentescoRpr = parentescoRpr;
		this.textoDirPpalRpr = textoDirPpalRpr;
		this.estadodirppalrep = estadodirppalrep;
		this.municipiodirppalrep = municipiodirppalrep;
		this.ciudaddirppalrep = ciudaddirppalrep;
		this.parroquiadirppalrep = parroquiadirppalrep;
		this.codpostaldirppalrep = codpostaldirppalrep;
		this.textoDirSecRpr = textoDirSecRpr;
		this.estadodirsecrep = estadodirsecrep;
		this.municipiodirsecrep = municipiodirsecrep;
		this.ciudaddirsecrep = ciudaddirsecrep;
		this.parroquiadirsecrep = parroquiadirsecrep;
		this.codpostaldirsecrep = codpostaldirsecrep;
		this.codoperadorappalrep = codoperadorappalrep;
		this.textoTlfPpalRpr = textoTlfPpalRpr;
		this.codoperadorasecrep = codoperadorasecrep;
		this.textoTlfSecRpr = textoTlfSecRpr;
		this.emailRpr = emailRpr;
	}

	public Long getIdRpr() {
		return idRpr;
	}

	public void setIdRpr(Long idRpr) {
		this.idRpr = idRpr;
	}

	public String getTipoDocRpr() {
		return tipoDocRpr;
	}

	public void setTipoDocRpr(String tipoDocRpr) {
		this.tipoDocRpr = tipoDocRpr;
	}

	public String getNumDocRpr() {
		return numDocRpr;
	}

	public void setNumDocRpr(String numDocRpr) {
		this.numDocRpr = numDocRpr;
	}

	public String getPrimNombRpr() {
		return primNombRpr;
	}

	public void setPrimNombRpr(String primNombRpr) {
		this.primNombRpr = primNombRpr;
	}

	public String getSegNombRpr() {
		return segNombRpr;
	}

	public void setSegNombRpr(String segNombRpr) {
		this.segNombRpr = segNombRpr;
	}

	public String getPrimApellRpr() {
		return primApellRpr;
	}

	public void setPrimApellRpr(String primApellRpr) {
		this.primApellRpr = primApellRpr;
	}

	public String getSegApellRpr() {
		return segApellRpr;
	}

	public void setSegApellRpr(String segApellRpr) {
		this.segApellRpr = segApellRpr;
	}

	public String getSexoRpr() {
		return sexoRpr;
	}

	public void setSexoRpr(String sexoRpr) {
		this.sexoRpr = sexoRpr;
	}

	public Date getFechNacRpr() {
		return fechNacRpr;
	}

	public void setFechNacRpr(Date fechNacRpr) {
		this.fechNacRpr = fechNacRpr;
	}

	public String getEdadRpr() {
		return edadRpr;
	}

	public void setEdadRpr(String edadRpr) {
		this.edadRpr = edadRpr;
	}

	public String getEdoCivRpr() {
		return edoCivRpr;
	}

	public void setEdoCivRpr(String edoCivRpr) {
		this.edoCivRpr = edoCivRpr;
	}

	public String getParentescoRpr() {
		return parentescoRpr;
	}

	public void setParentescoRpr(String parentescoRpr) {
		this.parentescoRpr = parentescoRpr;
	}

	public String getTextoDirPpalRpr() {
		return textoDirPpalRpr;
	}

	public void setTextoDirPpalRpr(String textoDirPpalRpr) {
		this.textoDirPpalRpr = textoDirPpalRpr;
	}

	public String getEstadodirppalrep() {
		return estadodirppalrep;
	}

	public void setEstadodirppalrep(String estadodirppalrep) {
		this.estadodirppalrep = estadodirppalrep;
	}

	public String getMunicipiodirppalrep() {
		return municipiodirppalrep;
	}

	public void setMunicipiodirppalrep(String municipiodirppalrep) {
		this.municipiodirppalrep = municipiodirppalrep;
	}

	public String getCiudaddirppalrep() {
		return ciudaddirppalrep;
	}

	public void setCiudaddirppalrep(String ciudaddirppalrep) {
		this.ciudaddirppalrep = ciudaddirppalrep;
	}

	public String getParroquiadirppalrep() {
		return parroquiadirppalrep;
	}

	public void setParroquiadirppalrep(String parroquiadirppalrep) {
		this.parroquiadirppalrep = parroquiadirppalrep;
	}

	public String getCodpostaldirppalrep() {
		return codpostaldirppalrep;
	}

	public void setCodpostaldirppalrep(String codpostaldirppalrep) {
		this.codpostaldirppalrep = codpostaldirppalrep;
	}

	public String getTextoDirSecRpr() {
		return textoDirSecRpr;
	}

	public void setTextoDirSecRpr(String textoDirSecRpr) {
		this.textoDirSecRpr = textoDirSecRpr;
	}

	public String getEstadodirsecrep() {
		return estadodirsecrep;
	}

	public void setEstadodirsecrep(String estadodirsecrep) {
		this.estadodirsecrep = estadodirsecrep;
	}

	public String getMunicipiodirsecrep() {
		return municipiodirsecrep;
	}

	public void setMunicipiodirsecrep(String municipiodirsecrep) {
		this.municipiodirsecrep = municipiodirsecrep;
	}

	public String getCiudaddirsecrep() {
		return ciudaddirsecrep;
	}

	public void setCiudaddirsecrep(String ciudaddirsecrep) {
		this.ciudaddirsecrep = ciudaddirsecrep;
	}

	public String getParroquiadirsecrep() {
		return parroquiadirsecrep;
	}

	public void setParroquiadirsecrep(String parroquiadirsecrep) {
		this.parroquiadirsecrep = parroquiadirsecrep;
	}

	public String getCodpostaldirsecrep() {
		return codpostaldirsecrep;
	}

	public void setCodpostaldirsecrep(String codpostaldirsecrep) {
		this.codpostaldirsecrep = codpostaldirsecrep;
	}

	public String getCodoperadorappalrep() {
		return codoperadorappalrep;
	}

	public void setCodoperadorappalrep(String codoperadorappalrep) {
		this.codoperadorappalrep = codoperadorappalrep;
	}

	public String getTextoTlfPpalRpr() {
		return textoTlfPpalRpr;
	}

	public void setTextoTlfPpalRpr(String textoTlfPpalRpr) {
		this.textoTlfPpalRpr = textoTlfPpalRpr;
	}

	public String getCodoperadorasecrep() {
		return codoperadorasecrep;
	}

	public void setCodoperadorasecrep(String codoperadorasecrep) {
		this.codoperadorasecrep = codoperadorasecrep;
	}

	public String getTextoTlfSecRpr() {
		return textoTlfSecRpr;
	}

	public void setTextoTlfSecRpr(String textoTlfSecRpr) {
		this.textoTlfSecRpr = textoTlfSecRpr;
	}

	public String getEmailRpr() {
		return emailRpr;
	}

	public void setEmailRpr(String emailRpr) {
		this.emailRpr = emailRpr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    


    
    
 
}
