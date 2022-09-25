package com.panacea.model.inventory;

public class Disburse {
	private String Branch;
	private int ProductCode;
	private String date;
	private int disbursesl;
	private String productName;
	private String disburseType;
	private int pices;
	private double amount; 
	private String disburseTo;
	private String remarks;
	public Disburse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Disburse(String branch, int productCode, String date, int disbursesl, String productName,
			String disburseType, int pices, double amount, String disburseTo, String remarks) {
		super();
		Branch = branch;
		ProductCode = productCode;
		this.date = date;
		this.disbursesl = disbursesl;
		this.productName = productName;
		this.disburseType = disburseType;
		this.pices = pices;
		this.amount = amount;
		this.disburseTo = disburseTo;
		this.remarks = remarks;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public int getProductCode() {
		return ProductCode;
	}
	public void setProductCode(int productCode) {
		ProductCode = productCode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDisbursesl() {
		return disbursesl;
	}
	public void setDisbursesl(int disbursesl) {
		this.disbursesl = disbursesl;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDisburseType() {
		return disburseType;
	}
	public void setDisburseType(String disburseType) {
		this.disburseType = disburseType;
	}
	public int getPices() {
		return pices;
	}
	public void setPices(int pices) {
		this.pices = pices;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDisburseTo() {
		return disburseTo;
	}
	public void setDisburseTo(String disburseTo) {
		this.disburseTo = disburseTo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

}
