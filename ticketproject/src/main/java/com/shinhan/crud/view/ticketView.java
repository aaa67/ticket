package com.shinhan.crud.view;

import java.util.List;

import com.shinhan.crud.dto.MyticketDTO;
import com.shinhan.crud.dto.SeatDTO;

public class ticketView {
	
	public static void print(String str) {
		System.out.println(str);
	}

	public static void print(List<SeatDTO> seatList) {
		System.out.printf("=====전체 좌석 조회=========================\n");
		for(SeatDTO seat : seatList) {
			
			System.out.printf("%-10s %-10s %-20s",
					          "구역: " + seat.getArea(),
					          "좌석 번호: " + seat.getSeat() + "번",
					          "예매 가능 여부: " + (seat.getStatus()));
			System.out.println();
		}
	}
	

	public static void printMyTicket(List<MyticketDTO> myTicket, String str) {
		System.out.printf("=====%s=================================\n", str);
		if(myTicket.size()>0) {
			for(MyticketDTO ticket : myTicket) {
				
				System.out.printf("%-10s %-10s %-10s %-30s %-15s %-10s %-10s %-10s",
					 	           "예매 번호: " + ticket.getTicketNum(),
				                   "공연명: " + ticket.getName(),
				                   "가수명: " + ticket.getPerformer(),
				                   "공연 일자: " + ticket.getTime(),
				                   "공연장 위치: " + ticket.getLocation(),
				                   "좌석 구역: " + ticket.getArea(),
				                   "좌석 번호: " + ticket.getSeat() + "번",
				                   "가격: " + ticket.getPrice() + "원");
				System.out.println();
			}
		}
		else {
			System.out.println("예매 내역이 없습니다.");
		}
	}
	
	
}