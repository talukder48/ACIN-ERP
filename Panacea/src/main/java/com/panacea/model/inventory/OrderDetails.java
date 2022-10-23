package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.OrderDetailsId;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name="IN_ORDER_DETAILS")
@IdClass(OrderDetailsId.class)
public class OrderDetails {
	@Id
	@Column(name="OrderId",length=16)
	private String OrderId;
	@Id
	@Column(name = "ProductCode", length = 10)
	private String ProductCode;
	@Column(name = "ProductName", length = 100)
	private String ProductName;
	@Column(name = "NoOfItem", length = 8)
	private int NoOfItem;
	@Column(name = "OrderedNoOfItem", length = 8)
	private int OrderedNoOfItem;
	@Column(name = "unitPrice", columnDefinition = "Decimal(12,2)")
	private double unitPrice;
	@Column(name = "discount", columnDefinition = "Decimal(4,2)")
	private double discount;
	@Column(name = "actualUnitPrice", columnDefinition = "Decimal(12,2)")
	private double actualUnitPrice;
	@Column(name = "totalAmount", columnDefinition = "Decimal(18,2)")
	private double totalAmount;
	@Column(name = "Status", length = 20)
	private String Status;
	

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getOrderedNoOfItem() {
		return OrderedNoOfItem;
	}
	public void setOrderedNoOfItem(int orderedNoOfItem) {
		OrderedNoOfItem = orderedNoOfItem;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getActualUnitPrice() {
		return actualUnitPrice;
	}
	public void setActualUnitPrice(double actualUnitPrice) {
		this.actualUnitPrice = actualUnitPrice;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
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
	
	public OrderDetails(String orderId, String productCode, String productName, int noOfItem, int orderedNoOfItem,
			double unitPrice, double discount, double actualUnitPrice, double totalAmount, String status) {
		super();
		OrderId = orderId;
		ProductCode = productCode;
		ProductName = productName;
		NoOfItem = noOfItem;
		OrderedNoOfItem = orderedNoOfItem;
		this.unitPrice = unitPrice;
		this.discount = discount;
		this.actualUnitPrice = actualUnitPrice;
		this.totalAmount = totalAmount;
		Status = status;
	}
	
	
	
}
