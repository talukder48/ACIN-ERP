package com.panacea.model.key;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	
}
