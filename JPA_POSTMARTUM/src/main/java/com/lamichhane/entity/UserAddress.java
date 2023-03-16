package com.lamichhane.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@Table
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
	
	@Id
	@Column
	private Integer id;
	
	@Column
	private String country;
	
	@Column
	private String zone;
	
	@Column
	private String district;
	
}
