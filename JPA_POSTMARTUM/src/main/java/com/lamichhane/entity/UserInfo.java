package com.lamichhane.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id_seq")
	@SequenceGenerator(name = "user_info_id_seq", 
	                   sequenceName = "user_info_seq",
	                   allocationSize = 1) 
	private Integer id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
}
