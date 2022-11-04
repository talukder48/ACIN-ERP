package com.panacea.model.key;

import java.io.Serializable;

public class GLBalanceId implements Serializable{
	private String BranchCode;
	private String glCode;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BranchCode == null) ? 0 : BranchCode.hashCode());
		result = prime * result + ((glCode == null) ? 0 : glCode.hashCode());
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
		GLBalanceId other = (GLBalanceId) obj;
		if (BranchCode == null) {
			if (other.BranchCode != null)
				return false;
		} else if (!BranchCode.equals(other.BranchCode))
			return false;
		if (glCode == null) {
			if (other.glCode != null)
				return false;
		} else if (!glCode.equals(other.glCode))
			return false;
		return true;
	}
	public GLBalanceId(String branchCode, String glCode) {
		super();
		BranchCode = branchCode;
		this.glCode = glCode;
	}
	
	
}
