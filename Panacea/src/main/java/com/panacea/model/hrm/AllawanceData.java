package com.panacea.model.hrm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HR_ALLAWANCE")
public class AllawanceData {
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

	public String getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
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

	public AllawanceData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AllawanceData(String employeeId, double basicSalary, double houseRent, double conveyanceAllaw,
			double variablePay, double medicalAllaw, double specialAllaw, double othersAllaw) {
		super();
		EmployeeId = employeeId;
		this.basicSalary = basicSalary;
		this.houseRent = houseRent;
		this.conveyanceAllaw = conveyanceAllaw;
		this.variablePay = variablePay;
		this.medicalAllaw = medicalAllaw;
		this.specialAllaw = specialAllaw;
		this.othersAllaw = othersAllaw;
	}

}
