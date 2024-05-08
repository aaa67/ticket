/*package com.shinhan.crud.controller;

import java.sql.Date;
import java.util.Scanner;

import com.shinhan.crud.dto.adminDTO;
import com.shinhan.crud.dto.loginDTO;
import com.shinhan.crud.dto.userDTO;
import com.shinhan.crud.service.memberService;
import com.shinhan.crud.util.DateUtil;
import com.shinhan.crud.view.memberView;

public class frontController {
	
	//static Scanner sc;
	static memberService memberservice=new memberService();
	static adminController admincontroller=new adminController();
	static userController usercontroller=new userController();
	static String userId;

	public static void main(String[] args) {
		
		while(true) {
			int selectJob = selectUser();
			switch(selectJob) {
			case 1->{
				admin();
			}
			case 2->{
				member();
			}
			default->{}
			}
		}
	}
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================================");
		System.out.println("회원 유형 선택");
		System.out.println("1. 관리자");
		System.out.println("2. 고객"); 
		System.out.println("================================================");
		System.out.print("선택 >> ");
		int job=sc.nextInt();
		System.out.println("================================================");
		
		return job;
	}
	
	static void admin() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("================================================");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("================================================");
		System.out.print("선택 >> ");
		int job = sc.nextInt();
		System.out.println("================================================");
		
		
		switch (job) {
		case 1 -> { //1. 회원가입
			adminDTO adm=insertAdmin();
			memberView.print(memberservice.adminSignup(adm));
		}
		case 2 -> { //2. 로그인
			while(true) {
				loginDTO login=login();
				int result=memberservice.adminLogin(login);
				if(result==1) {
					userId=login.getId();
					break;
				}
				memberView.print("로그인에 실패했습니다.");
			}
			memberView.print("로그인이 완료되었습니다.");
			admincontroller.afterLogin(userId);
		}
		default -> {
		}
		}
	}
	
	static void member() {
		Scanner sc = new Scanner(System.in);
		System.out.println("================================================");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("================================================");
		System.out.print("선택 >> ");
		int job = sc.nextInt();
		System.out.println("================================================");
		
		switch (job) {
		case 1 -> { //1. 회원가입
			userDTO user=insertUser();
			memberView.print(memberservice.userSignup(user));
		}
		case 2 -> { //2. 로그인
			while(true) {
				loginDTO login=login();
				int result=memberservice.userLogin(login);
				if(result==1) {
					userId=login.getId();
					break;
				}
				memberView.print("로그인에 실패했습니다.");
			}
			memberView.print("로그인이 완료되었습니다.");
			usercontroller.afterLogin(userId);
		}
		default -> {
		}
		}
	}
	
	static adminDTO insertAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID>>");
		String admId=sc.next();
		System.out.print("PW>>");
		int admPw=sc.nextInt();
		
		adminDTO adm=new adminDTO();
		
		adm.setId(admId);
		adm.setPw(admPw);
		
		return adm;
	}
	
	static userDTO insertUser() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID>>");
		String userId=sc.next();
		System.out.print("비밀번호>>");
		int userPw=sc.nextInt();
		System.out.print("이름>>");
		String name=sc.next();
		sc.nextLine();
		System.out.print("주소>>");
		String address=sc.nextLine();
		System.out.print("생년월일 (형식: YYYY-MM-DD)>>");
		Date birth=DateUtil.getSQLDate(sc.next());
		userDTO user=new userDTO();
		
		user.setId(userId);
		user.setPw(userPw);
		user.setName(name);
		user.setAddress(address);
		user.setBirth(birth);
		
		return user;
	}
	
	static loginDTO login() {
		Scanner sc = new Scanner(System.in);
		System.out.print("ID>>");
		String logId=sc.next();
		System.out.print("비밀번호>>");
		int logPw=sc.nextInt();
		
		loginDTO login=new loginDTO();
		
		login.setId(logId);
		login.setPw(logPw);
		
		return login;
	}
} */