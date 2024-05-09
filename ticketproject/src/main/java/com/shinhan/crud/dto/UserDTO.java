package com.shinhan.crud.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class userDTO {
	private String id;
	private int pw;
	private String name;
	private String address;
	private Date birth;
}
