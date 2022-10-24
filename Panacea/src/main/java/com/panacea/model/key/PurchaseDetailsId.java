package com.panacea.model.key;

import java.io.Serializable;



public class PurchaseDetailsId implements Serializable{
	private String PurchaseId;
	private String ProductCode;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ProductCode == null) ? 0 : ProductCode.hashCode());
		result = prime * result + ((PurchaseId == null) ? 0 : PurchaseId.hashCode());
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
		PurchaseDetailsId other = (PurchaseDetailsId) obj;
		if (ProductCode == null) {
			if (other.ProductCode != null)
				return false;
		} else if (!ProductCode.equals(other.ProductCode))
			return false;
		if (PurchaseId == null) {
			if (other.PurchaseId != null)
				return false;
		} else if (!PurchaseId.equals(other.PurchaseId))
			return false;
		return true;
	}
	public String getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		PurchaseId = purchaseId;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public PurchaseDetailsId(String purchaseId, String productCode) {
		super();
		PurchaseId = purchaseId;
		ProductCode = productCode;
	}
	public PurchaseDetailsId() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
