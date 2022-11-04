package com.panacea.model.acounting;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.GLBalanceId;

@Entity
@Table(name = "AS_GLBALANCE")
@IdClass(GLBalanceId.class)
public class GLBalance {
	@Id
	@Column(name="BranchCode",length=8)
	private String BranchCode;
	@Id
	@Column(name="glCode",length=9)
	private String glCode;
	@Column(name="glBalance",columnDefinition = "Decimal(18,2)")
	private Double glBalance;	
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public String getGlCode() {
		return glCode;
	}
	public void setGlCode(String glCode) {
		this.glCode = glCode;
	}
	public Double getGlBalance() {
		return glBalance;
	}
	public void setGlBalance(Double glBalance) {
		this.glBalance = glBalance;
	}
	public GLBalance(String branchCode, String glCode, Double glBalance) {
		super();
		BranchCode = branchCode;
		this.glCode = glCode;
		this.glBalance = glBalance;
	}
	public GLBalance() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
