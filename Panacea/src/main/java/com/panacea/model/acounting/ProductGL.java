package com.panacea.model.acounting;

import java.sql.Date;

public class ProductGL {
	private String productCode;
	private String glcode;
	private String remarks;
	private String entyBy;
	private Date entyOn;
	private String modBy;
	private Date modOn;

	public ProductGL(String productCode, String glcode, String remarks) {
		super();
		this.productCode = productCode;
		this.glcode = glcode;
		this.remarks = remarks;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getGlcode() {
		return glcode;
	}

	public void setGlcode(String glcode) {
		this.glcode = glcode;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEntyBy() {
		return entyBy;
	}

	public void setEntyBy(String entyBy) {
		this.entyBy = entyBy;
	}

	public Date getEntyOn() {
		return entyOn;
	}

	public void setEntyOn(Date entyOn) {
		this.entyOn = entyOn;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

}
