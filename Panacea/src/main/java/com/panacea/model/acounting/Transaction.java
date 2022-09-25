package com.panacea.model.acounting;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.panacea.model.key.TransactionId;

@Entity
@Table(name = "AS_TRANSACTION")
@IdClass(TransactionId.class)
public class Transaction implements Serializable {
	@Id
	@Column(name = "entity_num", length = 4)
	private int entity_num = 1;
	@Id
	@Column(name = "tran_branch", length = 10)
	private String tran_branch;
	@Id
	@Column(name = "tran_date", length = 20)
	private String tran_date;
	@Id
	@Column(name = "tran_batch", length = 6)
	private int tran_batch;
	@Id
	@Column(name = "tran_sl", length = 5)
	private int tran_sl;

	@Column(name = "glcode", length = 10)
	private String glcode;
	@Column(name = "debit_amt", columnDefinition = "Decimal(18,2)")
	private double debit_amt;
	@Column(name = "credit_amt", columnDefinition = "Decimal(18,2)")
	private double credit_amt;
	@Column(name = "narration", length = 100)
	private String narration;
	@Column(name = "chq_number", length = 20)
	private String chq_number;
	@Column(name = "chq_date", length = 20)
	private String chq_date;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(int entity_num, int tran_sl, String tran_branch, String tran_date, int tran_batch, String glcode,
			double debit_amt, double credit_amt, String narration, String chq_number, String chq_date) {
		super();
		this.entity_num = entity_num;
		this.tran_sl = tran_sl;
		this.tran_branch = tran_branch;
		this.tran_date = tran_date;
		this.tran_batch = tran_batch;
		this.glcode = glcode;
		this.debit_amt = debit_amt;
		this.credit_amt = credit_amt;
		this.narration = narration;
		this.chq_number = chq_number;
		this.chq_date = chq_date;
	}

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

	public String getTran_date() {
		return tran_date;
	}

	public void setTran_date(String tran_date) {
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

	public String getGlcode() {
		return glcode;
	}

	public void setGlcode(String glcode) {
		this.glcode = glcode;
	}

	public double getDebit_amt() {
		return debit_amt;
	}

	public void setDebit_amt(double debit_amt) {
		this.debit_amt = debit_amt;
	}

	public double getCredit_amt() {
		return credit_amt;
	}

	public void setCredit_amt(double credit_amt) {
		this.credit_amt = credit_amt;
	}

	public String getNarration() {
		return narration;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public String getChq_number() {
		return chq_number;
	}

	public void setChq_number(String chq_number) {
		this.chq_number = chq_number;
	}

	public String getChq_date() {
		return chq_date;
	}

	public void setChq_date(String chq_date) {
		this.chq_date = chq_date;
	}

}
