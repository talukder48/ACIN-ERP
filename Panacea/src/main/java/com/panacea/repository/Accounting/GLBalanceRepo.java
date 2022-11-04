package com.panacea.repository.Accounting;

import org.springframework.data.jpa.repository.JpaRepository;
import com.panacea.model.acounting.GLBalance;
import com.panacea.model.key.GLBalanceId;
public interface GLBalanceRepo extends JpaRepository <GLBalance,GLBalanceId>{

}
