package com.shinhan.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.MyticketDTO;
import com.shinhan.crud.service.MypageService;

/**
 * Servlet implementation class UserMypageServlet
 */
@WebServlet("/member/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MypageService service= new MypageService();
		
		HttpSession session = request.getSession();
		LoginDTO login = (LoginDTO)session.getAttribute("login");
		String userId=login.getId();
		
		List<MyticketDTO> myTickets = service.myTicket(userId);
		
		request.setAttribute("myTickets", myTickets);
		
		request.getRequestDispatcher("userMypage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
