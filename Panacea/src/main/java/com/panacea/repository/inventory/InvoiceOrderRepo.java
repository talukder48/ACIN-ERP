package com.panacea.repository.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.*;
import com.panacea.model.key.*;
public interface InvoiceOrderRepo extends JpaRepository<InvoiceOrder,InvoiceOrderKey> {
	 
	 @Query(value = "SELECT nvl(max(`invoice_no`),0)+1 FROM `in_invoice_order` WHERE `order_id`=?1", nativeQuery = true)
	 String GetOrderInvoiceNumber(String OrderId);
}
