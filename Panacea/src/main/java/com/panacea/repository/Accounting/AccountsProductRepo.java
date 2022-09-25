package com.panacea.repository.Accounting;
import org.springframework.data.jpa.repository.JpaRepository;
import com.panacea.model.acounting.ProductParam;
public interface AccountsProductRepo extends JpaRepository <ProductParam,String> {

}
