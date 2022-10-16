package com.panacea.repository.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import com.panacea.model.inventory.OrderDetails;
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,String> {

}
