package com.panacea.repository.inventory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.panacea.model.inventory.Requisition;
import com.panacea.model.key.RequisitionId;
@Repository
public interface RequisitionRepo extends JpaRepository <Requisition,RequisitionId>{
	 @Query(value = "SELECT * FROM `in_requisition` WHERE `branch_code`=?1 and `req_date`=?2 and `reqsl`=?3", nativeQuery = true)
	 List<Requisition> FindByRequisitionDetails(String BranchCode,Date ReqDate,int ReqSL);
 
}
