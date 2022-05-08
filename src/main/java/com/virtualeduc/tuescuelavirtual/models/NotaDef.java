package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.*;


/**
 * The persistent class for the notas_def database table.
 * 
 */
@Entity
@Table(name="notas_def")
public class NotaDef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NOTA")
	private Long idNota;

	@Column(name="ID_CURSO")
	private java.math.BigInteger idCurso;
	
	@Column(name="ID_ALUMNO")
	private BigInteger idAlumno;

	@Column(name="ID_MAT")
	private java.math.BigInteger idMat;

	@Column(name="ID_PRF")
	private java.math.BigInteger idPrf;

	private String nota;

	public NotaDef() {
	}

	public Long getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public java.math.BigInteger getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(java.math.BigInteger idCurso) {
		this.idCurso = idCurso;
	}
	
	

	public BigInteger getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(BigInteger idAlumno) {
		this.idAlumno = idAlumno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public java.math.BigInteger getIdMat() {
		return this.idMat;
	}

	public void setIdMat(java.math.BigInteger idMat) {
		this.idMat = idMat;
	}

	public java.math.BigInteger getIdPrf() {
		return this.idPrf;
	}

	public void setIdPrf(java.math.BigInteger idPrf) {
		this.idPrf = idPrf;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}
	
	



}