package com.panacea.repository.Accounting;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.panacea.model.acounting.GLCode;

public interface GLCodeRepo extends JpaRepository <GLCode,String> {
	@Query(value = "SELECT * FROM `as_glcode` WHERE 1", nativeQuery = true)
	 List<GLCode> FindProductGL(String Module);
}
