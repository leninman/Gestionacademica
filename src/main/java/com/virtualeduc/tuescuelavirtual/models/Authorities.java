package com.virtualeduc.tuescuelavirtual.models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the authorities database table.
 * 
 */
@Entity
@NamedQuery(name="Authorities.findAll", query="SELECT a FROM Authorities a")
public class Authorities implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String authority;

	@Column(name="user_id")
	private java.math.BigInteger userId;

	public Authorities() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthority() {
		return this.authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public java.math.BigInteger getUserId() {
		return this.userId;
	}

	public void setUserId(java.math.BigInteger userId) {
		this.userId = userId;
	}

}