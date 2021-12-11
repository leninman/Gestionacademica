/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "alumnos")
public class Alumno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_AL")
	private Long idAl;

	@Basic(optional = false)
	@Column(name = "TIPO_DOC_AL")
	private String tipoDocAl;

	@Basic(optional = false)
	@Column(name = "NUM_DOC_AL")
	private String numDocAl;

	@Basic(optional = false)
	@Column(name = "PRIM_NOMB_AL")
	private String primNombAl;

	@Column(name = "SEG_NOMB_AL")
	private String segNombAl;

	@Basic(optional = false)
	@Column(name = "PRIM_APELL_AL")
	private String primApellAl;

	@Column(name = "SEG_APELL_AL")
	private String segApellAl;

	@Basic(optional = false)
	@Column(name = "SEXO_AL")
	private String sexoAl;

	@Basic(optional = false)
	@Column(name = "FECH_NAC_AL")
	@Temporal(TemporalType.DATE)
	private Date fechNacAl;

	@Basic(optional = false)
	@Column(name = "EDAD_AL")
	private String edadAl;

	@Basic(optional = false)
	@Column(name = "DIR_PPAL_AL")
	private String dirPpalAl;

	@Basic(optional = false)
	@Column(name = "DIR_SEC_AL")
	private String dirSecAl;

	@Basic(optional = false)
	@Column(name = "TLF_PPAL_AL")
	private String tlfPpalAl;

	@Basic(optional = false)
	@Column(name = "TLF_SEC_AL")
	private String tlfSecAl;

	@Basic(optional = false)
	@Column(name = "EMAIL_AL")
	private String emailAl;

	@Basic(optional = false)
	@Column(name = "FECH_ING_AL")
	@Temporal(TemporalType.DATE)
	private Date fechIngAl;

	@Basic(optional = false)
	@Column(name = "STATUS")
	private String status;

	@JoinColumn(name = "ID_RPR1", referencedColumnName = "ID_RPR")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Representante idRpr1;
	
	@Basic(optional = false)
	@Column(name = "PAR_RPR1")
	private String parRpr1;

	@JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Curso idCurso;

	@JoinColumn(name = "ID_RPR2", referencedColumnName = "ID_RPR")
	@ManyToOne(fetch = FetchType.LAZY)
	private Representante idRpr2;
	
	@Basic(optional = false)
	@Column(name = "PAR_RPR2")
	private String parRpr2;

	@Basic(optional = false)
	@Column(name = "FECHA_CREACION")
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;

	@PrePersist
	public void prePersist() {
		fechaCreacion = new Date();

	}

	public Alumno() {
	}

	public Alumno(AlumnoDTO alumnoDTO) {
		this.tipoDocAl = alumnoDTO.getTipoDocAl();
		this.numDocAl = alumnoDTO.getNumDocAl();
		this.primNombAl = alumnoDTO.getPrimNombAl();
		this.segNombAl = alumnoDTO.getSegNombAl();
		this.primApellAl = alumnoDTO.getPrimApellAl();
		this.segApellAl = alumnoDTO.getSegApellAl();
		this.sexoAl = alumnoDTO.getSexoAl();
		this.fechNacAl = alumnoDTO.getFechNacAl();
		this.edadAl = alumnoDTO.getEdadAl();
		// this.dirPpalAl = alumnoDTO.getDirPpalAl();
		this.dirPpalAl = alumnoDTO.getTextoDirPpalAl().concat(",").concat(alumnoDTO.getEstadodirppalest()).concat(",")
				.concat(alumnoDTO.getMunicipiodirppalest()).concat(",").concat(alumnoDTO.getCiudaddirppalest())
				.concat(",").concat(alumnoDTO.getParroquiadirppalest()).concat(",")
				.concat(alumnoDTO.getCodpostaldirppalest());

		if (alumnoDTO.getTextoDirSecAl() != "" && alumnoDTO.getEstadodirsecest() != null && alumnoDTO.getMunicipiodirsecest() != null
				&& alumnoDTO.getCiudaddirsecest() != null && alumnoDTO.getParroquiadirsecest() != null
				&& alumnoDTO.getCodpostaldirsecest() != null) {
			this.dirSecAl = alumnoDTO.getTextoDirSecAl().concat(",").concat(alumnoDTO.getEstadodirsecest()).concat(",")
					.concat(alumnoDTO.getMunicipiodirsecest()).concat(",").concat(alumnoDTO.getCiudaddirsecest())
					.concat(",").concat(alumnoDTO.getParroquiadirsecest()).concat(",")
					.concat(alumnoDTO.getCodpostaldirsecest());
		} else {
			this.dirSecAl = this.dirPpalAl;
		}

		this.tlfPpalAl = alumnoDTO.getCodoperadorappalest().concat("-").concat(alumnoDTO.getTextoTlfPpalAl());

		if (alumnoDTO.getCodoperadorasecest() != null
				&& alumnoDTO.getTextoTlfSecAl() != "") {
			this.tlfSecAl = alumnoDTO.getCodoperadorasecest().concat("-").concat(alumnoDTO.getTextoTlfSecAl());
		} else {
			this.tlfSecAl = this.tlfPpalAl;
		}
		
		this.parRpr1=alumnoDTO.getParRpr1();
		this.parRpr2=alumnoDTO.getParRpr2();

		this.emailAl = alumnoDTO.getEmailAl();
		this.fechIngAl = alumnoDTO.getFechIngAl();
		this.status = alumnoDTO.getStatus();

	}

	public Alumno(Long idAl, String tipoDocAl, String numDocAl, String primNombAl, String segNombAl, String primApellAl,
			String segApellAl, String sexoAl, Date fechNacAl, String edadAl, String dirPpalAl, String dirSecAl,
			String tlfPpalAl, String tlfSecAl, String emailAl, Date fechIngAl, String status, Representante idRpr1,
			Curso idCurso, Representante idRpr2, Date fechaCreacion) {
		this.idAl = idAl;
		this.tipoDocAl = tipoDocAl;
		this.numDocAl = numDocAl;
		this.primNombAl = primNombAl;
		this.segNombAl = segNombAl;
		this.primApellAl = primApellAl;
		this.segApellAl = segApellAl;
		this.sexoAl = sexoAl;
		this.fechNacAl = fechNacAl;
		this.edadAl = edadAl;
		this.dirPpalAl = dirPpalAl;
		this.dirSecAl = dirSecAl;
		this.tlfPpalAl = tlfPpalAl;
		this.tlfSecAl = tlfSecAl;
		this.emailAl = emailAl;
		this.fechIngAl = fechIngAl;
		this.status = status;
		this.idRpr1 = idRpr1;
		this.idCurso = idCurso;
		this.idRpr2 = idRpr2;
		this.fechaCreacion = fechaCreacion;
	}

	public Alumno(Long idAl) {
		this.idAl = idAl;
	}

	public Long getIdAl() {
		return idAl;
	}

	public void setIdAl(Long idAl) {
		this.idAl = idAl;
	}

	public String getTipoDocAl() {
		return tipoDocAl;
	}

	public void setTipoDocAl(String tipoDocAl) {
		this.tipoDocAl = tipoDocAl;
	}

	public String getNumDocAl() {
		return numDocAl;
	}

	public void setNumDocAl(String numDocAl) {
		this.numDocAl = numDocAl;
	}

	public String getPrimNombAl() {
		return primNombAl;
	}

	public void setPrimNombAl(String primNombAl) {
		this.primNombAl = primNombAl;
	}

	public String getSegNombAl() {
		return segNombAl;
	}

	public void setSegNombAl(String segNombAl) {
		this.segNombAl = segNombAl;
	}

	public String getPrimApellAl() {
		return primApellAl;
	}

	public void setPrimApellAl(String primApellAl) {
		this.primApellAl = primApellAl;
	}

	public String getSegApellAl() {
		return segApellAl;
	}

	public void setSegApellAl(String segApellAl) {
		this.segApellAl = segApellAl;
	}

	public String getSexoAl() {
		return sexoAl;
	}

	public void setSexoAl(String sexoAl) {
		this.sexoAl = sexoAl;
	}

	public Date getFechNacAl() {
		return fechNacAl;
	}

	public void setFechNacAl(Date fechNacAl) {
		this.fechNacAl = fechNacAl;
	}

	public String getEdadAl() {
		return edadAl;
	}

	public void setEdadAl(String edadAl) {
		this.edadAl = edadAl;
	}

	public String getDirPpalAl() {
		return dirPpalAl;
	}

	public void setDirPpalAl(String dirPpalAl) {
		this.dirPpalAl = dirPpalAl;
	}

	public String getDirSecAl() {
		return dirSecAl;
	}

	public void setDirSecAl(String dirSecAl) {
		this.dirSecAl = dirSecAl;
	}

	public String getTlfPpalAl() {
		return tlfPpalAl;
	}

	public void setTlfPpalAl(String tlfPpalAl) {
		this.tlfPpalAl = tlfPpalAl;
	}

	public String getTlfSecAl() {
		return tlfSecAl;
	}

	public void setTlfSecAl(String tlfSecAl) {
		this.tlfSecAl = tlfSecAl;
	}

	public String getEmailAl() {
		return emailAl;
	}

	public void setEmailAl(String emailAl) {
		this.emailAl = emailAl;
	}

	public Date getFechIngAl() {
		return fechIngAl;
	}

	public void setFechIngAl(Date fechIngAl) {
		this.fechIngAl = fechIngAl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Representante getIdRpr1() {
		return idRpr1;
	}

	public void setIdRpr1(Representante idRpr1) {
		this.idRpr1 = idRpr1;
	}

	public Curso getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Curso idCurso) {
		this.idCurso = idCurso;
	}

	public Representante getIdRpr2() {
		return idRpr2;
	}

	public void setIdRpr2(Representante idRpr2) {
		this.idRpr2 = idRpr2;
	}

	public String getParRpr1() {
		return parRpr1;
	}

	public void setParRpr1(String parRpr1) {
		this.parRpr1 = parRpr1;
	}

	public String getParRpr2() {
		return parRpr2;
	}

	public void setParRpr2(String parRpr2) {
		this.parRpr2 = parRpr2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
