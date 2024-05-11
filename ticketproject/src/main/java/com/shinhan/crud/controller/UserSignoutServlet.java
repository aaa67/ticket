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

import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.SignoutDTO;
import com.shinhan.crud.service.MemberService;

/**
 * Servlet implementation class AdminSignoutServlet
 */
@WebServlet("/member/signout")
public class UserSignoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("userSignout.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		HttpSession session = request.getSession();
		LoginDTO login = (LoginDTO)session.getAttribute("login");
		String id=login.getId();
		int pw = Integer.parseInt(request.getParameter("pw"));
		SignoutDTO signout = new SignoutDTO(id, pw);
		int result=service.userSignout(signout);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result==0) {			
			//존재하지않는 유저
            out.println("<script>alert('비밀번호 오류입니다.'); location.href='signout';</script>");
            out.flush();
		}else {
			//회원 탈퇴 성공
			out.println("<script>alert('탈퇴 성공');location.href='/ticketproject/main';</script>");
            out.flush();
			
			
			/*String lastAddress = (String)session.getAttribute("lastRequest");
			if(lastAddress==null || lastAddress.length()==0) {
				lastAddress = getServletContext().getContextPath();
			}
			response.sendRedirect(lastAddress);
			return;*/
		}
	}

}
