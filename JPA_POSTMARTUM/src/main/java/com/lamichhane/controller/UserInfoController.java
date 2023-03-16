package com.lamichhane.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lamichhane.dto.IdDTO;
import com.lamichhane.dto.MessageDTO;
import com.lamichhane.dto.UserInfoDTO;
import com.lamichhane.entity.UserInfo;
import com.lamichhane.service.IUserInfoService;
import com.lamichhane.util.ResponseMessages;

@RequestMapping("jpa-postmartum")
@RestController
public class UserInfoController {
	
	@Autowired
	private IUserInfoService userInfoService;

	@GetMapping("/user_info/{id}")
	private ResponseEntity<?> getUserById(@PathVariable("id") int id) {
		UserInfoDTO userInfoDTO = userInfoService.getUserById(id);
		if(userInfoDTO == null) {
			MessageDTO dto = MessageDTO.builder().message(ResponseMessages.USER_INFO_NOT_FOUND).build();
			return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(userInfoDTO,HttpStatus.OK);
	}
	
	@GetMapping("/user_info")
	private List<UserInfoDTO> getAllUsers() {
		return userInfoService.getAllUsers();
	}
	
	@PostMapping("/user_info")
	private IdDTO saveUser(@RequestBody UserInfo userInfo) {
		return userInfoService.saveUser(userInfo);
	}
	
	@DeleteMapping("/user_ino/{id}")
	private MessageDTO deleteUser(@PathVariable("id") int id) {
		return null;
	}
}
