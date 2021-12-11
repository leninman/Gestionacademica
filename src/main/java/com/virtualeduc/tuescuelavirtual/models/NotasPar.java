package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the notas_par database table.
 * 
 */
@Entity
@Table(name="notas_par")
@NamedQuery(name="NotasPar.findAll", query="SELECT n FROM NotasPar n")
public class NotasPar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_NOTA_PAR")
	private Long idNotaPar;
	
	@Column(name="ID_ALUMNO")
	private Long idAlumno;

	@Column(name="ID_CURSO")
	private Long idCurso;

	@Column(name="ID_LAPSO")
	private Long idLapso;

	@Column(name="ID_MAT")
	private Long idMat;

	@Column(name="ID_PRF")
	private Long idPrf;

	private String nota;

	public NotasPar() {
	}

	public Long getIdNotaPar() {
		return idNotaPar;
	}

	public void setIdNotaPar(Long idNotaPar) {
		this.idNotaPar = idNotaPar;
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Long getIdLapso() {
		return idLapso;
	}

	public void setIdLapso(Long idLapso) {
		this.idLapso = idLapso;
	}

	public Long getIdMat() {
		return idMat;
	}

	public void setIdMat(Long idMat) {
		this.idMat = idMat;
	}

	public Long getIdPrf() {
		return idPrf;
	}

	public void setIdPrf(Long idPrf) {
		this.idPrf = idPrf;
	}

	

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	


}