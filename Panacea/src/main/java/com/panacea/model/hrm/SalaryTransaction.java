package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.SalaryTransactionId;

@Entity
@Table(name = "HR_SALARY_TRAN")
@IdClass(SalaryTransactionId.class)
public class SalaryTransaction {
	@Id
	@Column(name = "BranchCode", length = 10)
	private String BranchCode;
	@Id
	@Column(name = "year", length = 4)
	private int year;
	@Id
	@Column(name = "month", length = 2)
	private int month;
	@Id
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
	
	@Column(name = "Designation", length = 4)
	private String Designation;
	@Column(name = "bankAccount", length = 20)
	private String bankAccount;

	@Column(name = "basicSalary", columnDefinition = "Decimal(12,2)")
	private double basicSalary;
	@Column(name = "houseRent", columnDefinition = "Decimal(12,2)")
	private double houseRent;
	@Column(name = "conveyanceAllaw", columnDefinition = "Decimal(12,2)")
	private double conveyanceAllaw;
	@Column(name = "variablePay", columnDefinition = "Decimal(12,2)")
	private double variablePay;
	@Column(name = "medicalAllaw", columnDefinition = "Decimal(12,2)")
	private double medicalAllaw;
	@Column(name = "specialAllaw", columnDefinition = "Decimal(12,2)")
	private double specialAllaw;
	@Column(name = "othersAllaw", columnDefinition = "Decimal(12,2)")
	private double othersAllaw;
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
	@Column(name = "GrossPay", columnDefinition = "Decimal(18,2)")
	private double GrossPay;
	@Column(name = "TotalDeduction", columnDefinition = "Decimal(18,2)")
	private double TotalDeduction;
	@Column(name = "NetPayment", columnDefinition = "Decimal(18,2)")
	private double NetPayment;
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public double getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}
	public double getHouseRent() {
		return houseRent;
	}
	public void setHouseRent(double houseRent) {
		this.houseRent = houseRent;
	}
	public double getConveyanceAllaw() {
		return conveyanceAllaw;
	}
	public void setConveyanceAllaw(double conveyanceAllaw) {
		this.conveyanceAllaw = conveyanceAllaw;
	}
	public double getVariablePay() {
		return variablePay;
	}
	public void setVariablePay(double variablePay) {
		this.variablePay = variablePay;
	}
	public double getMedicalAllaw() {
		return medicalAllaw;
	}
	public void setMedicalAllaw(double medicalAllaw) {
		this.medicalAllaw = medicalAllaw;
	}
	public double getSpecialAllaw() {
		return specialAllaw;
	}
	public void setSpecialAllaw(double specialAllaw) {
		this.specialAllaw = specialAllaw;
	}
	public double getOthersAllaw() {
		return othersAllaw;
	}
	public void setOthersAllaw(double othersAllaw) {
		this.othersAllaw = othersAllaw;
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
	public double getGrossPay() {
		return GrossPay;
	}
	public void setGrossPay(double grossPay) {
		GrossPay = grossPay;
	}
	public double getTotalDeduction() {
		return TotalDeduction;
	}
	public void setTotalDeduction(double totalDeduction) {
		TotalDeduction = totalDeduction;
	}
	public double getNetPayment() {
		return NetPayment;
	}
	public void setNetPayment(double netPayment) {
		NetPayment = netPayment;
	}
	public SalaryTransaction(String branchCode, int year, int month, String employeeId, String designation,
			String bankAccount, double basicSalary, double houseRent, double conveyanceAllaw, double variablePay,
			double medicalAllaw, double specialAllaw, double othersAllaw, double providentFund, double providentFundPct,
			double incomeTax, double loanRepayment, double revenue, double otherDed, double grossPay,
			double totalDeduction, double netPayment) {
		super();
		BranchCode = branchCode;
		this.year = year;
		this.month = month;
		EmployeeId = employeeId;
		Designation = designation;
		this.bankAccount = bankAccount;
		this.basicSalary = basicSalary;
		this.houseRent = houseRent;
		this.conveyanceAllaw = conveyanceAllaw;
		this.variablePay = variablePay;
		this.medicalAllaw = medicalAllaw;
		this.specialAllaw = specialAllaw;
		this.othersAllaw = othersAllaw;
		this.providentFund = providentFund;
		this.providentFundPct = providentFundPct;
		this.incomeTax = incomeTax;
		this.loanRepayment = loanRepayment;
		Revenue = revenue;
		OtherDed = otherDed;
		GrossPay = grossPay;
		TotalDeduction = totalDeduction;
		NetPayment = netPayment;
	}
	public SalaryTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}	

}
