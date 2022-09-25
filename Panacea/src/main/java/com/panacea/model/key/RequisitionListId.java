package com.panacea.model.key;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class RequisitionListId implements Serializable{
	private String BranchCode;
	private Date ReqDate;
	private int ReqSL;
	public RequisitionListId(String branchCode, Date reqDate, int reqSL) {
		super();
		BranchCode = branchCode;
		ReqDate = reqDate;
		ReqSL = reqSL;
	}
	public RequisitionListId() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BranchCode == null) ? 0 : BranchCode.hashCode());
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
		RequisitionListId other = (RequisitionListId) obj;
		if (BranchCode == null) {
			if (other.BranchCode != null)
				return false;
		} else if (!BranchCode.equals(other.BranchCode))
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
	

}
