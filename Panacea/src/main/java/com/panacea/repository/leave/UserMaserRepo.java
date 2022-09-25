package com.panacea.repository.leave;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.login.UserMaster;

public interface UserMaserRepo extends JpaRepository<UserMaster,String> {

}
