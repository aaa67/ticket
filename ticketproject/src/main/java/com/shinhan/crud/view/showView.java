package com.shinhan.crud.view;

import java.util.List;

import com.shinhan.crud.dto.ShowDTO;


public class showView {
	
	public static void print(String str) {
		System.out.println(str);
	}
	
	
	//1. 공연 목록 반환
	public static void print(List<ShowDTO> showList, String str) {
		System.out.printf("=====%s=========================\n", str);
		if(showList.size()>0) {
			for(ShowDTO show : showList) {
				System.out.printf("%-10s %-25s %-10s %-25s %-20s %-20s %-20s",
						          "공연 번호: " + show.getId(),
						          "공연명: " + show.getName(),
						          "가수명: " + show.getPerformer(),
						          "공연 일자: " + show.getTime(),
						          "공연장 위치: " + show.getLocation(),
						          "연령 제한: " + show.getAge() + "세 이상 관람 가능",
						          "예매 가능 여부: " + show.getStatus());
				System.out.println();
			}
		}
		else {
			System.out.println("공연이 없습니다.");
		}
	}
}
