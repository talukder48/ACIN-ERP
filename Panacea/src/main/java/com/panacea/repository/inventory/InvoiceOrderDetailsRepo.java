package com.panacea.repository.inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.inventory.*;
import com.panacea.model.key.*;
public interface InvoiceOrderDetailsRepo extends JpaRepository<InvoiceOrderDetails,InvoiceOrderDetailsKey> {

}
