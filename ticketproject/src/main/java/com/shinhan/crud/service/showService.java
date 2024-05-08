package com.shinhan.crud.service;

import java.util.List;

import com.shinhan.crud.dao.showDAO;
import com.shinhan.crud.dto.showDTO;


public class showService {
	showDAO showdao = new showDAO();

	// 1. 예매 오픈 중이거나 매진인 공연 조회
	public List<showDTO> selectAllShow() {
		return showdao.selectAllShow();
	}

	// 2. 공연 오픈 처리
	public int openShow(int showId) {
		return showdao.openShow(showId);
	}

	// 3. 예매 오픈 전 공연 조회
	public List<showDTO> selectClosedShow() {
		return showdao.selectClosedShow();
	}

	// 4. 예매 오픈 중이거나 매진인 공연 조회
	public List<showDTO> selectOpenedShow() {
		return showdao.selectOpenedShow();
	}

	// 5. 공연 예매 마감 처리
	public int closeShow(int showId) {
		return showdao.closeShow(showId);
	}

	// 6. 가수명/공연명으로 공연 검색
	public List<showDTO> selectByName(String name) {
		return showdao.selectByName(name);
	}

	// 7. 공연 추가
	public String addShow(showDTO show) {
		return showdao.addshow(show);
	}

}
