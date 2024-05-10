package com.shinhan.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.crud.service.TicketService;

/**
 * Servlet implementation class CancelTicketServlet
 */
@WebServlet("/ticket/cancel")
public class CancelTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TicketService ticketService=new TicketService();
		
		int ticketId = Integer.parseInt(request.getParameter("ticketId"));
		if(ticketService.cancelTicket(ticketId)>0) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('예매 취소가 완료되었습니다.'); location.href='../member/mypage';</script>");
	        out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
