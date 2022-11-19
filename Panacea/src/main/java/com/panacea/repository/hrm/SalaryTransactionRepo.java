package com.panacea.repository.hrm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.hrm.SalaryTransaction;
import com.panacea.model.key.SalaryTransactionId;

public interface SalaryTransactionRepo extends JpaRepository<SalaryTransaction, SalaryTransactionId>{

}
