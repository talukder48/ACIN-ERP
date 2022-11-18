package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_SALARY_TRAN")
public class SalaryTransaction {
	@Id
	@Column(name = "EmployeeId", length = 20)
	private String EmployeeId;
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

}
