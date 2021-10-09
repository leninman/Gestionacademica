package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the `materias-prof` database table.
 * 
 */
@Entity
@Table(name="`materias-prof`")
@NamedQuery(name="Materias_prof.findAll", query="SELECT m FROM Materias_prof m")
public class Materias_prof implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID_MAT_PROF")
	private Long idMatProf;

	@Column(name="ID_MAT")
	private java.math.BigInteger idMat;

	@Column(name="ID_PROF")
	private java.math.BigInteger idProf;
	
	
	

	public Materias_prof() {
	}

	

	public Materias_prof(Long idMatProf, BigInteger idMat, BigInteger idProf) {
		super();
		this.idMatProf = idMatProf;
		this.idMat = idMat;
		this.idProf = idProf;
	}



	public Long getIdMatProf() {
		return idMatProf;
	}



	public void setIdMatProf(Long idMatProf) {
		this.idMatProf = idMatProf;
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

	public java.math.BigInteger getIdProf() {
		return this.idProf;
	}

	public void setIdProf(java.math.BigInteger idProf) {
		this.idProf = idProf;
	}

}