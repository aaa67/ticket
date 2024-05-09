package com.shinhan.crud.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.loginDTO;
import com.shinhan.crud.dto.userDTO;
import com.shinhan.crud.service.memberService;

@WebServlet("/member/login")
public class userLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	List<String> user_list = new ArrayList<>();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //login창 보여주기 
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("userLogin.jsp");
		rd.forward(request, response);
				
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //사용자가 입력한 ID, pass검사
		ServletContext app = getServletContext();
		memberService service = new memberService();
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		loginDTO login=new loginDTO(id, pw, false);
		userDTO user = service.userLogin(login);
		if(user==null || user.getId()=="-1") {			
			//존재하지않는 유저
			request.setAttribute("message", "존재하지않는 직원");
		}else if(user.getId()=="-2") {
			//비밀번호 오류
			request.setAttribute("message", "비밀번호오류 ");
		}else {
			//로그인 성공
			HttpSession session = request.getSession();
			
			session.setAttribute("login", user);
			
			String lastAddress = (String)session.getAttribute("lastRequest");
			if(lastAddress==null || lastAddress.length()==0) {
				lastAddress = getServletContext().getContextPath();
			}
			response.sendRedirect(lastAddress);
			return;
		}
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("../main.jsp");
		rd.forward(request, response);
	}

}
