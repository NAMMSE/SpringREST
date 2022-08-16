package com.ezen.restful.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 0816 ÇÇÀÚ dto

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pizza {
	private Integer id;
	private String name;
	private Integer price;
	private Double calrories;
	
}
