package com.panacea.repository.hrm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.hrm.DeductionData;
public interface DeductionDataRepo extends JpaRepository<DeductionData, String> {

}
