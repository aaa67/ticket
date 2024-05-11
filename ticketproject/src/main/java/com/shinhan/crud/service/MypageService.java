package com.shinhan.crud.service;

import java.util.List;

import com.shinhan.crud.dao.TicketDAO;
import com.shinhan.crud.dao.UserDAO;
import com.shinhan.crud.dto.MyticketDTO;

public class MypageService {
	
	TicketDAO ticketdao = new TicketDAO();
	UserDAO userdao=new UserDAO();
	
	//1. 예매내역 조회
	public List<MyticketDTO> myTicket(String userId){
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
