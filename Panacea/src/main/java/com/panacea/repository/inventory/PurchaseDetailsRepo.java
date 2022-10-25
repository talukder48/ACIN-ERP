package com.panacea.repository.inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.PurchaseDetails;
import com.panacea.model.key.PurchaseDetailsId;
public interface PurchaseDetailsRepo extends JpaRepository<PurchaseDetails,PurchaseDetailsId> {

	@Query(value = "SELECT * FROM `in_purchase_details` WHERE `purchase_id`=?1", nativeQuery = true)
	List<PurchaseDetails>GetPurchaseDetails(String PurchaseId);
}
