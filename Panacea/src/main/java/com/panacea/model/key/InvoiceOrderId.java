package com.panacea.model.key;

import java.io.Serializable;
import java.util.Objects;

public class InvoiceOrderId implements Serializable {
	private String OrderId;
	private int InvoiceNo;
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
	@Override
	public int hashCode() {
		return Objects.hash(InvoiceNo, OrderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceOrderId other = (InvoiceOrderId) obj;
		return InvoiceNo == other.InvoiceNo && Objects.equals(OrderId, other.OrderId);
	}
	public InvoiceOrderId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InvoiceOrderId(String orderId, int invoiceNo) {
		super();
		OrderId = orderId;
		InvoiceNo = invoiceNo;
	}
	
}
