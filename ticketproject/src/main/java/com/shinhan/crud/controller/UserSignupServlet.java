package com.shinhan.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.AdminDTO;
import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.UserDTO;
import com.shinhan.crud.service.MemberService;
import com.shinhan.crud.util.DateUtil;

/**
 * Servlet implementation class adminSignupServlet
 */
@WebServlet("/member/signup")
public class UserSignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//회원가입창 보여주기 
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("userSignup.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		System.out.println(request.getParameter("date"));
		Date birth = DateUtil.getSQLDate(request.getParameter("birth"));
		UserDTO user=new UserDTO(id, pw,name, address, birth);
		int result = service.userSignup(user);
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
