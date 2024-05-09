package com.shinhan.crud.service;

import java.util.List;

import com.shinhan.crud.dao.ticketDAO;
import com.shinhan.crud.dao.userDAO;
import com.shinhan.crud.dto.myticketDTO;
import com.shinhan.crud.dto.seatDTO;

public class mypageService {
	
	ticketDAO ticketdao = new ticketDAO();
	userDAO userdao=new userDAO();
	
	//1. 예매내역 조회
	public List<myticketDTO> myTicket(String userId){
		return ticketdao.myTicket(userId);
	}

	//2. 비밀번호 수정
	public int updatePw(String userId, int pw) {
		return userdao.updatePw(userId, pw);
	}

	//3. 주소 수정
	public int updateAd(String userId, String ad) {
		return userdao.updateAd(userId, ad);
	}

}
