package com.panacea.model.inventory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.RequisitionId;

@Entity
@Table(name = "IN_REQUISITION")
@IdClass(RequisitionId.class)
public class Requisition {
	@Id
	@Column(name = "BranchCode", length = 10)
	private String BranchCode;
	@Id
	@Column(name = "ReqDate")
	private Date ReqDate;
	@Id
	@Column(name = "ReqSL", length = 4)
	private int ReqSL;
	@Column(name = "ProductCode", length = 10)
	private String ProductCode;
	@Column(name = "NoOfItem", length = 8)
	private int NoOfItem;
	@Column(name = "Narration", length = 200)
	private String Narration;
	@Column(name = "Purpose", length = 200)
	private String Purpose;
	
	
	public Requisition(String branchCode, Date reqDate, int reqSL, String productCode, int noOfItem, String narration,String purpose) {
		super();
		BranchCode = branchCode;
		ReqDate = reqDate;
		ReqSL = reqSL;
		ProductCode = productCode;
		NoOfItem = noOfItem;
		Narration = narration;
		Purpose = purpose;
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


	public int getNoOfItem() {
		return NoOfItem;
	}


	public void setNoOfItem(int noOfItem) {
		NoOfItem = noOfItem;
	}


	public String getNarration() {
		return Narration;
	}


	public void setNarration(String narration) {
		Narration = narration;
	}


	public String getPurpose() {
		return Purpose;
	}


	public void setPurpose(String purpose) {
		Purpose = purpose;
	}


	public Requisition() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
