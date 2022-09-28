package com.panacea.model.key;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class RequisitionId implements Serializable{
	private String BranchCode;
	private Date ReqDate;
	private int ReqSL;
	private String ProductCode;
	public RequisitionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequisitionId(String branchCode, Date reqDate, int reqSL, String productCode) {
		super();
		BranchCode = branchCode;
		ReqDate = reqDate;
		ReqSL = reqSL;
		ProductCode = productCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BranchCode == null) ? 0 : BranchCode.hashCode());
		result = prime * result + ((ProductCode == null) ? 0 : ProductCode.hashCode());
		result = prime * result + ((ReqDate == null) ? 0 : ReqDate.hashCode());
		result = prime * result + ReqSL;
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
		RequisitionId other = (RequisitionId) obj;
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
		if (ReqDate == null) {
			if (other.ReqDate != null)
				return false;
		} else if (!ReqDate.equals(other.ReqDate))
			return false;
		if (ReqSL != other.ReqSL)
			return false;
		return true;
	}
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public Date getReqDate() {
		return ReqDate;
	}
	public void setReqDate(Date reqDate) {
		ReqDate = reqDate;
	}
	public int getReqSL() {
		return ReqSL;
	}
	public void setReqSL(int reqSL) {
		ReqSL = reqSL;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	
}
