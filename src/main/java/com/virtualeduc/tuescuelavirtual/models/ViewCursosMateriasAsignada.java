package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_cursos_materias_asignadas database table.
 * 
 */
@Entity
@Table(name="view_cursos_materias_asignadas")
@NamedQuery(name="ViewCursosMateriasAsignada.findAll", query="SELECT v FROM ViewCursosMateriasAsignada v")
public class ViewCursosMateriasAsignada implements Serializable {
	private static final long serialVersionUID = 1L;

	private String annio;

	private String especialidad;

	@Column(name="ID_ANNIO")
	private BigInteger idAnnio;

	@Column(name="ID_CURSO")
	private BigInteger idCurso;

	@Column(name="ID_MAT")
	private BigInteger idMat;
	
	@Id
	@Column(name="ID_MAT_POR_CURSO")
	private String idMatPorCurso;

	private String materia;

	private String nivel;
	
	@Column(name="ID_PRF")
	private BigInteger idPrf;

	@Column(name="NUM_DOC_PRF")
	private String numDocPrf;

	@Column(name="PERIODO_ESCOLAR")
	private String periodoEscolar;

	@Column(name="PRIM_APELL_PRF")
	private String primApellPrf;

	@Column(name="PRIM_NOMB_PRF")
	private String primNombPrf;

	private String seccion;

	@Column(name="SEG_APELL_PRF")
	private String segApellPrf;

	@Column(name="SEG_NOMB_PRF")
	private String segNombPrf;

	@Column(name="TIPO_DOC_PRF")
	private String tipoDocPrf;

	public ViewCursosMateriasAsignada() {
	}

	public String getAnnio() {
		return this.annio;
	}

	public void setAnnio(String annio) {
		this.annio = annio;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public BigInteger getIdAnnio() {
		return this.idAnnio;
	}

	public void setIdAnnio(BigInteger idAnnio) {
		this.idAnnio = idAnnio;
	}

	public BigInteger getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(BigInteger idCurso) {
		this.idCurso = idCurso;
	}

	public BigInteger getIdMat() {
		return this.idMat;
	}

	public void setIdMat(BigInteger idMat) {
		this.idMat = idMat;
	}

	public String getIdMatPorCurso() {
		return this.idMatPorCurso;
	}

	public void setIdMatPorCurso(String idMatPorCurso) {
		this.idMatPorCurso = idMatPorCurso;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getNumDocPrf() {
		return this.numDocPrf;
	}

	public void setNumDocPrf(String numDocPrf) {
		this.numDocPrf = numDocPrf;
	}

	public String getPeriodoEscolar() {
		return this.periodoEscolar;
	}

	public void setPeriodoEscolar(String periodoEscolar) {
		this.periodoEscolar = periodoEscolar;
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

	public String getSeccion() {
		return this.seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
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

	public String getTipoDocPrf() {
		return this.tipoDocPrf;
	}

	public void setTipoDocPrf(String tipoDocPrf) {
		this.tipoDocPrf = tipoDocPrf;
	}

	public BigInteger getIdPrf() {
		return idPrf;
	}

	public void setIdPrf(BigInteger idPrf) {
		this.idPrf = idPrf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}