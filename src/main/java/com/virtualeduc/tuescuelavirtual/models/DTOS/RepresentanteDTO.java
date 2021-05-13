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
    
   
    private String dirPpalRpr;
    
   
    private String dirSecRpr;
    
   
    private String tlfPpalRpr;
    
   
    private String tlfSecRpr;
    
    
    private String emailRpr;
    
     public RepresentanteDTO(){
     }
     
      public RepresentanteDTO(Long idRpr) {
        this.idRpr = idRpr;
    }
     
       public RepresentanteDTO(Representante representante){
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
        this.dirPpalRpr = representante.getDirPpalRpr();
        this.dirSecRpr = representante.getDirSecRpr();
        this.tlfPpalRpr = representante.getTlfPpalRpr();
        this.tlfSecRpr = representante.getTlfSecRpr();
        this.emailRpr = representante.getEmailRpr();
       }

    public RepresentanteDTO(Long idRpr, String tipoDocRpr, String numDocRpr, String primNombRpr, String segNombRpr, String primApellRpr, String segApellRpr, String sexoRpr, Date fechNacRpr, String edadRpr, String edoCivRpr, String parentescoRpr, String dirPpalRpr, String dirSecRpr, String tlfPpalRpr, String tlfSecRpr, String emailRpr) {
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
        this.dirPpalRpr = dirPpalRpr;
        this.dirSecRpr = dirSecRpr;
        this.tlfPpalRpr = tlfPpalRpr;
        this.tlfSecRpr = tlfSecRpr;
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

    public String getDirPpalRpr() {
        return dirPpalRpr;
    }

    public void setDirPpalRpr(String dirPpalRpr) {
        this.dirPpalRpr = dirPpalRpr;
    }

    public String getDirSecRpr() {
        return dirSecRpr;
    }

    public void setDirSecRpr(String dirSecRpr) {
        this.dirSecRpr = dirSecRpr;
    }

    public String getTlfPpalRpr() {
        return tlfPpalRpr;
    }

    public void setTlfPpalRpr(String tlfPpalRpr) {
        this.tlfPpalRpr = tlfPpalRpr;
    }

    public String getTlfSecRpr() {
        return tlfSecRpr;
    }

    public void setTlfSecRpr(String tlfSecRpr) {
        this.tlfSecRpr = tlfSecRpr;
    }

    public String getEmailRpr() {
        return emailRpr;
    }

    public void setEmailRpr(String emailRpr) {
        this.emailRpr = emailRpr;
    }
    
    
 
}
