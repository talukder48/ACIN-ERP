package com.panacea.model.inventory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "IN_PURCHASE_LIST")
public class PurchaseList {
	@Id
	@Column(name = "PurchaseId", length = 20)
	private String PurchaseId;
	@Column(name = "PurchaseSL", length =8)
	private int PurchaseSL;
	@Column(name = "BranchCode", length = 10)
	private String BranchCode;
	@Column(name = "Orderdate", length = 20)
	private Date Orderdate;
	@Column(name = "Remarks", length = 200)
	private String Remarks;
	@Column(name = "Comments", length = 200)
	private String Comments;
	@Column(name = "OrderRef", length = 30)
	private String OrderRef;
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
	public PurchaseList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseList(String purchaseId,int PurchaseSL,String BranchCode, Date orderdate, String Comments) {
		super();
		PurchaseId = purchaseId;
		this.PurchaseSL=PurchaseSL;
		Orderdate = orderdate;
		this.Comments = Comments;
		this.BranchCode= BranchCode;
	}
	public String getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		PurchaseId = purchaseId;
	}
	public Date getOrderdate() {
		return Orderdate;
	}
	public void setOrderdate(Date orderdate) {
		Orderdate = orderdate;
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
private String PurchaseGrid;
	
	
	public String getPurchaseGrid() {
		return PurchaseGrid;
	}
	public void setPurchaseGrid(String purchaseGrid) {
		PurchaseGrid = purchaseGrid;
	}
	public String getOrderRef() {
		return OrderRef;
	}
	public void setOrderRef(String orderRef) {
		OrderRef = orderRef;
	}
	public int getPurchaseSL() {
		return PurchaseSL;
	}
	public void setPurchaseSL(int purchaseSL) {
		PurchaseSL = purchaseSL;
	}
	public String getBranchCode() {
		return BranchCode;
	}
	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}

}
