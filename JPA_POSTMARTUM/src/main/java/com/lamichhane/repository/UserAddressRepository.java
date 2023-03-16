package com.lamichhane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lamichhane.entity.UserAddress;

public interface UserAddressRepository extends JpaRepository<UserAddress,Integer> {

}
