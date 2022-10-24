package com.panacea.repository.inventory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.*;
import com.panacea.model.key.*;
public interface InvoiceOrderRepo extends JpaRepository<InvoiceOrder,InvoiceOrderId> {
	 
	 @Query(value = "SELECT nvl(max(`invoice_no`),0)+1 FROM `in_invoice_order` WHERE `order_id`=?1", nativeQuery = true)
	 int GetOrderInvoiceNumber(String OrderId);
	 
	 @Query(value = "SELECT * FROM `in_invoice_order` WHERE `auth_by` is null and `rej_by` is null", nativeQuery = true)
	 List<InvoiceOrder> GetAuthorizableInvoice();
	 
	 @Query(value = "SELECT * FROM `in_invoice_order` WHERE `auth_by` is not null and `rej_by` is null", nativeQuery = true)
	 List<InvoiceOrder> GetAuthorizedInvoiceOrder();
	 
}
