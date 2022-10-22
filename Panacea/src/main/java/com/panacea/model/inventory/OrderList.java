package com.panacea.model.inventory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IN_ORDER_LIST")
public class OrderList {
	@Id
	@Column(name="OrderId",length=16)
	private String OrderId;
	@Column(name="OrderedBranch",length=10)
	private String OrderedBranch;
	@Column(name="OrderedBranchName",length=50)
	private String OrderedBranchName;
	@Column(name="ReqDate",length=20)
	private Date ReqDate;
	@Column(name="ReqSL",length=5)
	private int ReqSL;
	
	@Column(name="ToCompany",length=100)
	private String ToCompany;
	@Column(name="Subject",length=400)
	private String Subject;
	@Column(name="Body",length=800)
	private String Body;
	
	
	
	
	public String getToCompany() {
		return ToCompany;
	}
	public void setToCompany(String toCompany) {
		ToCompany = toCompany;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getOrderedBranch() {
		return OrderedBranch;
	}
	public void setOrderedBranch(String orderedBranch) {
		OrderedBranch = orderedBranch;
	}
	public String getOrderedBranchName() {
		return OrderedBranchName;
	}
	public void setOrderedBranchName(String orderedBranchName) {
		OrderedBranchName = orderedBranchName;
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
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderList(String orderId, String orderedBranch, String orderedBranchName, Date reqDate, int reqSL) {
		super();
		OrderId = orderId;
		OrderedBranch = orderedBranch;
		OrderedBranchName = orderedBranchName;
		ReqDate = reqDate;
		ReqSL = reqSL;
	}
	
	

}
