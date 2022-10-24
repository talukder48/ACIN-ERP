package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.PurchaseDetailsId;

@Entity
@Table(name="IN_PURCHASE_DETAILS")
@IdClass(PurchaseDetailsId.class)
public class PurchaseDetails {
	@Id
	@Column(name = "PurchaseId", length = 20)
	private String PurchaseId;
	@Id
	@Column(name = "ProductCode", length = 10)
	private String ProductCode;
	@Column(name = "ProductName", length = 100)
	private String ProductName;
	@Column(name = "NoOfItem", length = 8)
	private int NoOfItem;
	@Column(name = "UnitPrice", columnDefinition = "Decimal(12,2)")
	private double UnitPrice;
	@Column(name = "Amount", columnDefinition = "Decimal(18,2)")
	private double Amount;
	public String getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		PurchaseId = purchaseId;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getNoOfItem() {
		return NoOfItem;
	}
	public void setNoOfItem(int noOfItem) {
		NoOfItem = noOfItem;
	}
	public double getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public PurchaseDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseDetails(String purchaseId, String productCode, String productName, int noOfItem, double unitPrice,
			double amount) {
		super();
		PurchaseId = purchaseId;
		ProductCode = productCode;
		ProductName = productName;
		NoOfItem = noOfItem;
		UnitPrice = unitPrice;
		Amount = amount;
	}
	
	

}
