/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.virtualeduc.tuescuelavirtual.models;

import com.virtualeduc.tuescuelavirtual.models.DTOS.AlumnoDTO;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenin
 */
@Entity
@Table(name = "representantes")
public class Representante implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_RPR")
	private Long idRpr;

	@Basic(optional = false)
	@Column(name = "TIPO_DOC_RPR")
	private String tipoDocRpr;

	@Basic(optional = false)
	@Column(name = "NUM_DOC_RPR")
	private String numDocRpr;

	@Basic(optional = false)
	@Column(name = "PRIM_NOMB_RPR")
	private String primNombRpr;

	@Column(name = "SEG_NOMB_RPR")
	private String segNombRpr;

	@Basic(optional = false)
	@Column(name = "PRIM_APELL_RPR")
	private String primApellRpr;

	@Column(name = "SEG_APELL_RPR")
	private String segApellRpr;

	@Basic(optional = false)
	@Column(name = "SEXO_RPR")
	private String sexoRpr;

	@Basic(optional = false)
	@Column(name = "FECH_NAC_RPR")
	@Temporal(TemporalType.DATE)
	private Date fechNacRpr;

	@Basic(optional = false)
	@Column(name = "EDAD_RPR")
	private String edadRpr;

	@Basic(optional = false)
	@Column(name = "EDO_CIV_RPR")
	private String edoCivRpr;

	

	@Basic(optional = false)
	@Column(name = "DIR_PPAL_RPR")
	private String dirPpalRpr;

	@Basic(optional = false)
	@Column(name = "DIR_SEC_RPR")
	private String dirSecRpr;

	@Basic(optional = false)
	@Column(name = "TLF_PPAL_RPR")
	private String tlfPpalRpr;

	@Basic(optional = false)
	@Column(name = "TLF_SEC_RPR")
	private String tlfSecRpr;

	@Basic(optional = false)
	@Column(name = "EMAIL_RPR")
	private String emailRpr;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRpr1")
	private Collection<Alumno> alumnoCollection;

	@OneToMany(mappedBy = "idRpr2")
	private Collection<Alumno> alumnoCollection1;

	public Representante() {
	}

	public Representante(Long idRpr) {
		this.idRpr = idRpr;
	}



	public Representante setRepresentante1(AlumnoDTO alumnoDTO) {
		Representante rep = new Representante();
		rep.setTipoDocRpr(alumnoDTO.getTipoDocRep1());
		rep.setNumDocRpr(alumnoDTO.getNumDocRep1());
		rep.setPrimNombRpr(alumnoDTO.getPrimNombRpr1());
		rep.setSegNombRpr(alumnoDTO.getSegNombRpr1());
		rep.setPrimApellRpr(alumnoDTO.getPrimApellRpr1());
		rep.setSegApellRpr(alumnoDTO.getSegApellRpr1());

		rep.setSexoRpr(alumnoDTO.getSexoRpr1());
		rep.setFechNacRpr(alumnoDTO.getFechNacRpr1());

		rep.setEdadRpr(alumnoDTO.getEdadRpr1());
		rep.setEdoCivRpr(alumnoDTO.getEdoCivRpr1());
		//rep.setParentescoRpr(alumnoDTO.getParentescoRpr1());

		rep.setDirPpalRpr(alumnoDTO.getTextoDirPpalRpr1().concat(",").concat(alumnoDTO.getEstadodirppalrep1())
				.concat(",").concat(alumnoDTO.getMunicipiodirppalrep1()).concat(",")
				.concat(alumnoDTO.getCiudaddirppalrep1()).concat(",").concat(alumnoDTO.getParroquiadirppalrep1())
				.concat(",").concat(alumnoDTO.getCodpostaldirppalrep1()));

		if ((alumnoDTO.getTextoDirSecRpr1() != "" || alumnoDTO.getTextoDirSecRpr1() != null)
				&& alumnoDTO.getEstadodirsecrep1() != null && alumnoDTO.getMunicipiodirsecrep1() != null
				&& alumnoDTO.getCiudaddirsecrep1() != null && alumnoDTO.getParroquiadirsecrep1() != null) {
			rep.setDirSecRpr(alumnoDTO.getTextoDirSecRpr1().concat(",").concat(alumnoDTO.getEstadodirsecrep1())
					.concat(",").concat(alumnoDTO.getMunicipiodirsecrep1()).concat(",")
					.concat(alumnoDTO.getCiudaddirsecrep1()).concat(",").concat(alumnoDTO.getParroquiadirsecrep1())
					.concat(",").concat(alumnoDTO.getCodpostaldirsecrep1()));
		} else {
			rep.setDirSecRpr(rep.getDirPpalRpr());
		}

		rep.setTlfPpalRpr(alumnoDTO.getCodoperadorappalrep1().concat("-").concat(alumnoDTO.getTextoTlfPpalRpr1()));

		if (alumnoDTO.getCodoperadorasecrep1() != null
				&& alumnoDTO.getTextoTlfSecRpr1() != "") {
			rep.setTlfSecRpr(alumnoDTO.getCodoperadorasecrep1().concat("-").concat(alumnoDTO.getTextoTlfSecRpr1()));
		} else {
			rep.setTlfSecRpr(rep.getTlfPpalRpr());
		}

		rep.setEmailRpr(alumnoDTO.getEmailRpr1());

		return rep;

	}

	public Representante setRepresentante2(AlumnoDTO alumnoDTO) {
		Representante rep = new Representante();
		rep.setTipoDocRpr(alumnoDTO.getTipoDocRep2());
		rep.setNumDocRpr(alumnoDTO.getNumDocRep2());
		rep.setPrimNombRpr(alumnoDTO.getPrimNombRpr2());
		rep.setSegNombRpr(alumnoDTO.getSegNombRpr2());
		rep.setPrimApellRpr(alumnoDTO.getPrimApellRpr2());
		rep.setSegApellRpr(alumnoDTO.getSegApellRpr2());

		rep.setSexoRpr(alumnoDTO.getSexoRpr2());
		rep.setFechNacRpr(alumnoDTO.getFechNacRpr2());

		rep.setEdadRpr(alumnoDTO.getEdadRpr2());
		rep.setEdoCivRpr(alumnoDTO.getEdoCivRpr2());
		//rep.setParentescoRpr(alumnoDTO.getParentescoRpr2());

		rep.setDirPpalRpr(alumnoDTO.getTextoDirPpalRpr2().concat(",").concat(alumnoDTO.getEstadodirppalrep2())
				.concat(",").concat(alumnoDTO.getMunicipiodirppalrep2()).concat(",")
				.concat(alumnoDTO.getCiudaddirppalrep2()).concat(",").concat(alumnoDTO.getParroquiadirppalrep2())
				.concat(",").concat(alumnoDTO.getCodpostaldirppalrep2()));

		if ((alumnoDTO.getTextoDirSecRpr2() != "" || alumnoDTO.getTextoDirSecRpr2() != null)
				&& alumnoDTO.getEstadodirsecrep2() != null && alumnoDTO.getMunicipiodirsecrep2() != null
				&& alumnoDTO.getCiudaddirsecrep2() != null && (alumnoDTO.getParroquiadirsecrep2() != null)
				&& alumnoDTO.getCodpostaldirsecrep2() != null) {
			rep.setDirSecRpr(alumnoDTO.getTextoDirSecRpr2().concat(",").concat(alumnoDTO.getEstadodirsecrep2())
					.concat(",").concat(alumnoDTO.getMunicipiodirsecrep2()).concat(",")
					.concat(alumnoDTO.getCiudaddirsecrep2()).concat(",").concat(alumnoDTO.getParroquiadirsecrep2())
					.concat(",").concat(alumnoDTO.getCodpostaldirsecrep2()));
		} else {
			rep.setDirSecRpr(rep.getDirPpalRpr());
		}

		rep.setTlfPpalRpr(alumnoDTO.getCodoperadorappalrep2().concat("-").concat(alumnoDTO.getTextoTlfPpalRpr2()));

		if (alumnoDTO.getCodoperadorasecrep2() != null
				&& (alumnoDTO.getTextoTlfSecRpr2() != "" || alumnoDTO.getTextoTlfSecRpr2() != null)) {
			rep.setTlfSecRpr(alumnoDTO.getCodoperadorasecrep2().concat("-").concat(alumnoDTO.getTextoTlfSecRpr2()));
		} else {
			rep.setTlfSecRpr(rep.getTlfPpalRpr());
		}

		rep.setEmailRpr(alumnoDTO.getEmailRpr2());

		return rep;

	}

	public Long getIdRpr() {
		return idRpr;
	}

	public void setIdRpr(Long idRpr) {
		this.idRpr = idRpr;
	}

	public String getTipoDocRpr() {
		return tipoDocRpr;
	}

	public void setTipoDocRpr(String tipoDocRpr) {
		this.tipoDocRpr = tipoDocRpr;
	}

	public String getNumDocRpr() {
		return numDocRpr;
	}

	public void setNumDocRpr(String numDocRpr) {
		this.numDocRpr = numDocRpr;
	}

	public String getPrimNombRpr() {
		return primNombRpr;
	}

	public void setPrimNombRpr(String primNombRpr) {
		this.primNombRpr = primNombRpr;
	}

	public String getSegNombRpr() {
		return segNombRpr;
	}

	public void setSegNombRpr(String segNombRpr) {
		this.segNombRpr = segNombRpr;
	}

	public String getPrimApellRpr() {
		return primApellRpr;
	}

	public void setPrimApellRpr(String primApellRpr) {
		this.primApellRpr = primApellRpr;
	}

	public String getSegApellRpr() {
		return segApellRpr;
	}

	public void setSegApellRpr(String segApellRpr) {
		this.segApellRpr = segApellRpr;
	}

	public String getSexoRpr() {
		return sexoRpr;
	}

	public void setSexoRpr(String sexoRpr) {
		this.sexoRpr = sexoRpr;
	}

	public Date getFechNacRpr() {
		return fechNacRpr;
	}

	public void setFechNacRpr(Date fechNacRpr) {
		this.fechNacRpr = fechNacRpr;
	}

	public String getEdadRpr() {
		return edadRpr;
	}

	public void setEdadRpr(String edadRpr) {
		this.edadRpr = edadRpr;
	}

	public String getEdoCivRpr() {
		return edoCivRpr;
	}

	public void setEdoCivRpr(String edoCivRpr) {
		this.edoCivRpr = edoCivRpr;
	}

	

	public String getDirPpalRpr() {
		return dirPpalRpr;
	}

	public void setDirPpalRpr(String dirPpalRpr) {
		this.dirPpalRpr = dirPpalRpr;
	}

	public String getDirSecRpr() {
		return dirSecRpr;
	}

	public void setDirSecRpr(String dirSecRpr) {
		this.dirSecRpr = dirSecRpr;
	}

	public String getTlfPpalRpr() {
		return tlfPpalRpr;
	}

	public void setTlfPpalRpr(String tlfPpalRpr) {
		this.tlfPpalRpr = tlfPpalRpr;
	}

	public String getTlfSecRpr() {
		return tlfSecRpr;
	}

	public void setTlfSecRpr(String tlfSecRpr) {
		this.tlfSecRpr = tlfSecRpr;
	}

	public String getEmailRpr() {
		return emailRpr;
	}

	public void setEmailRpr(String emailRpr) {
		this.emailRpr = emailRpr;
	}

	@XmlTransient
	public Collection<Alumno> getAlumnoCollection() {
		return alumnoCollection;
	}

	public void setAlumnoCollection(Collection<Alumno> alumnoCollection) {
		this.alumnoCollection = alumnoCollection;
	}

	@XmlTransient
	public Collection<Alumno> getAlumnoCollection1() {
		return alumnoCollection1;
	}

	public void setAlumnoCollection1(Collection<Alumno> alumnoCollection1) {
		this.alumnoCollection1 = alumnoCollection1;
	}
}
