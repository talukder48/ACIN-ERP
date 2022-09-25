package com.panacea.model.acounting;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "AS_CHARGES")
public class Charges {
	@Id
	@Column(name="chgcode",length=4)
	private String chgcode;
	@Column(name="chgdescription",length=50)
	private String chgdescription;
	@Column(name="chgtype",length=2)
	private String chgtype;
	@Column(name="vatenable",length=2)
	private String vatenable;
	@Column(name="activation",length=2)
	private String activation;
	@Column(name="chgglcode",length=9)
	private String chgglcode;
	@Column(name="vatglcode",length=9)
	private String vatglcode;
	@Column(name="entyBy",length=20)
	private String entyBy;
	@Column(name="entyOn",length=20)
	private String entyOn;
	@Column(name="modBy",length=20)
	private String modBy;
	@Column(name="modOn",length=20)
	private String modOn;

	public Charges(String chgcode, String chgdescription, String chgtype, String vatenable, String activation,String chgglcode, String vatglcode) {
		super();
		this.chgcode = chgcode;
		this.chgdescription = chgdescription;
		this.chgtype = chgtype;
		this.vatenable = vatenable;
		this.activation = activation;
		this.chgglcode = chgglcode;
		this.vatglcode = vatglcode;
	}

	public Charges() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getChgcode() {
		return chgcode;
	}

	public void setChgcode(String chgcode) {
		this.chgcode = chgcode;
	}

	public String getChgdescription() {
		return chgdescription;
	}

	public void setChgdescription(String chgdescription) {
		this.chgdescription = chgdescription;
	}

	public String getChgtype() {
		return chgtype;
	}

	public void setChgtype(String chgtype) {
		this.chgtype = chgtype;
	}

	public String getVatenable() {
		return vatenable;
	}

	public void setVatenable(String vatenable) {
		this.vatenable = vatenable;
	}

	public String getActivation() {
		return activation;
	}

	public void setActivation(String activation) {
		this.activation = activation;
	}

	public String getChgglcode() {
		return chgglcode;
	}

	public void setChgglcode(String chgglcode) {
		this.chgglcode = chgglcode;
	}

	public String getVatglcode() {
		return vatglcode;
	}

	public void setVatglcode(String vatglcode) {
		this.vatglcode = vatglcode;
	}

	public String getEntyBy() {
		return entyBy;
	}

	public void setEntyBy(String entyBy) {
		this.entyBy = entyBy;
	}

	public String getEntyOn() {
		return entyOn;
	}

	public void setEntyOn(String entyOn) {
		this.entyOn = entyOn;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public String getModOn() {
		return modOn;
	}

	public void setModOn(String modOn) {
		this.modOn = modOn;
	}

	
}
