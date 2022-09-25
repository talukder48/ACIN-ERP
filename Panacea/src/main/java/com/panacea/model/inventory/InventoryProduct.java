package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IN_PRODUCT")
public class InventoryProduct {
	@Id
	@Column(name = "ProductCode", length =10)
	private String  ProductCode;
	@Column(name = "ProductName", length =100)
	private String ProductName;
	@Column(name = "ProductType", length =2)
	private String ProductType;
	@Column(name = "StockGL", length =12)
	private String StockGL;
	@Column(name = "PurchaseGL", length =12)
	private String PurchaseGL;
	@Column(name = "SaleGL", length =12)
	private String SaleGL;
	public InventoryProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InventoryProduct(String productCode, String productName, String productType, String stockGL, String purchaseGL,
			String saleGL) {
		super();
		ProductCode = productCode;
		ProductName = productName;
		ProductType = productType;
		StockGL = stockGL;
		PurchaseGL = purchaseGL;
		SaleGL = saleGL;
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
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public String getStockGL() {
		return StockGL;
	}
	public void setStockGL(String stockGL) {
		StockGL = stockGL;
	}
	public String getPurchaseGL() {
		return PurchaseGL;
	}
	public void setPurchaseGL(String purchaseGL) {
		PurchaseGL = purchaseGL;
	}
	public String getSaleGL() {
		return SaleGL;
	}
	public void setSaleGL(String saleGL) {
		SaleGL = saleGL;
	}
}
