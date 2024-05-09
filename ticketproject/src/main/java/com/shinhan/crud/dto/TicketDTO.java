package com.shinhan.crud.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TicketDTO {
	private int id;
	private String member_id;
	private int show_id;
	private int seat_id;
	private Date time;
	private char status;
}
