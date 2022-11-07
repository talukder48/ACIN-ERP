package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.InProductCountId;

@Entity
@Table(name = "IN_PRODUCT_STATUS")
@IdClass(InProductCountId.class)
public class InProductCount {
	@Id
	@Column(name="BranchCode",length=8)
	private String BranchCode;
	@Id
	@Column(name="ProductCode",length=10)
	private String ProductCode;
	@Column(name="ProductCount",length=12)
	private int ProductCount;
	public InProductCount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InProductCount(String branchCode, String productCode, int productCount) {
		super();
		BranchCode = branchCode;
		ProductCode = productCode;
		ProductCount = productCount;
	}
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public int getProductCount() {
		return ProductCount;
	}
	public void setProductCount(int productCount) {
		ProductCount = productCount;
	}
	
	
}
