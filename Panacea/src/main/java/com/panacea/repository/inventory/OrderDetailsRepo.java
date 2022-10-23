package com.panacea.repository.inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.OrderDetails;
import com.panacea.model.key.OrderDetailsId;
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,OrderDetailsId> {
	 @Query(value = "SELECT * FROM `in_order_details` WHERE `order_id`=?1 and `status`='Selected'", nativeQuery = true)
	 List<OrderDetails> GetSelectedMaterialFromOrder(String OrderId);
}
