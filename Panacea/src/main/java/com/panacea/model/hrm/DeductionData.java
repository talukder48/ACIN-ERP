package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "HR_DEDUCTION")
public class DeductionData {
	@Id
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	@Column(name = "providentFund", columnDefinition = "Decimal(12,2)")
	private double providentFund;
	@Column(name = "providentFundPct", columnDefinition = "Decimal(4,2)")
	private double providentFundPct;
	@Column(name = "incomeTax", columnDefinition = "Decimal(12,2)")
	private double incomeTax;
	@Column(name = "loanRepayment", columnDefinition = "Decimal(12,2)")
	private double loanRepayment;
	@Column(name = "Revenue", columnDefinition = "Decimal(12,2)")
	private double Revenue;
	@Column(name = "OtherDed", columnDefinition = "Decimal(12,2)")
	private double OtherDed;
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public double getProvidentFund() {
		return providentFund;
	}
	public void setProvidentFund(double providentFund) {
		this.providentFund = providentFund;
	}
	public double getProvidentFundPct() {
		return providentFundPct;
	}
	public void setProvidentFundPct(double providentFundPct) {
		this.providentFundPct = providentFundPct;
	}
	public double getIncomeTax() {
		return incomeTax;
	}
	public void setIncomeTax(double incomeTax) {
		this.incomeTax = incomeTax;
	}
	public double getLoanRepayment() {
		return loanRepayment;
	}
	public void setLoanRepayment(double loanRepayment) {
		this.loanRepayment = loanRepayment;
	}
	public double getRevenue() {
		return Revenue;
	}
	public void setRevenue(double revenue) {
		Revenue = revenue;
	}
	public double getOtherDed() {
		return OtherDed;
	}
	public void setOtherDed(double otherDed) {
		OtherDed = otherDed;
	}
	public DeductionData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeductionData(String employeeId, double providentFund, double providentFundPct, double incomeTax,
			double loanRepayment, double revenue, double otherDed) {
		super();
		EmployeeId = employeeId;
		this.providentFund = providentFund;
		this.providentFundPct = providentFundPct;
		this.incomeTax = incomeTax;
		this.loanRepayment = loanRepayment;
		Revenue = revenue;
		OtherDed = otherDed;
	}
	
}
