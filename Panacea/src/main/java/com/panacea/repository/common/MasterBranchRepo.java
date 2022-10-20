package com.panacea.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.common.MasterBranch;

public interface MasterBranchRepo extends JpaRepository<MasterBranch,String> {
	@Query(value = "SELECT `branch_name` FROM `master_branch` WHERE `branch_code`=?1", nativeQuery = true)
	 String GetBranchName(String Module);
}
