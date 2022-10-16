package com.panacea.repository.inventory;

import org.springframework.data.jpa.repository.JpaRepository;
import com.panacea.model.inventory.OrderList;
public interface OrderListRepo extends JpaRepository <OrderList,String> {

}
