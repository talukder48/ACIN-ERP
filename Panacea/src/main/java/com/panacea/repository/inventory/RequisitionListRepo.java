package com.panacea.repository.inventory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.panacea.model.inventory.Requisition;
import com.panacea.model.inventory.RequisitionList;
import com.panacea.model.key.RequisitionListId;

@Repository
public interface RequisitionListRepo extends JpaRepository <RequisitionList,RequisitionListId>{
	 @Query(value = "SELECT * FROM `in_requisition_list` ", nativeQuery = true)
	 List<RequisitionList> FindAllbyQuery();
	 
	 @Query(value = "SELECT * FROM `in_requisition_list` WHERE `approve_on` is null and `rej_on` is null", nativeQuery = true)
	 List<RequisitionList> FindUnApproveList();
	 
	 @Query(value = "SELECT * FROM `in_requisition_list` WHERE `approve_on` is not null  and `rej_on` is null", nativeQuery = true)
	 List<RequisitionList> FindUnGeneratedRequisitionList();
	 
	 @Query(value = "SELECT nvl(max(`reqsl`),0)+1 FROM `in_requisition_list` WHERE `branch_code`=?1 and `req_date`=?2", nativeQuery = true)
	 int FindMaxSl(String BranchCode,Date date);
	 
	 @Query(value = "SELECT * FROM `in_requisition_list` WHERE `branch_code`=?1 and `req_date`=?2 and `reqsl`=?3", nativeQuery = true)
	 List<RequisitionList> FindByRequisitionId(String BranchCode,Date ReqDate,int ReqSL);
	 
	 @Query(value = "SELECT concat(lpad(`branch_code`,4,'0'),YEAR(`req_date`) ,lpad(MONTH(`req_date`),2,'0'),lpad(DAY(`req_date`),2,'0'),lpad(`reqsl`,4,'0'))as OrderID FROM `in_requisition_list` WHERE `branch_code`=?1 and `req_date`=?2 and `reqsl`=?3", nativeQuery = true)
	 String GetOrderID(String BranchCode,Date ReqDate,int ReqSL);
	 
	
}

