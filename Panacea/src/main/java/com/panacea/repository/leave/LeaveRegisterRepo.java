package com.panacea.repository.leave;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.hrm.LeaveRegister;
public interface LeaveRegisterRepo extends JpaRepository<LeaveRegister,Long> {

}
