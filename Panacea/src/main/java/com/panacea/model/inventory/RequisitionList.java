package com.panacea.model.inventory;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.RequisitionListId;

@Entity
@Table(name = "IN_REQUISITION_LIST")
@IdClass(RequisitionListId.class)
public class RequisitionList {
	@Id
	@Column(name = "BranchCode", length = 10)
	private String BranchCode;
	@Id
	@Column(name = "ReqDate")
	private Date ReqDate;
	@Id
	@Column(name = "ReqSL", length = 4)
	private int ReqSL;
	@Column(name = "Remarks", length = 200)
	private String Remarks;
	@Column(name = "EntyBy", length = 20)
	private String EntyBy;
	@Column(name = "EntryOn",columnDefinition = "Date default SYSDATE")
	private LocalDate EntryOn;
	@Column(name = "ApproveBy", length = 20)
	private String ApproveBy;
	@Column(name = "ApproveOn",columnDefinition = "Date default SYSDATE")
	private LocalDate ApproveOn;
	@Column(name = "RejBy", length = 20)
	private String RejBy;
	@Column(name = "RejOn",columnDefinition = "Date default SYSDATE")
	private LocalDate RejOn;
	
	private String RequisitionGrid;
	
	public String getRequisitionGrid() {
		return RequisitionGrid;
	}
	public void setRequisitionGrid(String requisitionGrid) {
		RequisitionGrid = requisitionGrid;
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
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	public String getEntyBy() {
		return EntyBy;
	}
	public void setEntyBy(String entyBy) {
		EntyBy = entyBy;
	}
	public LocalDate getEntryOn() {
		return EntryOn;
	}
	public void setEntryOn(LocalDate entryOn) {
		EntryOn = entryOn;
	}
	public String getApproveBy() {
		return ApproveBy;
	}
	public void setApproveBy(String approveBy) {
		ApproveBy = approveBy;
	}
	public LocalDate getApproveOn() {
		return ApproveOn;
	}
	public void setApproveOn(LocalDate approveOn) {
		ApproveOn = approveOn;
	}
	public String getRejBy() {
		return RejBy;
	}
	public void setRejBy(String rejBy) {
		RejBy = rejBy;
	}
	public LocalDate getRejOn() {
		return RejOn;
	}
	public void setRejOn(LocalDate rejOn) {
		RejOn = rejOn;
	}
	public RequisitionList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequisitionList(String branchCode, Date reqDate, int reqSL, String remarks) {
		super();
		BranchCode = branchCode;
		ReqDate = reqDate;
		ReqSL = reqSL;
		Remarks = remarks;
	}
	

}
