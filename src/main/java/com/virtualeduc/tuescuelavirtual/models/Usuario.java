package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30, unique = true)
	private String username;

	@Column(length = 60)
	private String password;
	
	private Boolean enabled;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 50)
	private String correo;
	
	
	@Column(length = 100)
	private String clave1;
	
	
	@Column(length = 100)
	private String clave2;
	
	
	
	@Column(length = 100)
	private String clave3;
	
	
	@Column(length = 100)
	private String clave4;
	
	
	@Column(length = 100)
	private String clave5;
	
	
//	@Column(length = 10)
//	private String cedula;
        
        @Column(length = 8)
	private String nrodoc;
        
        @Column(length = 1)
	private String tipodoc;
	
	@Column(length = 20)
	private String tipousuario;
        
	@Column(name="fecha_hora_ult_ingreso")
	private Date fechaHoraUltIngreso;
	
	@Column(name="fecha_hora_act_clave")
	private Date fechaHoraActClave;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave1() {
		return clave1;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}

	public String getClave2() {
		return clave2;
	}

	public void setClave2(String clave2) {
		this.clave2 = clave2;
	}

	public String getClave3() {
		return clave3;
	}

	public void setClave3(String clave3) {
		this.clave3 = clave3;
	}

	public String getClave4() {
		return clave4;
	}

	public void setClave4(String clave4) {
		this.clave4 = clave4;
	}

	public String getClave5() {
		return clave5;
	}

	public void setClave5(String clave5) {
		this.clave5 = clave5;
	}

    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }
    
    
        
        

//	public String getCedula() {
//		return cedula;
//	}
//
//	public void setCedula(String cedula) {
//		this.cedula = cedula;
//	}

	public Date getFechaHoraUltIngreso() {
		return fechaHoraUltIngreso;
	}

	public void setFechaHoraUltIngreso(Date fechaHoraUltIngreso) {
		this.fechaHoraUltIngreso = fechaHoraUltIngreso;
	}

	public Date getFechaHoraActClave() {
		return fechaHoraActClave;
	}

	public void setFechaHoraActClave(Date fechaHoraActClave) {
		this.fechaHoraActClave = fechaHoraActClave;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
