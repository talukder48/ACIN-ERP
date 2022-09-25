package com.panacea.repository.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.inventory.InventoryProduct;

public interface InventoryProductRepo extends JpaRepository <InventoryProduct,String>  {

}
