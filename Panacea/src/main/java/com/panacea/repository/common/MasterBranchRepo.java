package com.panacea.repository.common;
import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.common.MasterBranch;

public interface MasterBranchRepo extends JpaRepository<MasterBranch,String> {

}
