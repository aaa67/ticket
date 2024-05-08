package com.shinhan.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class loginDTO {
	private String id;
	private int pw;
	private boolean admin;
}
