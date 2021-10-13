package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the view_cursos_materias_sin_asignar database table.
 * 
 */
@Entity
@Table(name="view_cursos_materias_sin_asignar")
@NamedQuery(name="ViewCursosMateriasSinAsignar.findAll", query="SELECT v FROM ViewCursosMateriasSinAsignar v")
public class ViewCursosMateriasSinAsignar implements Serializable {
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

	@Column(name="PERIODO_ESCOLAR")
	private String periodoEscolar;

	private String seccion;

	public ViewCursosMateriasSinAsignar() {
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

	public String getPeriodoEscolar() {
		return this.periodoEscolar;
	}

	public void setPeriodoEscolar(String periodoEscolar) {
		this.periodoEscolar = periodoEscolar;
	}

	public String getSeccion() {
		return this.seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}