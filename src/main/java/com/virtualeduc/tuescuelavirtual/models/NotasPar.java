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
	private BigInteger idAlumno;

	@Column(name="ID_CURSO")
	private BigInteger idCurso;

	@Column(name="ID_LAPSO")
	private BigInteger idLapso;

	@Column(name="ID_MAT")
	private BigInteger idMat;

	@Column(name="ID_PRF")
	private BigInteger idPrf;

	private int nota;

	public NotasPar() {
	}

	public Long getIdNotaPar() {
		return this.idNotaPar;
	}

	public void setIdNotaPar(Long idNotaPar) {
		this.idNotaPar = idNotaPar;
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

	public BigInteger getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(BigInteger idCurso) {
		this.idCurso = idCurso;
	}

	public BigInteger getIdLapso() {
		return this.idLapso;
	}

	public void setIdLapso(BigInteger idLapso) {
		this.idLapso = idLapso;
	}

	public BigInteger getIdMat() {
		return this.idMat;
	}

	public void setIdMat(BigInteger idMat) {
		this.idMat = idMat;
	}

	public BigInteger getIdPrf() {
		return this.idPrf;
	}

	public void setIdPrf(BigInteger idPrf) {
		this.idPrf = idPrf;
	}

	public int getNota() {
		return this.nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

}