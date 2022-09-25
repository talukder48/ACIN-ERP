package com.panacea.repository.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.inventory.Requisition;
import com.panacea.model.key.RequisitionId;

public interface RequisitionRepo extends JpaRepository <Requisition,RequisitionId>{

}
