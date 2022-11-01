package com.panacea.model.key;

import java.io.Serializable;
import java.util.Objects;


public class InvoiceOrderDetailsId implements Serializable {
	private String OrderId;
	private int InvoiceNo;
	private String ProductCode;
	@Override
	public int hashCode() {
		return Objects.hash(InvoiceNo, OrderId, ProductCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceOrderDetailsId other = (InvoiceOrderDetailsId) obj;
		return InvoiceNo == other.InvoiceNo && Objects.equals(OrderId, other.OrderId)
				&& Objects.equals(ProductCode, other.ProductCode);
	}
	public InvoiceOrderDetailsId(String orderId, int invoiceNo, String productCode) {
		super();
		OrderId = orderId;
		InvoiceNo = invoiceNo;
		ProductCode = productCode;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public int getInvoiceNo() {
		return InvoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		InvoiceNo = invoiceNo;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public InvoiceOrderDetailsId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
