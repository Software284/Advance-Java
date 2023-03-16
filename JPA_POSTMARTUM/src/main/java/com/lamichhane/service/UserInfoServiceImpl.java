package com.lamichhane.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamichhane.dto.IdDTO;
import com.lamichhane.dto.MessageDTO;
import com.lamichhane.dto.UserInfoDTO;
import com.lamichhane.entity.UserInfo;
import com.lamichhane.mapper.UserInfoMapper;
import com.lamichhane.repository.UserInfoRepository;



@Service
public class UserInfoServiceImpl implements IUserInfoService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Override
	public UserInfoDTO getUserById(int id) {
		Optional<UserInfo> userInfo = userInfoRepository.findById(id);
		return userInfoMapper.toDTO(userInfo.get());
	}

	@Override
	public List<UserInfoDTO> getAllUsers() {
		List<UserInfo> allUser= userInfoRepository.findAll();
		List<UserInfoDTO> allDTO = allUser.stream().map((user) -> {
			return userInfoMapper.toDTO(user);
		}).collect(Collectors.toList());
		return allDTO;
	}

	@Override
	public IdDTO saveUser(UserInfo userInfo) {
		UserInfo user = userInfoRepository.save(userInfo);
		return IdDTO.builder().id(user.getId()).build();
	}

	@Override
	public MessageDTO deleteUser(int id) {
		return null;
	}

}
