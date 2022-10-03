package com.panacea.repository.inventory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.inventory.PurchaseList;

public interface PurchaseListRepo extends JpaRepository<PurchaseList,String> {

}
