package com.shinhan.crud.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SeatDTO {
	private String area;
	private int seat;
	private String status;
}
