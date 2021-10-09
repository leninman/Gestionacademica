package com.virtualeduc.tuescuelavirtual.models.DTOS;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.virtualeduc.tuescuelavirtual.models.Materia;

public class MateriaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idMat;

	@NotEmpty(message = "Requerido")
	private String codigoMat;

	@NotEmpty(message = "Requerido")
	private String descripcionMat;

	@NotEmpty(message = "Requerido")
	private String nombreMat;

	private Long idAnnio;

	private String annio;

	private String nivel;

	private String especialidad;
	
	@NotEmpty(message = "Requerido")
	private String status;

	public MateriaDTO() {

	}
	
	


	





	public MateriaDTO(Long idMat, @NotEmpty(message = "Requerido") String codigoMat,
			@NotEmpty(message = "Requerido") String descripcionMat, @NotEmpty(message = "Requerido") String nombreMat,
			Long idAnnio, String annio, String nivel, String especialidad,
			@NotEmpty(message = "Requerido") String status) {
		super();
		this.idMat = idMat;
		this.codigoMat = codigoMat;
		this.descripcionMat = descripcionMat;
		this.nombreMat = nombreMat;
		this.idAnnio = idAnnio;
		this.annio = annio;
		this.nivel = nivel;
		this.especialidad = especialidad;
		this.status = status;
	}










	public MateriaDTO(Materia materia) {
		this.idMat = materia.getIdMat();
		this.codigoMat = materia.getCodigoMat();
		this.descripcionMat = materia.getDescripcionMat();
		this.nombreMat = materia.getNombreMat();
		this.idAnnio = materia.getAnnio().getIdAnnio();
		this.annio = materia.getAnnio().getAnnio();
		this.nivel = materia.getAnnio().getNivel();
		this.especialidad = materia.getAnnio().getEspecialidad();
		this.status=materia.getStatus();
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

	public String getNombreMat() {
		return nombreMat;
	}

	public void setNombreMat(String nombreMat) {
		this.nombreMat = nombreMat;
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
