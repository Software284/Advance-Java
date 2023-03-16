package com.lamichhane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lamichhane.entity.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

}
