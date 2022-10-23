package com.panacea.model.inventory;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.InvoiceOrderKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
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
	
		
}
