package com.panacea.repository.inventory;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.PurchaseList;

public interface PurchaseListRepo extends JpaRepository<PurchaseList,String> {
	 @Query(value = "SELECT concat(lpad(?1,4,'0'),YEAR(?2) ,lpad(MONTH(?3),2,'0'),lpad(DAY(?4),2,'0'),lpad(?5,4,'0'))as OrderID  FROM dual", nativeQuery = true)
	 String GetPurchaseOrder(String BranchCode,Date ReqDate1,Date ReqDate2,Date ReqDate3,int ReqSL);
	 
	 @Query(value = "SELECT nvl(max(`purchasesl`),0)+1 FROM `in_purchase_list` WHERE `branch_code`=?1 and `orderdate`=?2", nativeQuery = true)
	 int GetPurchaseOrderSL(String BranchCode,Date ReqDate);
	 
	 @Query(value = "SELECT * FROM `in_purchase_list` WHERE `approve_on` is null and `rej_on` is null", nativeQuery = true)
	 List<PurchaseList> GetUnauthorizedPurchase();
	 
}
