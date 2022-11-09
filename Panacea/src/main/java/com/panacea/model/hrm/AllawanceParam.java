package com.panacea.model.hrm;

public class AllawanceParam {
private String allwanceCode;
private String allwanceDescription;
private String remarks;
public String getAllwanceCode() {
	return allwanceCode;
}
public void setAllwanceCode(String allwanceCode) {
	this.allwanceCode = allwanceCode;
}
public String getAllwanceDescription() {
	return allwanceDescription;
}
public void setAllwanceDescription(String allwanceDescription) {
	this.allwanceDescription = allwanceDescription;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public AllawanceParam() {
	super();
	// TODO Auto-generated constructor stub
}
public AllawanceParam(String allwanceCode, String allwanceDescription, String remarks) {
	super();
	this.allwanceCode = allwanceCode;
	this.allwanceDescription = allwanceDescription;
	this.remarks = remarks;
}

}
