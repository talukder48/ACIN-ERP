package com.panacea.model.key;

import java.io.Serializable;
import java.sql.Date;

public class TransactionListId implements Serializable{
	private String tran_branch;
	private Date tran_date;
	private int tran_batch;
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
	public TransactionListId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionListId(String tran_branch, Date tran_date, int tran_batch) {
		super();
		this.tran_branch = tran_branch;
		this.tran_date = tran_date;
		this.tran_batch = tran_batch;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tran_batch;
		result = prime * result + ((tran_branch == null) ? 0 : tran_branch.hashCode());
		result = prime * result + ((tran_date == null) ? 0 : tran_date.hashCode());
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
		TransactionListId other = (TransactionListId) obj;
		if (tran_batch != other.tran_batch)
			return false;
		if (tran_branch == null) {
			if (other.tran_branch != null)
				return false;
		} else if (!tran_branch.equals(other.tran_branch))
			return false;
		if (tran_date == null) {
			if (other.tran_date != null)
				return false;
		} else if (!tran_date.equals(other.tran_date))
			return false;
		return true;
	}
	
	
}
