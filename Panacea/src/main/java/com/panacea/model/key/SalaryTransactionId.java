package com.panacea.model.key;

import java.io.Serializable;

public class SalaryTransactionId implements Serializable {
	private String BranchCode;
	private int year;
	private int month;
	private String EmployeeId;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BranchCode == null) ? 0 : BranchCode.hashCode());
		result = prime * result + ((EmployeeId == null) ? 0 : EmployeeId.hashCode());
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryTransactionId other = (SalaryTransactionId) obj;
		if (BranchCode == null) {
			if (other.BranchCode != null)
				return false;
		} else if (!BranchCode.equals(other.BranchCode))
			return false;
		if (EmployeeId == null) {
			if (other.EmployeeId != null)
				return false;
		} else if (!EmployeeId.equals(other.EmployeeId))
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	public SalaryTransactionId(String branchCode, int year, int month, String employeeId) {
		super();
		BranchCode = branchCode;
		this.year = year;
		this.month = month;
		EmployeeId = employeeId;
	}
	public SalaryTransactionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
