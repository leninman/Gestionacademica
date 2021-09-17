package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the profesores database table.
 * 
 */
@Entity
@NamedQuery(name="Profesores.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_PRF")
	private String idPrf;

	@Column(name="ANIOS_SERV_PRF")
	private int aniosServPrf;

	@Column(name="CAT_PRF")
	private String catPrf;

	@Column(name="DIR_PPAL_PRF")
	private String dirPpalPrf;

	@Column(name="DIR_SEC_PRF")
	private String dirSecPrf;

	@Column(name="EDAD_PRF")
	private int edadPrf;

	@Column(name="EDO_CIVIL_PRF")
	private String edoCivilPrf;

	@Column(name="EMAIL_PRF")
	private String emailPrf;

	@Column(name="ESPECIALIDAD_PRF")
	private String especialidadPrf;

	@Temporal(TemporalType.DATE)
	@Column(name="FECH_NAC_PRF")
	private Date fechNacPrf;

	private String graduado;

	@Column(name="NIVEL_EDUCATIVO")
	private String nivelEducativo;

	@Column(name="NUM_DOC_PRF")
	private String numDocPrf;

	private String ocupacion;

	@Column(name="PRIM_APELL_PRF")
	private String primApellPrf;

	@Column(name="PRIM_NOMB_PRF")
	private String primNombPrf;

	@Column(name="PROFESION_PRF")
	private String profesionPrf;

	@Column(name="SEG_APELL_PRF")
	private String segApellPrf;

	@Column(name="SEG_NOMB_PRF")
	private String segNombPrf;

	@Column(name="SEXO_PRF")
	private String sexoPrf;

	private String status;

	@Column(name="TIPO_DOC_PRF")
	private String tipoDocPrf;

	@Column(name="TLF_PPAL_PRF")
	private String tlfPpalPrf;

	@Column(name="TLF_SEC_PRF")
	private String tlfSecPrf;
	
	@Temporal(TemporalType.DATE)
	@Column(name="FECH_ING_PRF")
	private Date fechIngPrf;

	public Profesor() {
	}

	public String getIdPrf() {
		return this.idPrf;
	}

	public void setIdPrf(String idPrf) {
		this.idPrf = idPrf;
	}

	public int getAniosServPrf() {
		return this.aniosServPrf;
	}

	public void setAniosServPrf(int aniosServPrf) {
		this.aniosServPrf = aniosServPrf;
	}

	public String getCatPrf() {
		return this.catPrf;
	}

	public void setCatPrf(String catPrf) {
		this.catPrf = catPrf;
	}

	public String getDirPpalPrf() {
		return this.dirPpalPrf;
	}

	public void setDirPpalPrf(String dirPpalPrf) {
		this.dirPpalPrf = dirPpalPrf;
	}

	public String getDirSecPrf() {
		return this.dirSecPrf;
	}

	public void setDirSecPrf(String dirSecPrf) {
		this.dirSecPrf = dirSecPrf;
	}

	public int getEdadPrf() {
		return this.edadPrf;
	}

	public void setEdadPrf(int edadPrf) {
		this.edadPrf = edadPrf;
	}

	public String getEdoCivilPrf() {
		return this.edoCivilPrf;
	}

	public void setEdoCivilPrf(String edoCivilPrf) {
		this.edoCivilPrf = edoCivilPrf;
	}

	public Date getFechIngPrf() {
		return fechIngPrf;
	}

	public void setFechIngPrf(Date fechIngPrf) {
		this.fechIngPrf = fechIngPrf;
	}

	public String getEmailPrf() {
		return this.emailPrf;
	}

	public void setEmailPrf(String emailPrf) {
		this.emailPrf = emailPrf;
	}

	public String getEspecialidadPrf() {
		return this.especialidadPrf;
	}

	public void setEspecialidadPrf(String especialidadPrf) {
		this.especialidadPrf = especialidadPrf;
	}

	public Date getFechNacPrf() {
		return this.fechNacPrf;
	}

	public void setFechNacPrf(Date fechNacPrf) {
		this.fechNacPrf = fechNacPrf;
	}

	public String getGraduado() {
		return this.graduado;
	}

	public void setGraduado(String graduado) {
		this.graduado = graduado;
	}

	public String getNivelEducativo() {
		return this.nivelEducativo;
	}

	public void setNivelEducativo(String nivelEducativo) {
		this.nivelEducativo = nivelEducativo;
	}

	public String getNumDocPrf() {
		return this.numDocPrf;
	}

	public void setNumDocPrf(String numDocPrf) {
		this.numDocPrf = numDocPrf;
	}

	public String getOcupacion() {
		return this.ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public String getPrimApellPrf() {
		return this.primApellPrf;
	}

	public void setPrimApellPrf(String primApellPrf) {
		this.primApellPrf = primApellPrf;
	}

	public String getPrimNombPrf() {
		return this.primNombPrf;
	}

	public void setPrimNombPrf(String primNombPrf) {
		this.primNombPrf = primNombPrf;
	}

	public String getProfesionPrf() {
		return this.profesionPrf;
	}

	public void setProfesionPrf(String profesionPrf) {
		this.profesionPrf = profesionPrf;
	}

	public String getSegApellPrf() {
		return this.segApellPrf;
	}

	public void setSegApellPrf(String segApellPrf) {
		this.segApellPrf = segApellPrf;
	}

	public String getSegNombPrf() {
		return this.segNombPrf;
	}

	public void setSegNombPrf(String segNombPrf) {
		this.segNombPrf = segNombPrf;
	}

	public String getSexoPrf() {
		return this.sexoPrf;
	}

	public void setSexoPrf(String sexoPrf) {
		this.sexoPrf = sexoPrf;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoDocPrf() {
		return this.tipoDocPrf;
	}

	public void setTipoDocPrf(String tipoDocPrf) {
		this.tipoDocPrf = tipoDocPrf;
	}

	public String getTlfPpalPrf() {
		return this.tlfPpalPrf;
	}

	public void setTlfPpalPrf(String tlfPpalPrf) {
		this.tlfPpalPrf = tlfPpalPrf;
	}

	public String getTlfSecPrf() {
		return this.tlfSecPrf;
	}

	public void setTlfSecPrf(String tlfSecPrf) {
		this.tlfSecPrf = tlfSecPrf;
	}

}