package com.panacea.model.acounting;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "AS_PRODUCT")
public class ProductParam {
	@Id
	@Column(name="productCode",length=10)
	private String productCode;
	@Column(name="productName",length=100)
	private String productName;
	@Column(name="ProductType",length=2)
	private String ProductType;
	@Column(name="activation",length=2)
	private String activation;
	@Column(name="entyBy",length=20)
	private String entyBy;
	@Column(name="entyOn",length=20)
	private String entyOn;
	@Column(name="modBy",length=20)
	private String modBy;
	@Column(name="modOn",length=20)
	private String modOn;
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return ProductType;
	}
	public void setProductType(String productType) {
		ProductType = productType;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public String getEntyBy() {
		return entyBy;
	}
	public void setEntyBy(String entyBy) {
		this.entyBy = entyBy;
	}
	public String getEntyOn() {
		return entyOn;
	}
	public void setEntyOn(String entyOn) {
		this.entyOn = entyOn;
	}
	public String getModBy() {
		return modBy;
	}
	public void setModBy(String modBy) {
		this.modBy = modBy;
	}
	public String getModOn() {
		return modOn;
	}
	public void setModOn(String modOn) {
		this.modOn = modOn;
	}
	
	public ProductParam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductParam(String productCode, String productName, String productType, String activation) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.ProductType = productType;
		this.activation = activation;
	}
	
}
