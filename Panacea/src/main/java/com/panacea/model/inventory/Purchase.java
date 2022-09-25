package com.panacea.model.inventory;

public class Purchase {
	private String Branch;
	private int productId;
	private String date;
	private int purchaseSl;
	private String productName;
	private int pices;
	private double amount;

	public Purchase(String branch, int productId, String date, int purchaseSl, String productName, int pices,
			double amount) {
		super();
		Branch = branch;
		this.productId = productId;
		this.date = date;
		this.purchaseSl = purchaseSl;
		this.productName = productName;
		this.pices = pices;
		this.amount = amount;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPurchaseSl() {
		return purchaseSl;
	}

	public void setPurchaseSl(int purchaseSl) {
		this.purchaseSl = purchaseSl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	@Override
	public String toString() {
		return "Purchase [Branch=" + Branch + ", productId=" + productId + ", date=" + date + ", purchaseSl="
				+ purchaseSl + ", productName=" + productName + ", pices=" + pices + ", amount=" + amount + "]";
	}

}
