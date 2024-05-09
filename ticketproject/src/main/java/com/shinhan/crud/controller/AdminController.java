/*package com.shinhan.crud.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.shinhan.crud.dto.showDTO;
import com.shinhan.crud.dto.signoutDTO;
import com.shinhan.crud.service.memberService;
import com.shinhan.crud.service.showService;
import com.shinhan.crud.util.DateUtil;
import com.shinhan.crud.view.memberView;
import com.shinhan.crud.view.showView;

public class adminController {

	// static Scanner sc = new Scanner(System.in);

	static frontController frontcontroller = new frontController();
	static memberService memberservice = new memberService();
	static showService showservice = new showService();

	static void afterLogin(String userId) {
		
		aa:while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("================================================");
			System.out.println("1. 공연 정보 관리");
			System.out.println("2. 로그아웃");
			System.out.println("3. 회원 탈퇴");
			System.out.println("================================================");
			System.out.print("선택 >> ");
			int job = sc.nextInt();
			System.out.println("================================================");

			switch (job) {
			case 1 -> { // 1. 공연 정보 관리
				manageShow();
			}
			case 2 -> { // 2. 로그아웃
				break aa;
			}
			case 3 -> { // 3. 회원 탈퇴
				while (true) {
					signoutDTO signout = signOut(userId);
					int result = memberservice.adminSignout(signout);
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

	static void manageShow() {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================================");
		System.out.println("1. 공연 추가");
		System.out.println("2. 공연 예매 오픈");
		System.out.println("3. 공연 예매 마감");
		System.out.println("================================================");
		System.out.print("선택 >> ");
		int job = sc.nextInt();
		System.out.println("================================================");

		switch (job) {
		case 1 -> { // 1. 공연 추가
			showDTO show = insertShow();
			showView.print(showservice.addShow(show));
		}
		case 2 -> { // 2. 공연 예매 오픈 처리

			// 예매 전 공연 조회
			List<showDTO> showList = showservice.selectClosedShow();
			showView.print(showList, "예매 오픈 전인 공연 조회");

			// 오픈 처리할 공연 ID 선택
			if(showList.size()>0) {
				System.out.println("================================================");
				System.out.print("예매 오픈할 공연 ID 선택 >> ");
				int showId = sc.nextInt();

				// 오픈 처리 결과 출력
				int result = showservice.openShow(showId);
				if (result > 0) {
					memberView.print(showId + "번 공연 오픈 처리가 완료되었습니다.");
				}
				else {
					memberView.print("해당하는 공연이 없습니다.");
				}
			}
		}
		case 3 -> { // 3. 공연 예매 마감 처리
			// 예매 오픈 중이거나 매진인 공연 조회
			List<showDTO> showList = showservice.selectOpenedShow();
			showView.print(showList, "예매 오픈 중인 공연 조회");

			// 마감 처리할 공연 ID 선택
			if(showList.size()>0) {
				System.out.println("================================================");
				System.out.print("예매 마감할 공연 ID 선택 >> ");
				int showId = sc.nextInt();

				// 마감 처리 결과 출력
				int result = showservice.closeShow(showId);
				if (result > 0) {
					memberView.print(showId + "번 공연 마감 처리가 완료되었습니다.");
				}
				else {
					memberView.print("해당하는 공연이 없습니다.");
				}
			}
		}
		default -> {
		}
		}
	}

	static showDTO insertShow() {
		Scanner sc = new Scanner(System.in);
		System.out.print("가수명>>");
		String performer = sc.nextLine();
		System.out.print("공연명>>");
		String name = sc.nextLine();
		System.out.print("공연일자 (형식:YYYY-MM-DD HH:MM:SS)>>");
		Timestamp time = DateUtil.getSQLDateTime(sc.nextLine());
		System.out.print("장소>>");
		String location = sc.next();
		System.out.print("연령 등급>>");
		int age = sc.nextInt();
		

		showDTO show = new showDTO();
		
		//time: timestamp->string 변환
		//String timeStr = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time);

		show.setPerformer(performer);
		show.setName(name);
		show.setTime(DateUtil.timestampToString(time));
		show.setLocation(location);
		show.setAge(age);

		return show;
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
package com.shinhan.crud.controller;

