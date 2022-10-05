package com.panacea.model.acounting;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.TransactionListId;
@Entity
@Table(name = "AS_TRANSACTION_LIST")
@IdClass(TransactionListId.class)
public class TransactionList implements Serializable {
	@Id
	@Column(name="tran_branch",length=10)
	private String tran_branch;
	@Id
	@Column(name="tran_date",length=10)
	private Date tran_date;
	@Id
	@Column(name="tran_batch",length=6)
	private int tran_batch;
	@Column(name="tran_remarks",length=200)
	private String tran_remarks;
	@Column(name="entyBy",length=20)
	private String entyBy;
	@Column(name="entyOn",length=20)
	private Date entyOn;
	@Column(name="modBy",length=20)
	private String modBy;
	@Column(name="modOn",length=20)
	private Date modOn;
	@Column(name="authBy",length=20)
	private String authBy;
	@Column(name="authOn",length=20)
	private Date authOn;
	@Column(name="rejBy",length=20)
	private String rejBy;
	@Column(name="rejOn",length=20)
	private Date rejOn;
	
    private String DataGrid;
    @Column(name="debitAmt",columnDefinition="Decimal(18,2)")
    private Double debitAmt;
    @Column(name="CreditAmt",columnDefinition="Decimal(18,2)")
    private Double CreditAmt;
    
	public TransactionList( String tran_branch, Date tran_date, int tran_batch, String tran_remarks) {
		super();
		this.tran_branch = tran_branch;
		this.tran_date = tran_date;
		this.tran_batch = tran_batch;
		this.tran_remarks = tran_remarks;
	}
    
	public TransactionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getDebitAmt() {
		return debitAmt;
	}

	public void setDebitAmt(Double debitAmt) {
		this.debitAmt = debitAmt;
	}

	public Double getCreditAmt() {
		return CreditAmt;
	}

	public void setCreditAmt(Double creditAmt) {
		CreditAmt = creditAmt;
	}

	public String getDataGrid() {
		return DataGrid;
	}

	public void setDataGrid(String dataGrid) {
		DataGrid = dataGrid;
	}

	

	public String getTran_branch() {
		return tran_branch;
	}

	public void setTran_branch(String tran_branch) {
		this.tran_branch = tran_branch;
	}

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	public int getTran_batch() {
		return tran_batch;
	}

	public void setTran_batch(int tran_batch) {
		this.tran_batch = tran_batch;
	}

	public String getTran_remarks() {
		return tran_remarks;
	}

	public void setTran_remarks(String tran_remarks) {
		this.tran_remarks = tran_remarks;
	}

	public String getEntyBy() {
		return entyBy;
	}

	public void setEntyBy(String entyBy) {
		this.entyBy = entyBy;
	}

	public Date getEntyOn() {
		return entyOn;
	}

	public void setEntyOn(Date entyOn) {
		this.entyOn = entyOn;
	}

	public String getModBy() {
		return modBy;
	}

	public void setModBy(String modBy) {
		this.modBy = modBy;
	}

	public Date getModOn() {
		return modOn;
	}

	public void setModOn(Date modOn) {
		this.modOn = modOn;
	}

	public String getAuthBy() {
		return authBy;
	}

	public void setAuthBy(String authBy) {
		this.authBy = authBy;
	}

	public Date getAuthOn() {
		return authOn;
	}

	public void setAuthOn(Date authOn) {
		this.authOn = authOn;
	}

	public String getRejBy() {
		return rejBy;
	}

	public void setRejBy(String rejBy) {
		this.rejBy = rejBy;
	}

	public Date getRejOn() {
		return rejOn;
	}

	public void setRejOn(Date rejOn) {
		this.rejOn = rejOn;
	}

}
