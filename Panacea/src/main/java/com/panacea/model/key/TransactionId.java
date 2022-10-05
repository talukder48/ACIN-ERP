package com.panacea.model.key;
import java.io.Serializable;
import java.sql.Date;
public class TransactionId implements Serializable{
	
	private int entity_num;
	private String tran_branch;
	private Date tran_date;
	private int tran_batch;
	private int tran_sl;
	public int getEntity_num() {
		return entity_num;
	}
	public void setEntity_num(int entity_num) {
		this.entity_num = entity_num;
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
	public int getTran_sl() {
		return tran_sl;
	}
	public void setTran_sl(int tran_sl) {
		this.tran_sl = tran_sl;
	}
	public TransactionId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionId(int entity_num, String tran_branch, Date tran_date, int tran_batch, int tran_sl) {
		super();
		this.entity_num = entity_num;
		this.tran_branch = tran_branch;
		this.tran_date = tran_date;
		this.tran_batch = tran_batch;
		this.tran_sl = tran_sl;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + entity_num;
		result = prime * result + tran_batch;
		result = prime * result + ((tran_branch == null) ? 0 : tran_branch.hashCode());
		result = prime * result + ((tran_date == null) ? 0 : tran_date.hashCode());
		result = prime * result + tran_sl;
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
		TransactionId other = (TransactionId) obj;
		if (entity_num != other.entity_num)
			return false;
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
		if (tran_sl != other.tran_sl)
			return false;
		return true;
	}
	
	
}

