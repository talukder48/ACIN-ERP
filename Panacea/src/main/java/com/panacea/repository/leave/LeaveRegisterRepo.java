package com.panacea.repository.leave;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.panacea.model.hrm.LeaveRegister;
public interface LeaveRegisterRepo extends JpaRepository<LeaveRegister,Long> {
	 @Query(value = "select * from `hr_leave_register` r where r.recomend_by is null and r.reject_by is null and r.approve_by is null", nativeQuery = true)
	 List<LeaveRegister> FindToBeRecomendedList();
	 
	 @Query(value = "select * from `hr_leave_register` r where r.recomend_by is not null and r.reject_by is null and r.approve_by is  null", nativeQuery = true)
	 List<LeaveRegister> FindToBeApprovalList();
	 
}
