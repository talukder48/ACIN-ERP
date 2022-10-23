package com.panacea.model.inventory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.InvoiceOrderKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="IN_INVOICE_ORDER")
@IdClass(InvoiceOrderKey.class)
public class InvoiceOrder {
	@Id
	@Column(name="OrderId",length=16)
	private String OrderId;
	@Id
	@Column(name = "InvoiceNo", length = 10)
	private int InvoiceNo;
	@Column(name="ToCompany",length=100)
	private String ToCompany;
	@Column(name="Subject",length=400)
	private String Subject;
	@Column(name="Body",length=800)
	private String Body;
	@Column(name = "Status", length = 50)
	private String Status;
	@Column(name = "EntryBy", length = 10)
	private String EntryBy;
	@Column(name = "EntryOn", length = 20)
	private Date EntryOn;
	@Column(name = "RejBy", length = 10)
	private String RejBy;
	@Column(name = "RejOn", length = 20)
	private Date RejOn;
	@Column(name = "AuthBy", length = 10)
	private String AuthBy;
	@Column(name = "AuthOn", length = 20)
	private Date AuthOn;
	public InvoiceOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public int getInvoiceNo() {
		return InvoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		InvoiceNo = invoiceNo;
	}
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
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getEntryBy() {
		return EntryBy;
	}
	public void setEntryBy(String entryBy) {
		EntryBy = entryBy;
	}
	public Date getEntryOn() {
		return EntryOn;
	}
	public void setEntryOn(Date entryOn) {
		EntryOn = entryOn;
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
	public String getAuthBy() {
		return AuthBy;
	}
	public void setAuthBy(String authBy) {
		AuthBy = authBy;
	}
	public Date getAuthOn() {
		return AuthOn;
	}
	public void setAuthOn(Date authOn) {
		AuthOn = authOn;
	}
	public InvoiceOrder(String orderId, int invoiceNo, String toCompany, String subject, String body, String status,
			String entryBy, Date entryOn) {
		super();
		OrderId = orderId;
		InvoiceNo = invoiceNo;
		ToCompany = toCompany;
		Subject = subject;
		Body = body;
		Status = status;
		EntryBy = entryBy;
		EntryOn = entryOn;
	}
	
	
		
}
