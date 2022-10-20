package com.panacea.repository.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import com.panacea.model.inventory.OrderDetails;
import com.panacea.model.key.OrderDetailsId;
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,OrderDetailsId> {

}
