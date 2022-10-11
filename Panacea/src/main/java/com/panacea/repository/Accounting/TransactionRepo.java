package com.panacea.repository.Accounting;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.acounting.Transaction;
import com.panacea.model.key.TransactionId;

public interface TransactionRepo extends JpaRepository <Transaction,TransactionId>{
	@Query(value = "SELECT * FROM `as_transaction` WHERE `tran_branch`=?1 and `tran_date`=?2 and `tran_batch`=?3", nativeQuery = true)
	 List<Transaction> FindVoucherDetails(String Branch,Date Trandate,int Batch);
	
}
