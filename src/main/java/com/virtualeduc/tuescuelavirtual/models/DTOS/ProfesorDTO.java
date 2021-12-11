package com.virtualeduc.tuescuelavirtual.models.DTOS;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.virtualeduc.tuescuelavirtual.models.Profesor;

public class ProfesorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idPrf;
	
	@NotEmpty(message = "Requerido")
	private String primNombPrf;
	
	@NotEmpty(message = "Requerido")
	private String primApellPrf;

	@NotEmpty(message = "Requerido")
	private String aniosServPrf;

	@NotEmpty(message = "Requerido")
	private String catPrf;

	@NotEmpty(message = "Requerido")
	private String textoDirPpalPrf;

	@NotEmpty(message = "Requerido")
	private String estadodirppalprf;

	@NotEmpty(message = "Requerido")
	private String municipiodirppalprf;

	@NotEmpty(message = "Requerido")
	private String ciudaddirppalprf;

	@NotEmpty(message = "Requerido")
	private String parroquiadirppalprf;

	@NotEmpty(message = "Requerido")
	private String codpostaldirppalprf;

	private String textoDirSecPrf;

	private String estadodirsecprf;

	private String municipiodirsecprf;

	private String ciudaddirsecprf;

	private String parroquiadirsecprf;

	private String codpostaldirsecprf;

	@NotEmpty(message = "Requerido")
	private String edadPrf;

	@NotEmpty(message = "Requerido")
	private String edoCivilPrf;

	@NotEmpty(message = "Requerido")
	@Email(message = "El email no es válido")
	private String emailPrf;

	@NotNull(message = "Requerido")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechNacPrf;

	@NotEmpty(message = "Requerido")
	private String graduado;

	@NotEmpty(message = "Requerido")
	private String pregrado1;

	@NotEmpty(message = "Requerido")
	private String especialidad1;

	private String pregrado2;

	private String especialidad2;

	private String postgrado1;

	private String postgrado2;

	private String curso1;

	private String curso2;

	private String curso3;

	private String curso4;

	@NotEmpty(message = "Requerido")
	private String numDocPrf;

	

	

	private String segApellPrf;

	private String segNombPrf;

	@NotEmpty(message = "Requerido")
	private String sexoPrf;

	@NotEmpty(message = "Requerido")
	private String status;

	@NotEmpty(message = "Requerido")
	private String tipoDocPrf;

	@NotEmpty(message = "Requerido")
	private String codoperadorappalprf;

	@NotEmpty(message = "Requerido")
	private String textoTlfPpalPrf;

	private String codoperadorasecprf;

	private String textoTlfSecPrf;

	@NotNull(message = "Requerido")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechIngPrf;

	public ProfesorDTO() {

	}
	
	





	public ProfesorDTO(Profesor profesor) {

		String strDirPpalPrf = profesor.getDirPpalPrf();
		String[] arrOfStrDirPpalPrf = strDirPpalPrf.split(",");
		String strDirSecPrf = profesor.getDirSecPrf();
		String[] arrOfStrDirSecPrf = strDirSecPrf.split(",");
		String strTlfPpalPrf = profesor.getTlfPpalPrf();
		String[] arrOfStrTlfPpalPrf = strTlfPpalPrf.split("-");
		String strTlfSecPrf = profesor.getTlfSecPrf();
		String[] arrOfStrTlfSecPrf = strTlfSecPrf.split("-");
		String strPregrado1 = profesor.getPregrado1();
		String[] arrOfStrPregrado1 = strPregrado1.split("con especialidad en ");
		String strPregrado2;
		String[] arrOfStrPregrado2 = null;
		if (!profesor.getPregrado2().equals("")) {
			strPregrado2 = profesor.getPregrado2();
			arrOfStrPregrado2 = strPregrado2.split("con especialidad en ");
		} else {
			strPregrado2 = "";
		}
		this.idPrf = profesor.getIdPrf();
		this.aniosServPrf = profesor.getAniosServPrf();
		this.catPrf = profesor.getCatPrf();
		this.textoDirPpalPrf = arrOfStrDirPpalPrf[0];
		this.estadodirppalprf = arrOfStrDirPpalPrf[1];
		this.municipiodirppalprf = arrOfStrDirPpalPrf[2];
		this.ciudaddirppalprf = arrOfStrDirPpalPrf[3];
		this.parroquiadirppalprf = arrOfStrDirPpalPrf[4];
		this.codpostaldirppalprf = arrOfStrDirPpalPrf[5];
		this.textoDirSecPrf = arrOfStrDirSecPrf[0];
		this.estadodirsecprf = arrOfStrDirPpalPrf[1];
		this.municipiodirsecprf = arrOfStrDirPpalPrf[2];
		this.ciudaddirsecprf = arrOfStrDirPpalPrf[3];
		this.parroquiadirsecprf = arrOfStrDirPpalPrf[4];
		this.codpostaldirsecprf = arrOfStrDirPpalPrf[5];
		this.edadPrf = profesor.getEdadPrf();
		this.edoCivilPrf = profesor.getEdoCivilPrf();
		this.emailPrf = profesor.getEmailPrf();
		this.fechNacPrf = profesor.getFechNacPrf();
		this.graduado = profesor.getGraduado();
		this.pregrado1 = arrOfStrPregrado1[0];
		this.especialidad1 = arrOfStrPregrado1[1];
		if (!strPregrado2.equals("") ) {
			this.pregrado2 = arrOfStrPregrado2[0];
			if(arrOfStrPregrado2.length==2) {
				this.especialidad2 = arrOfStrPregrado2[1];
			}else {
				this.especialidad2="";
			}
			
		}else {
			this.pregrado2 = "";
			this.especialidad2 = "";
		}
		//this.pregrado2 = profesor.getPregrado2();
		this.postgrado1 = profesor.getPostgrado1();
		this.postgrado2 = profesor.getPostgrado2();
		this.curso1 = profesor.getCurso1();
		this.curso2 = profesor.getCurso2();
		this.curso3 = profesor.getCurso3();
		this.curso4 = profesor.getCurso4();
		this.numDocPrf = profesor.getNumDocPrf();
		this.primApellPrf = profesor.getPrimApellPrf();
		this.primNombPrf = profesor.getPrimNombPrf();
		this.segApellPrf = profesor.getSegApellPrf();
		this.segNombPrf = profesor.getSegNombPrf();
		this.sexoPrf = profesor.getSexoPrf();
		this.status = profesor.getStatus();
		this.tipoDocPrf = profesor.getTipoDocPrf();
		this.codoperadorappalprf = arrOfStrTlfPpalPrf[0];
		this.textoTlfPpalPrf = arrOfStrTlfPpalPrf[1];
		this.codoperadorasecprf = arrOfStrTlfSecPrf[0];
		this.textoTlfSecPrf = arrOfStrTlfSecPrf[1];
		this.fechIngPrf = profesor.getFechIngPrf();
	}

	public Long getIdPrf() {
		return idPrf;
	}

	public void setIdPrf(Long idPrf) {
		this.idPrf = idPrf;
	}

	public String getAniosServPrf() {
		return aniosServPrf;
	}

	public void setAniosServPrf(String aniosServPrf) {
		this.aniosServPrf = aniosServPrf;
	}

	public String getCatPrf() {
		return catPrf;
	}

	public void setCatPrf(String catPrf) {
		this.catPrf = catPrf;
	}

	public String getTextoDirPpalPrf() {
		return textoDirPpalPrf;
	}

	public void setTextoDirPpalPrf(String textoDirPpalPrf) {
		this.textoDirPpalPrf = textoDirPpalPrf;
	}

	public String getEstadodirppalprf() {
		return estadodirppalprf;
	}

	public void setEstadodirppalprf(String estadodirppalprf) {
		this.estadodirppalprf = estadodirppalprf;
	}

	public String getMunicipiodirppalprf() {
		return municipiodirppalprf;
	}

	public void setMunicipiodirppalprf(String municipiodirppalprf) {
		this.municipiodirppalprf = municipiodirppalprf;
	}

	public String getCiudaddirppalprf() {
		return ciudaddirppalprf;
	}

	public void setCiudaddirppalprf(String ciudaddirppalprf) {
		this.ciudaddirppalprf = ciudaddirppalprf;
	}

	public String getParroquiadirppalprf() {
		return parroquiadirppalprf;
	}

	public void setParroquiadirppalprf(String parroquiadirppalprf) {
		this.parroquiadirppalprf = parroquiadirppalprf;
	}

	public String getCodpostaldirppalprf() {
		return codpostaldirppalprf;
	}

	public void setCodpostaldirppalprf(String codpostaldirppalprf) {
		this.codpostaldirppalprf = codpostaldirppalprf;
	}

	public String getTextoDirSecPrf() {
		return textoDirSecPrf;
	}

	public void setTextoDirSecPrf(String textoDirSecPrf) {
		this.textoDirSecPrf = textoDirSecPrf;
	}

	public String getEstadodirsecprf() {
		return estadodirsecprf;
	}

	public void setEstadodirsecprf(String estadodirsecprf) {
		this.estadodirsecprf = estadodirsecprf;
	}

	public String getMunicipiodirsecprf() {
		return municipiodirsecprf;
	}

	public void setMunicipiodirsecprf(String municipiodirsecprf) {
		this.municipiodirsecprf = municipiodirsecprf;
	}

	public String getCiudaddirsecprf() {
		return ciudaddirsecprf;
	}

	public void setCiudaddirsecprf(String ciudaddirsecprf) {
		this.ciudaddirsecprf = ciudaddirsecprf;
	}

	public String getParroquiadirsecprf() {
		return parroquiadirsecprf;
	}

	public void setParroquiadirsecprf(String parroquiadirsecprf) {
		this.parroquiadirsecprf = parroquiadirsecprf;
	}

	public String getCodpostaldirsecprf() {
		return codpostaldirsecprf;
	}

	public void setCodpostaldirsecprf(String codpostaldirsecprf) {
		this.codpostaldirsecprf = codpostaldirsecprf;
	}

	public String getEdadPrf() {
		return edadPrf;
	}

	public void setEdadPrf(String edadPrf) {
		this.edadPrf = edadPrf;
	}

	public String getEdoCivilPrf() {
		return edoCivilPrf;
	}

	public void setEdoCivilPrf(String edoCivilPrf) {
		this.edoCivilPrf = edoCivilPrf;
	}

	public String getEmailPrf() {
		return emailPrf;
	}

	public void setEmailPrf(String emailPrf) {
		this.emailPrf = emailPrf;
	}

	public Date getFechNacPrf() {
		return fechNacPrf;
	}

	public void setFechNacPrf(Date fechNacPrf) {
		this.fechNacPrf = fechNacPrf;
	}

	public String getGraduado() {
		return graduado;
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

	public String getEspecialidad1() {
		return especialidad1;
	}

	public void setEspecialidad1(String especialidad1) {
		this.especialidad1 = especialidad1;
	}

	public String getEspecialidad2() {
		return especialidad2;
	}

	public void setEspecialidad2(String especialidad2) {
		this.especialidad2 = especialidad2;
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

	public String getNumDocPrf() {
		return numDocPrf;
	}

	public void setNumDocPrf(String numDocPrf) {
		this.numDocPrf = numDocPrf;
	}

	public String getPrimApellPrf() {
		return primApellPrf;
	}

	public void setPrimApellPrf(String primApellPrf) {
		this.primApellPrf = primApellPrf;
	}

	public String getPrimNombPrf() {
		return primNombPrf;
	}

	public void setPrimNombPrf(String primNombPrf) {
		this.primNombPrf = primNombPrf;
	}

	public String getSegApellPrf() {
		return segApellPrf;
	}

	public void setSegApellPrf(String segApellPrf) {
		this.segApellPrf = segApellPrf;
	}

	public String getSegNombPrf() {
		return segNombPrf;
	}

	public void setSegNombPrf(String segNombPrf) {
		this.segNombPrf = segNombPrf;
	}

	public String getSexoPrf() {
		return sexoPrf;
	}

	public void setSexoPrf(String sexoPrf) {
		this.sexoPrf = sexoPrf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoDocPrf() {
		return tipoDocPrf;
	}

	public void setTipoDocPrf(String tipoDocPrf) {
		this.tipoDocPrf = tipoDocPrf;
	}

	public String getCodoperadorappalprf() {
		return codoperadorappalprf;
	}

	public void setCodoperadorappalprf(String codoperadorappalprf) {
		this.codoperadorappalprf = codoperadorappalprf;
	}

	public String getTextoTlfPpalPrf() {
		return textoTlfPpalPrf;
	}

	public void setTextoTlfPpalPrf(String textoTlfPpalPrf) {
		this.textoTlfPpalPrf = textoTlfPpalPrf;
	}

	public String getCodoperadorasecprf() {
		return codoperadorasecprf;
	}

	public void setCodoperadorasecprf(String codoperadorasecprf) {
		this.codoperadorasecprf = codoperadorasecprf;
	}

	public String getTextoTlfSecPrf() {
		return textoTlfSecPrf;
	}

	public void setTextoTlfSecPrf(String textoTlfSecPrf) {
		this.textoTlfSecPrf = textoTlfSecPrf;
	}

	public Date getFechIngPrf() {
		return fechIngPrf;
	}

	public void setFechIngPrf(Date fechIngPrf) {
		this.fechIngPrf = fechIngPrf;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
