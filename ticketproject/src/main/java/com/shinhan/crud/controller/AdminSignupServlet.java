package com.shinhan.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.AdminDTO;
import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.service.MemberService;

/**
 * Servlet implementation class adminSignupServlet
 */
@WebServlet("/admin/signup")
public class AdminSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입창 보여주기 
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("adminSignup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		AdminDTO admin=new AdminDTO(id, pw);
		int result = service.adminSignup(admin);
		if(result<0) {			
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('이미 존재하는 아이디입니다.'); location.href='signup';</script>");
            out.flush();
		}else {
			//회원가입 성공
			response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('회원가입에 성공했습니다.'); location.href='login';</script>");
            out.flush();
		}
		
		//RequestDispatcher rd;
		//rd = request.getRequestDispatcher("../main.jsp");
		//rd.forward(request, response);
	}

}
