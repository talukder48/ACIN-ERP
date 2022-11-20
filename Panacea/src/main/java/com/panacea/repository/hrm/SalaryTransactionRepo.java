package com.panacea.repository.hrm;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.SalaryTransaction;
import com.panacea.model.key.SalaryTransactionId;

public interface SalaryTransactionRepo extends JpaRepository<SalaryTransaction, SalaryTransactionId>{
	@Query(value = "SELECT YEAR(?1) from dual", nativeQuery = true)
	int GetSalaryYear(Date salaryDate);
}
