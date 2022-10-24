package com.panacea.model.inventory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "IN_DISBURSE_LIST")
public class DisburseList {
	@Id
	@Column(name = "DisburseId", length = 20)
	private String DisburseId;
	@Column(name = "DisburseSL", length = 8)
	private int DisburseSL;
	@Column(name = "DisburseDate", length = 20)
	private Date DisburseDate;
	@Column(name = "Remarks", length = 200)
	private String Remarks;
	@Column(name = "Comments", length = 200)
	private String Comments;
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	@Column(name = "EntyBy", length = 20)
	private String EntyBy;
	@Column(name = "EntryOn")
	private Date EntryOn;
	@Column(name = "ApproveBy", length = 20)
	private String ApproveBy;
	@Column(name = "ApproveOn")
	private Date ApproveOn;
	@Column(name = "RejBy", length = 20)
	private String RejBy;
	@Column(name = "RejOn")
	private Date RejOn;
	public DisburseList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDisburseId() {
		return DisburseId;
	}
	public void setDisburseId(String disburseId) {
		DisburseId = disburseId;
	}
	public int getDisburseSL() {
		return DisburseSL;
	}
	public void setDisburseSL(int disburseSL) {
		DisburseSL = disburseSL;
	}
	public Date getDisburseDate() {
		return DisburseDate;
	}
	public void setDisburseDate(Date disburseDate) {
		DisburseDate = disburseDate;
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
	public Date getEntryOn() {
		return EntryOn;
	}
	public void setEntryOn(Date entryOn) {
		EntryOn = entryOn;
	}
	public String getApproveBy() {
		return ApproveBy;
	}
	public void setApproveBy(String approveBy) {
		ApproveBy = approveBy;
	}
	public Date getApproveOn() {
		return ApproveOn;
	}
	public void setApproveOn(Date approveOn) {
		ApproveOn = approveOn;
	}
	public String getRejBy() {
		return RejBy;
	}
	public void setRejBy(String rejBy) {
		RejBy = rejBy;
	}
	public Date getRejOn() {
		return RejOn;
	}
	public void setRejOn(Date rejOn) {
		RejOn = rejOn;
	}
	public DisburseList(String disburseId, int disburseSL, Date disburseDate, String remarks, String comments) {
		super();
		DisburseId = disburseId;
		DisburseSL = disburseSL;
		DisburseDate = disburseDate;
		Remarks = remarks;
		Comments = comments;
	}
	
	

}
