package com.shinhan.crud.dto;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ShowDTO {
	private int id;
	private String performer;
	private String name;
	private String time;
	private String location;
	private int age;
	private String status;
	private String image;
}
