package com.shinhan.crud.service;

import java.util.List;

import com.shinhan.crud.dao.ticketDAO;
import com.shinhan.crud.dto.seatDTO;

public class ticketService {
	ticketDAO ticketdao = new ticketDAO();

	// 1. 예매 가능한 공연인지 체크
	public int checkShow(int showId, String userId) {
		return ticketdao.checkShow(showId, userId);
	}

	// 2. 해당 공연의 좌석 목록 출력
	public List<seatDTO> selectByShow(int showId) {
		return ticketdao.selectByShow(showId);
	}

	// 3. 예매 가능한 좌석인지 확인
	public int checkSeat(int showId, String[] seatArr) {
		return ticketdao.checkSeat(showId, seatArr);
	}

	// 4. 티켓 예매
	public int plusTicket(int showId, String userId, int seatId) {
		return ticketdao.plusTicket(showId, userId, seatId);
	}

	// 5. 티켓 예매 취소
	public int cancelTicket(int ticketId) {
		return ticketdao.cancelTicket(ticketId);
	}

	// 6. 예매시마다 공연 status 값 업데이트
	public void updateShowStatus1(int showId) {
		ticketdao.updateShowStatus1(showId);
	}

	// 7. 매진 공연 예매 취소 시 공연 stauts 값 업데이트
	public void updateShowStatus2(int showId) {
		ticketdao.updateShowStatus2(showId);
	}
	
}
