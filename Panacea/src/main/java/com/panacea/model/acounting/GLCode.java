package com.panacea.model.acounting;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AS_GLCODE")
public class GLCode {
	@Id
	@Column(name="glCode",length=9)
	private String glCode;
	@Column(name="glName",length=100)
	private String glName;
	@Column(name="glType",length=2)
	private String glType;
	@Column(name="glLevel",length=2)
	private String glLevel;
	@Column(name="primeGL",length=9)
	private String primeGL;
	public GLCode() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getGlCode() {
		return glCode;
	}
	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}
	public String getGlName() {
		return glName;
	}
	public void setGlName(String glName) {
		this.glName = glName;
	}
	public String getGlType() {
		return glType;
	}
	public void setGlType(String glType) {
		this.glType = glType;
	}
	public String getGlLevel() {
		return glLevel;
	}
	public void setGlLevel(String glLevel) {
		this.glLevel = glLevel;
	}
	public String getPrimeGL() {
		return primeGL;
	}
	public void setPrimeGL(String primeGL) {
		this.primeGL = primeGL;
	}
	public GLCode(String glCode, String glName, String glType, String glLevel, String primeGL) {
		super();
		this.glCode = glCode;
		this.glName = glName;
		this.glType = glType;
		this.glLevel = glLevel;
		this.primeGL = primeGL;
	}
	
}
