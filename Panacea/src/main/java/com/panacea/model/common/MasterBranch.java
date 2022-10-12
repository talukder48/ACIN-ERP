package com.panacea.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MasterBranch")
public class MasterBranch {
	
	@Id
	@Column(name="BranchCode",length=6)
	private String BranchCode;
	@Column(name="BranchName",length=50)
	private String BranchName;
	@Column(name="BranchAddress",length=100)
	private String BranchAddress;
	@Column(name="BranchType",length=2)
	private String BranchType;
	@Column(name="BranchEmail",length=50)
	private String BranchEmail;
	@Column(name="BranchMobile",length=20)
	private String BranchMobile;
	@Column(name="Remarks",length=200)
	private String Remarks;
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public String getBranchName() {
		return BranchName;
	}
	public void setBranchName(String branchName) {
		BranchName = branchName;
	}
	public String getBranchAddress() {
		return BranchAddress;
	}
	public void setBranchAddress(String branchAddress) {
		BranchAddress = branchAddress;
	}
	public String getBranchType() {
		return BranchType;
	}
	public void setBranchType(String branchType) {
		BranchType = branchType;
	}
	public String getBranchEmail() {
		return BranchEmail;
	}
	public void setBranchEmail(String branchEmail) {
		BranchEmail = branchEmail;
	}
	public String getBranchMobile() {
		return BranchMobile;
	}
	public void setBranchMobile(String branchMobile) {
		BranchMobile = branchMobile;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public MasterBranch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MasterBranch(String branchCode, String branchName, String branchAddress, String branchType,
			String branchEmail, String branchMobile, String remarks) {
		super();
		BranchCode = branchCode;
		BranchName = branchName;
		BranchAddress = branchAddress;
		BranchType = branchType;
		BranchEmail = branchEmail;
		BranchMobile = branchMobile;
		Remarks = remarks;
	}
	

}
