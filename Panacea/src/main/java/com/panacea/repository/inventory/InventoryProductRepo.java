package com.panacea.repository.inventory;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.inventory.InventoryProduct;

public interface InventoryProductRepo extends JpaRepository <InventoryProduct,String>  {
	 @Query(value = "SELECT `product_name` FROM `in_product` WHERE `product_code`=?1", nativeQuery = true)
	 String GetProductName(String ProductCode);
}
