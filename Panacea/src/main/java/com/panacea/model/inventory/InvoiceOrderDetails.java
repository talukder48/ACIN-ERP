package com.panacea.model.inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.panacea.model.key.InvoiceOrderDetailsKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="IN_INVOICE_ORDER_DETAILS")
@IdClass(InvoiceOrderDetailsKey.class)
public class InvoiceOrderDetails {
	@Id
	@Column(name="OrderId",length=16)
	private String OrderId;
	@Id
	@Column(name = "InvoiceNo", length = 10)
	private int InvoiceNo;
	@Id
	@Column(name = "ProductCode", length = 10)
	private String ProductCode;
	@Column(name = "ProductName", length = 100)
	private String ProductName;
	@Column(name = "NoOfItem", length = 8)
	private int NoOfItem;
	@Column(name = "OrderedNoOfItem", length = 8)
	private int OrderedNoOfItem;
	@Column(name = "unitPrice", columnDefinition = "Decimal(12,2)")
	private double unitPrice;
	@Column(name = "discount", columnDefinition = "Decimal(4,2)")
	private double discount;
	@Column(name = "actualUnitPrice", columnDefinition = "Decimal(12,2)")
	private double actualUnitPrice;
	@Column(name = "totalAmount", columnDefinition = "Decimal(18,2)")
	private double totalAmount;
}
