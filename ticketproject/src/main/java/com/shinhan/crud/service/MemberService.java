package com.shinhan.crud.service;

import com.shinhan.crud.dao.AdminDAO;
import com.shinhan.crud.dao.UserDAO;
import com.shinhan.crud.dto.AdminDTO;
import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.SignoutDTO;
import com.shinhan.crud.dto.UserDTO;

public class MemberService { //회원가입, 로그인, 회원 탈퇴 담당
	
	AdminDAO admdao=new AdminDAO();
	UserDAO userdao=new UserDAO();
	
	//1. 관리자 회원가입
	public int adminSignup(AdminDTO adm) {
		return admdao.adminSignup(adm);
	}
	
	//2. 관리자 로그인
	public AdminDTO adminLogin(LoginDTO login) {
		return admdao.adminLogin(login);
	}
	
	//3. 고객 회원가입
	public int userSignup(UserDTO user) {
		return userdao.userSignup(user);
	}
	
	//4. 고객 로그인
	public UserDTO userLogin(LoginDTO login) {
		return userdao.userLogin(login);
	}

	//5. 관리자 탈퇴
	public int adminSignout(SignoutDTO signout) {
		return admdao.adminSignout(signout);
	}

	//6. 고객 탈퇴
	public int userSignout(SignoutDTO signout) {
		return userdao.userSignout(signout);
	}
}
