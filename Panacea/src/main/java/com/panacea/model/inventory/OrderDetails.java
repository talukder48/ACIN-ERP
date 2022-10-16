package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IN_ORDER_DETAILS")
public class OrderDetails {
	@Id
	@Column(name="OrderId",length=16)
	private String OrderId;
	@Column(name = "ProductCode", length = 10)
	private String ProductCode;
	@Column(name = "ProductName", length = 100)
	private String ProductName;
	@Column(name = "NoOfItem", length = 8)
	private int NoOfItem;
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
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
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(String orderId, String productCode, String productName, int noOfItem) {
		super();
		OrderId = orderId;
		ProductCode = productCode;
		ProductName = productName;
		NoOfItem = noOfItem;
	}
	
	
}
