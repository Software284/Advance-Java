package com.lamichhane.mapper;

import org.springframework.stereotype.Component;

import com.lamichhane.dto.UserAddressDTO;
import com.lamichhane.dto.UserInfoDTO;
import com.lamichhane.entity.UserAddress;
import com.lamichhane.entity.UserInfo;

@Component
public class UserAddressMapper {
	
	public UserAddressDTO toDTO(UserAddress userAddress) {
		return UserAddressDTO.builder()
				.id(userAddress.getId())
				.country(userAddress.getCountry())
				.zone(userAddress.getZone())
				.district(userAddress.getDistrict())
				.build();
	}
}
