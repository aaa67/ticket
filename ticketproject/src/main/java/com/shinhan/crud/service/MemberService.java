package com.shinhan.crud.service;

import com.shinhan.crud.dao.adminDAO;
import com.shinhan.crud.dao.userDAO;
import com.shinhan.crud.dto.adminDTO;
import com.shinhan.crud.dto.loginDTO;
import com.shinhan.crud.dto.signoutDTO;
import com.shinhan.crud.dto.userDTO;

public class memberService { //회원가입, 로그인, 회원 탈퇴 담당
	
	adminDAO admdao=new adminDAO();
	userDAO userdao=new userDAO();
	
	//1. 관리자 회원가입
	public String adminSignup(adminDTO adm) {
		return admdao.adminSignup(adm);
	}
	
	//2. 관리자 로그인
	public adminDTO adminLogin(loginDTO login) {
		return admdao.adminLogin(login);
	}
	
	//3. 고객 회원가입
	public String userSignup(userDTO user) {
		return userdao.userSignup(user);
	}
	
	//4. 고객 로그인
	public userDTO userLogin(loginDTO login) {
		return userdao.userLogin(login);
	}

	//5. 관리자 탈퇴
	public int adminSignout(signoutDTO signout) {
		return admdao.adminSignout(signout);
	}

	//6. 고객 탈퇴
	public int userSignout(signoutDTO signout) {
		return userdao.userSignout(signout);
	}
}
