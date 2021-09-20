package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profesiones")
public class Profesion implements Serializable {

	/**
	 * 
	 */
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="PROFESION")
	private String profesion;
	
	
	
	public Profesion() {
	
		
	}
	
	
	
	
	
	public Profesion(Long id, String profesion) {
	
		this.id = id;
		this.profesion = profesion;
	}








	public Long getId() {
		return id;
	}








	public void setId(Long id) {
		this.id = id;
	}








	public String getProfesion() {
		return profesion;
	}








	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}








	public static long getSerialversionuid() {
		return serialVersionUID;
	}








	private static final long serialVersionUID = 1L;

}
