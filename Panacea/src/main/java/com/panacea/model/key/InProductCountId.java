package com.panacea.model.key;

import java.io.Serializable;

public class InProductCountId implements Serializable{
	private String BranchCode;
	private String ProductCode;
	public InProductCountId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InProductCountId(String branchCode, String productCode) {
		super();
		BranchCode = branchCode;
		ProductCode = productCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BranchCode == null) ? 0 : BranchCode.hashCode());
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
		InProductCountId other = (InProductCountId) obj;
		if (BranchCode == null) {
			if (other.BranchCode != null)
				return false;
		} else if (!BranchCode.equals(other.BranchCode))
			return false;
		if (ProductCode == null) {
			if (other.ProductCode != null)
				return false;
		} else if (!ProductCode.equals(other.ProductCode))
			return false;
		return true;
	}
	
}
