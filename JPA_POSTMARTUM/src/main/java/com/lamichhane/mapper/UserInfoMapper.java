package com.lamichhane.mapper;

import org.springframework.stereotype.Component;

import com.lamichhane.dto.UserAddressDTO;
import com.lamichhane.dto.UserInfoDTO;
import com.lamichhane.entity.UserAddress;
import com.lamichhane.entity.UserInfo;

@Component
public class UserInfoMapper {
	
	public UserInfoDTO toDTO(UserInfo userInfo) {
		return UserInfoDTO.builder()
			.id(userInfo.getId())
			.name(userInfo.getName())
			.email(userInfo.getEmail())
			.build();
	}
}
