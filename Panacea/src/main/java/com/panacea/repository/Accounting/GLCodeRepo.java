package com.panacea.repository.Accounting;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.acounting.GLCode;

public interface GLCodeRepo extends JpaRepository <GLCode,String> {

}
