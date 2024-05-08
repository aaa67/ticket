/*package com.shinhan.crud.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.shinhan.crud.dto.showDTO;
import com.shinhan.crud.dto.signoutDTO;
import com.shinhan.crud.service.memberService;
import com.shinhan.crud.service.mypageService;
import com.shinhan.crud.service.showService;
import com.shinhan.crud.service.ticketService;
import com.shinhan.crud.view.memberView;
import com.shinhan.crud.view.showView;
import com.shinhan.crud.view.ticketView;

public class userController {
	// static Scanner sc = new Scanner(System.in);
	static frontController frontcontroller = new frontController();
	static memberService memberservice = new memberService();
	static showService showservice = new showService();
	static ticketService ticketservice = new ticketService();
	static mypageService mypageservice = new mypageService();

	static void afterLogin(String userId) {
		
		aa:while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("================================================");
			System.out.println("1. 공연 예매");
			System.out.println("2. 마이페이지");
			System.out.println("3. 로그아웃");
			System.out.println("4. 회원 탈퇴");
			System.out.println("================================================");
			System.out.print("선택 >> ");
			int job = sc.nextInt();
			System.out.println("================================================");

			switch (job) {
			case 1 -> { // 1. 공연 예매
				selectShows(userId);
			}
			case 2 -> { // 2. 마이페이지
				myPage(userId);
			}
			case 3 -> { // 3. 로그아웃
				break aa;
			}
			case 4 -> { // 4. 회원 탈퇴
				while (true) {
					signoutDTO signout = signOut(userId);
					int result = memberservice.userSignout(signout);
					if (result == 1) {
						break;
					}
					memberView.print("해당하는 회원이 없습니다.");
				}
				memberView.print("회원 탈퇴가 완료되었습니다.");
				break aa;
			}
			default -> {
			}
			}
		}
	}

	static void selectShows(String userId) {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================================");
		System.out.println("1. 전체 공연 조회");
		System.out.println("2. 공연 검색");
		System.out.println("================================================");
		System.out.print("선택 >> ");
		int job = sc.nextInt();
		System.out.println("================================================");

		switch (job) {
		case 1 -> { // 1. 전체 공연 조회
			List<showDTO> showList = showservice.selectAllShow();
			showView.print(showList, "전체 공연 조회");
			if(showList.size()>0) {
				ticketing(userId);
			}
		}
		case 2 -> { // 2. 공연 검색
			System.out.print("공연 검색>>");
			String name = sc.next();
			List<showDTO> showList = showservice.selectByName(name);
			if (showList.size() > 0) {
				showView.print(showList, "공연 검색 결과");
				ticketing(userId);
			} else {
				showView.print("해당하는 공연이 없습니다.");
			}
		}
		default -> {
		}
		}
	}

	static void ticketing(String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================================");
		System.out.print("예매할 공연 id 선택>>");
		int showId = sc.nextInt();
		
		// 예매 가능한 공연인지 확인
		// 예매 가능한 공연인 경우
		if (ticketservice.checkShow(showId, userId) == 1) {
			ticketView.print(ticketservice.selectByShow(showId));
			System.out.print("예매할 좌석 구역 및 번호 선택 (예시: 1층 1번) >> ");
			sc.nextLine();
			String[] seatArr = sc.nextLine().split(" ");
			//System.out.println(Arrays.toString(seatArr));
			// 예매 가능한 좌석인 경우
			if (ticketservice.checkSeat(showId, seatArr) > 0) { 
				int seatId = ticketservice.checkSeat(showId, seatArr);
				ticketservice.plusTicket(showId, userId, seatId);
				ticketservice.updateShowStatus1(showId);
				ticketView.print("예매가 완료되었습니다.");
			} else {
				ticketView.print("예매 불가능한 좌석입니다.");
			}
			
		} else {
			ticketView.print("예매 불가능한 공연입니다.");
		}
		
		ticketView.print("================================================");
	}

	static void myPage(String userId) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================================");
		System.out.println("1. 예매 내역 조회");
		System.out.println("2. 예매 취소");
		System.out.println("3. 회원 정보 수정");
		System.out.println("================================================");
		
		System.out.print("선택 >> ");
		int job = sc.nextInt();
		System.out.println("================================================");

		switch (job) {
		case 1 -> { // 1. 예매 내역 조회
			ticketView.printMyTicket(mypageservice.myTicket(userId), "예매 내역 조회");
		}
		case 2 -> { // 2. 예매 취소
			ticketView.printMyTicket(mypageservice.myTicket(userId), "예매 내역");
			
			System.out.print("예매 취소할 예매 번호를 입력해주세요. >> ");
			int ticketId = sc.nextInt();
			
			if (ticketservice.cancelTicket(ticketId) > 0) {
				ticketView.print(ticketId + "번 예매 취소가 완료되었습니다.");
				ticketservice.updateShowStatus2(ticketservice.cancelTicket(ticketId));
			} else {
				ticketView.print("해당 예매 번호가 없습니다.");
			}
		}
		case 3 -> { // 3. 회원 정보 수정
			updateMember(userId);
		}
		default -> {
		}
		}
	}

	static void updateMember(String userId) {
		Scanner sc = new Scanner(System.in);

		System.out.println("================================================");
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 주소 수정");
		System.out.println("================================================");

		System.out.print("선택 >> ");
		int num = sc.nextInt();
		System.out.println("================================================");

		switch (num) {
		case 1 -> { // 1. 비밀번호 수정
			System.out.print("새로운 비밀번호 입력 >> ");
			int pw = sc.nextInt();
			if(mypageservice.updatePw(userId, pw)>0) {
				memberView.print("비밀번호 변경이 완료되었습니다.");
			};
		}
		case 2 -> { // 2. 주소 수정
			sc.nextLine();
			System.out.print("새로운 주소 입력 >> ");
			String ad = sc.nextLine();
			if(mypageservice.updateAd(userId, ad)>0) {
				memberView.print("주소 변경이 완료되었습니다.");
			};
		}
		default -> {
		}
		}
	}

	static signoutDTO signOut(String userId) {
		Scanner sc = new Scanner(System.in);
		System.out.print("비밀번호 재입력>>");
		int pw = sc.nextInt();

		signoutDTO signout = new signoutDTO();

		signout.setId(userId);
		signout.setPw(pw);

		return signout;
	}
}*/