package com.virtualeduc.tuescuelavirtual.models.DTOS;

import java.io.Serializable;




public class NotasParDTO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long idNotaPar;
	
	
	private Long idAlumno;

	
	private Long idCurso;

	
	private Long idLapso;

	
	private Long idMat;

	
	private Long idPrf;

	private String nota;

	public NotasParDTO() {

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
	
	
	
	
	
	

}




