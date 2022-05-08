package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import com.virtualeduc.tuescuelavirtual.models.DTOS.MateriaDTO;


/**
 * The persistent class for the materias database table.
 * 
 */
@Entity
@Table(name="materias")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID_MAT")
	private Long idMat;
	
	@Basic(optional = false)
	@Column(name="CODIGO_MAT")
	private String codigoMat;

	@Basic(optional = false)
	@Column(name="DESCRIPCION_MAT")
	private String descripcionMat;
	
	
	@ManyToOne
    @JoinColumn(name = "ID_ANNIO",nullable=false)
    private Annio annio;

	
	@Basic(optional = false)
	@Column(name="NOMBRE_MAT")
	private String nombreMat;
	
	@Basic(optional = false)
	@Column(name="STATUS")
	private String status;
        
        
	
	public Materia() {
	}

   

    
        	
	public Materia(Long idMat, String codigoMat, String descripcionMat, Annio annio, String nombreMat, String status) {
		super();
		this.idMat = idMat;
		this.codigoMat = codigoMat;
		this.descripcionMat = descripcionMat;
		this.annio = annio;
		this.nombreMat = nombreMat;
		this.status = status;
	}





	public Materia(MateriaDTO materiaDTO) {
		this.idMat = materiaDTO.getIdMat();
		this.codigoMat = materiaDTO.getCodigoMat();
		this.descripcionMat = materiaDTO.getDescripcionMat();
		this.nombreMat = materiaDTO.getNombreMat();
		this.status=materiaDTO.getStatus();
		
	}


	public Long getIdMat() {
		return idMat;
	}


	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}


	public String getCodigoMat() {
		return codigoMat;
	}

	public void setCodigoMat(String codigoMat) {
		this.codigoMat = codigoMat;
	}

	public String getDescripcionMat() {
		return descripcionMat;
	}

	public void setDescripcionMat(String descripcionMat) {
		this.descripcionMat = descripcionMat;
	}

	public Annio getAnnio() {
		return annio;
	}

	public void setAnnio(Annio annio) {
		this.annio = annio;
	}

	public String getNombreMat() {
		return nombreMat;
	}

	public void setNombreMat(String nombreMat) {
		this.nombreMat = nombreMat;
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