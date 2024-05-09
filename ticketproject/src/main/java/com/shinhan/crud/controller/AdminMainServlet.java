package com.shinhan.crud.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.crud.service.ShowService;

/**
 * Servlet implementation class AdminMainServlet
 */


@WebServlet("/admin/main")
public class AdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShowService service = new ShowService();
		request.setAttribute("closedShowList", service.selectClosedShow());
		request.setAttribute("openedShowList", service.selectOpenedShow());
		
		request.getRequestDispatcher("adminMain.jsp").forward(request, response);

	}

	//공연 추가 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
