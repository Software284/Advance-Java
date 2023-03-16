package com.lamichhane.service;

import java.util.List;

import com.lamichhane.dto.IdDTO;
import com.lamichhane.dto.MessageDTO;
import com.lamichhane.dto.UserInfoDTO;
import com.lamichhane.entity.UserInfo;

public interface IUserInfoService {
	

	UserInfoDTO getUserById(int id);
	
	List<UserInfoDTO> getAllUsers();
	
	IdDTO saveUser(UserInfo userInfo);
	
	MessageDTO deleteUser(int id);
}
