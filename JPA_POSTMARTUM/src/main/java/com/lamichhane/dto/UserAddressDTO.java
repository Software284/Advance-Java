package com.lamichhane.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserAddressDTO {
	
	private Integer id;
	
	private String country;
	
	private String zone;
	
	private String district;
}
