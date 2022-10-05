package com.panacea.repository.Accounting;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.acounting.Transaction;
import com.panacea.model.key.TransactionId;

public interface TransactionRepo extends JpaRepository <Transaction,TransactionId>{

	
}
