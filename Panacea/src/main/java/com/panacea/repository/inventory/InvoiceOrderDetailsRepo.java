package com.panacea.repository.inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.*;
import com.panacea.model.key.*;
public interface InvoiceOrderDetailsRepo extends JpaRepository<InvoiceOrderDetails,InvoiceOrderDetailsId> {
	@Query(value="SELECT * FROM `in_invoice_order_details` WHERE `order_id`=?1 and `invoice_no`=?2",nativeQuery=true)
	List<InvoiceOrderDetails> GetInvoiceOrderDetails(String OrderId,int invoiceNumber);
}
