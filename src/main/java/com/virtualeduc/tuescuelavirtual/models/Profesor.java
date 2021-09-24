package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import javax.persistence.*;

import com.virtualeduc.tuescuelavirtual.models.DTOS.ProfesorDTO;

import java.util.Date;

/**
 * The persistent class for the profesores database table.
 * 
 */
@Entity
@Table(name = "profesores")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_PRF")
	private Long idPrf;

	@Column(name = "ANIOS_SERV_PRF")
	private int aniosServPrf;

	@Column(name = "CAT_PRF")
	private String catPrf;

	@Column(name = "DIR_PPAL_PRF")
	private String dirPpalPrf;

	@Column(name = "DIR_SEC_PRF")
	private String dirSecPrf;

	@Column(name = "EDAD_PRF")
	private int edadPrf;

	@Column(name = "EDO_CIVIL_PRF")
	private String edoCivilPrf;

	@Column(name = "EMAIL_PRF")
	private String emailPrf;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECH_NAC_PRF")
	private Date fechNacPrf;

	private String graduado;

	private String pregrado1;

	private String pregrado2;

	private String postgrado1;

	private String postgrado2;

	private String curso1;

	private String curso2;

	private String curso3;

	private String curso4;

	@Column(name = "NUM_DOC_PRF")
	private String numDocPrf;

	@Column(name = "PRIM_APELL_PRF")
	private String primApellPrf;

	@Column(name = "PRIM_NOMB_PRF")
	private String primNombPrf;

	@Column(name = "SEG_APELL_PRF")
	private String segApellPrf;

	@Column(name = "SEG_NOMB_PRF")
	private String segNombPrf;

	@Column(name = "SEXO_PRF")
	private String sexoPrf;

	private String status;

	@Column(name = "TIPO_DOC_PRF")
	private String tipoDocPrf;

	@Column(name = "TLF_PPAL_PRF")
	private String tlfPpalPrf;

	@Column(name = "TLF_SEC_PRF")
	private String tlfSecPrf;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECH_ING_PRF")
	private Date fechIngPrf;

	public Profesor() {
	}

	public Profesor(ProfesorDTO profesordto) {

		this.idPrf = profesordto.getIdPrf();
		this.aniosServPrf = profesordto.getAniosServPrf();
		this.catPrf = profesordto.getCatPrf();
		this.dirPpalPrf = profesordto.getTextoDirPpalPrf().concat(",").concat(profesordto.getEstadodirppalprf())
				.concat(",").concat(profesordto.getMunicipiodirppalprf()).concat(",")
				.concat(profesordto.getCiudaddirppalprf()).concat(",").concat(profesordto.getParroquiadirppalprf())
				.concat(",").concat(profesordto.getCodpostaldirppalprf());

		if (profesordto.getTextoDirSecPrf() != "") {
			this.dirSecPrf = profesordto.getTextoDirSecPrf().concat(",").concat(profesordto.getEstadodirsecprf())
					.concat(",").concat(profesordto.getMunicipiodirsecprf()).concat(",")
					.concat(profesordto.getCiudaddirsecprf()).concat(",").concat(profesordto.getParroquiadirsecprf())
					.concat(",").concat(profesordto.getCodpostaldirsecprf());
		} else {
			this.dirSecPrf = this.dirPpalPrf;
		}

		this.edadPrf = profesordto.getEdadPrf();
		this.edoCivilPrf = profesordto.getEdoCivilPrf();
		this.emailPrf = profesordto.getEmailPrf();
		this.fechNacPrf = profesordto.getFechNacPrf();
		this.graduado = profesordto.getGraduado();
		this.pregrado1 = profesordto.getPregrado1().concat("con especialidad en ")
				.concat(profesordto.getEspecialidad1());
		if (profesordto.getPregrado2() != null && profesordto.getPregrado2() != "") {
			this.pregrado2 = profesordto.getPregrado2().concat("con especialidad en ")
					.concat(profesordto.getEspecialidad2());
		} else {
			this.pregrado2 = "";
		}
		if (profesordto.getPostgrado1() != null && profesordto.getPostgrado1() != "") {
			this.postgrado1 = profesordto.getPostgrado1();
		}
		if (profesordto.getPostgrado2() != null && profesordto.getPostgrado2() != "") {
			this.postgrado2 = profesordto.getPostgrado2();
		}
		if (profesordto.getCurso1() != null && profesordto.getCurso1() != "") {
			this.curso1 = profesordto.getCurso1();
		}
		if (profesordto.getCurso2() != null && profesordto.getCurso2() != "") {
			this.curso2 = profesordto.getCurso2();
		}
		if (profesordto.getCurso3() != null && profesordto.getCurso3() != "") {
			this.curso3 = profesordto.getCurso3();
		}

		if (profesordto.getCurso4() != null && profesordto.getCurso4() != "") {
			this.curso4 = profesordto.getCurso4();
		}
		this.numDocPrf = profesordto.getNumDocPrf();
		this.primApellPrf = profesordto.getPrimApellPrf();
		this.primNombPrf = profesordto.getPrimNombPrf();
		this.segApellPrf = profesordto.getSegApellPrf();
		this.segNombPrf = profesordto.getSegNombPrf();
		this.sexoPrf = profesordto.getSexoPrf();
		this.status = profesordto.getStatus();
		this.tipoDocPrf = profesordto.getTipoDocPrf();
		this.tlfPpalPrf = profesordto.getCodoperadorappalprf().concat("-").concat(profesordto.getTextoTlfPpalPrf());

		if (profesordto.getTextoTlfSecPrf() != "") {
			this.tlfSecPrf = profesordto.getCodoperadorasecprf().concat("-").concat(profesordto.getTextoTlfSecPrf());
		} else {
			this.tlfSecPrf = this.tlfPpalPrf;
		}

		this.fechIngPrf = profesordto.getFechIngPrf();
	}

	public Long getIdPrf() {
		return this.idPrf;
	}

	public void setIdPrf(Long idPrf) {
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

	public String getPregrado1() {
		return pregrado1;
	}

	public void setPregrado1(String pregrado1) {
		this.pregrado1 = pregrado1;
	}

	public String getPregrado2() {
		return pregrado2;
	}

	public void setPregrado2(String pregrado2) {
		this.pregrado2 = pregrado2;
	}

	public String getPostgrado1() {
		return postgrado1;
	}

	public void setPostgrado1(String postgrado1) {
		this.postgrado1 = postgrado1;
	}

	public String getPostgrado2() {
		return postgrado2;
	}

	public void setPostgrado2(String postgrado2) {
		this.postgrado2 = postgrado2;
	}

	public String getCurso1() {
		return curso1;
	}

	public void setCurso1(String curso1) {
		this.curso1 = curso1;
	}

	public String getCurso2() {
		return curso2;
	}

	public void setCurso2(String curso2) {
		this.curso2 = curso2;
	}

	public String getCurso3() {
		return curso3;
	}

	public void setCurso3(String curso3) {
		this.curso3 = curso3;
	}

	public String getCurso4() {
		return curso4;
	}

	public void setCurso4(String curso4) {
		this.curso4 = curso4;
	}

	public String getSegApellPrf() {
		return segApellPrf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNumDocPrf() {
		return this.numDocPrf;
	}

	public void setNumDocPrf(String numDocPrf) {
		this.numDocPrf = numDocPrf;
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
