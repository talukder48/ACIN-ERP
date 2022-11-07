package com.panacea.repository.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import com.panacea.model.inventory.InProductCount;
import com.panacea.model.key.InProductCountId;
public interface InProductCountRepo extends JpaRepository<InProductCount, InProductCountId>{

}
