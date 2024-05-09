package com.shinhan.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.crud.dto.SeatDTO;
import com.shinhan.crud.service.TicketService;

/**
 * Servlet implementation class UserTicketServlet
 */
@WebServlet("/member/ticket")
public class UserTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int showId = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("seatList", new TicketService().selectByShow(showId));
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("userTicket.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
