package com.panacea.model.key;

import java.io.Serializable;



public class OrderDetailsId implements Serializable {
	private String OrderId;
	private String ProductCode;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OrderId == null) ? 0 : OrderId.hashCode());
		result = prime * result + ((ProductCode == null) ? 0 : ProductCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailsId other = (OrderDetailsId) obj;
		if (OrderId == null) {
			if (other.OrderId != null)
				return false;
		} else if (!OrderId.equals(other.OrderId))
			return false;
		if (ProductCode == null) {
			if (other.ProductCode != null)
				return false;
		} else if (!ProductCode.equals(other.ProductCode))
			return false;
		return true;
	}
	public OrderDetailsId(String orderId, String productCode) {
		super();
		OrderId = orderId;
		ProductCode = productCode;
	}
	public OrderDetailsId() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
