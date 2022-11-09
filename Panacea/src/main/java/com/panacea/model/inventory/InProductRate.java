package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IN_PRODUCT_RATE")
public class InProductRate {
	@Id
	@Column(name="ProductCode",length=10)
	private String ProductCode;
	@Column(name = "ProductName", length =100)
	private String ProductName;
	@Column(name="Rate",columnDefinition = "Decimal(18,2)")
	private Double Rate;
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
	public Double getRate() {
		return Rate;
	}
	public void setRate(Double rate) {
		Rate = rate;
	}
	public InProductRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InProductRate(String productCode, String productName, Double rate) {
		super();
		ProductCode = productCode;
		ProductName = productName;
		Rate = rate;
	}
	
}
