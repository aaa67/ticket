package com.shinhan.crud.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class myticketDTO {
	private int ticketNum;
	private String performer;
	private String name;
	private String time;
	private String location;
	private String area;
	private int seat;
	private int price;
}
