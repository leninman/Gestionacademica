package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;

import javax.persistence.*;


/**
 * The persistent class for the `cursos_prof` database table.
 * 
 */
@Entity
@Table(name="`cursos_prof`")
@NamedQuery(name="Cursos_prof.findAll", query="SELECT m FROM Cursos_prof m")
public class Cursos_prof implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="ID_CURSO_PROF")
	private Long idCursoProf;
	
	@Column(name="ID_CURSO")
	private Long idCurso;

	@Column(name="ID_MAT")
	private Long idMat;

	@Column(name="ID_PROF")
	private Long idProf;
	
	
	

	public Cursos_prof() {
	}

	
	public Cursos_prof(Long idCursoProf, Long idCurso, Long idMat, Long idProf) {
		super();
		this.idCursoProf = idCursoProf;
		this.idCurso = idCurso;
		this.idMat = idMat;
		this.idProf = idProf;
	}







	public Long getIdCursoProf() {
		return idCursoProf;
	}



	public void setIdMatProf(Long idCursoProf) {
		this.idCursoProf = idCursoProf;
	}
	
	



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Long getIdMat() {
		return this.idMat;
	}

	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}

	public Long getIdProf() {
		return this.idProf;
	}

	public void setIdProf(Long idProf) {
		this.idProf = idProf;
	}



	public Long getIdCurso() {
		return idCurso;
	}



	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	
	

}