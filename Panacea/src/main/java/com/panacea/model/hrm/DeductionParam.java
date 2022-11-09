package com.panacea.model.hrm;

public class DeductionParam {
private String dedCode;
private String dedDescription;
private String remaks;
public String getDedCode() {
	return dedCode;
}
public void setDedCode(String dedCode) {
	this.dedCode = dedCode;
}
public String getDedDescription() {
	return dedDescription;
}
public void setDedDescription(String dedDescription) {
	this.dedDescription = dedDescription;
}
public String getRemaks() {
	return remaks;
}
public void setRemaks(String remaks) {
	this.remaks = remaks;
}
public DeductionParam() {
	super();
	// TODO Auto-generated constructor stub
}
public DeductionParam(String dedCode, String dedDescription, String remaks) {
	super();
	this.dedCode = dedCode;
	this.dedDescription = dedDescription;
	this.remaks = remaks;
}

}
