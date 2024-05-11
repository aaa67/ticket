package com.shinhan.crud.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.UserDTO;
import com.shinhan.crud.service.MemberService;

@WebServlet("/member/login")
public class UserLoginServlet extends HttpServlet {
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
		//ServletContext app = getServletContext();
		MemberService service = new MemberService();
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		LoginDTO login=new LoginDTO(id, pw, false);
		UserDTO user = service.userLogin(login);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(user==null || user.getId()=="-1") {			
			//존재하지않는 유저
            out.println("<script>alert('존재하지 않는 사용자입니다.'); location.href='login';</script>");
            out.flush();
		}else if(user.getId()=="-2") {
			//비밀번호 오류
            out.println("<script>alert('비밀번호 오류입니다.'); location.href='login';</script>");
            out.flush();
		}else {
			//로그인 성공
			HttpSession session = request.getSession();
			
			session.setAttribute("login", login);
			
			response.sendRedirect("main");
			return;
			
			
			/*String lastAddress = (String)session.getAttribute("lastRequest");
			if(lastAddress==null || lastAddress.length()==0) {
				lastAddress = getServletContext().getContextPath();
			}
			response.sendRedirect(lastAddress);
			return;*/
		}
		
		/*RequestDispatcher rd;
		rd = request.getRequestDispatcher("/main");
		rd.forward(request, response);*/
		
	}

}
