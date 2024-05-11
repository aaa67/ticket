package com.shinhan.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.service.TicketService;

@WebServlet("/ticket")
public class GetTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketService ticketservice=new TicketService();
		
		int showId = Integer.parseInt(request.getParameter("showId"));
		String area=request.getParameter("area");
		String seat=request.getParameter("seat");
		
		HttpSession session = request.getSession();
		LoginDTO login = (LoginDTO)session.getAttribute("login");
		String userId=login.getId();
		
		String[] seatArr={area,seat};
		
		int seatId = ticketservice.checkSeat(showId, seatArr);
		ticketservice.plusTicket(showId, userId, seatId);
		ticketservice.updateShowStatus1(showId);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('예매가 완료되었습니다.'); location.href='member/mypage';</script>");
        out.flush();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
