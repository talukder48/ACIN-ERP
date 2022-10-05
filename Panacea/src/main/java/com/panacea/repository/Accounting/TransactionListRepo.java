package com.panacea.repository.Accounting;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.acounting.*;
import com.panacea.model.key.TransactionListId;

public interface TransactionListRepo extends JpaRepository <TransactionList,TransactionListId> {
	 @Query(value = "SELECT nvl(max(`tran_batch`),0)+1 FROM `as_transaction_list` WHERE `tran_branch`=?1 and `tran_date`=?2", nativeQuery = true)
	 int FindBatchNumber(String BranchCode,Date date);

}
