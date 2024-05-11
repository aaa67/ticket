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
import com.shinhan.crud.service.MypageService;

@WebServlet("/member/edit")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("userEdit.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MypageService mypageService=new MypageService();
		
		HttpSession session = request.getSession();
		LoginDTO login = (LoginDTO)session.getAttribute("login");
		String userId=login.getId();
		
		String ad = request.getParameter("ad");
		String pw = request.getParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
		
        if(!ad.equals("") && !pw.equals("")) {
        	mypageService.updateAd(userId, ad);
        	int i_pw=Integer.parseInt(pw);
			mypageService.updatePw(userId, i_pw);
			out.println("<script>alert('주소 및 비밀번호 수정에 성공했습니다.'); location.href='edit';</script>");
            out.flush();
        }
        
		if(!ad.equals("")) {
			mypageService.updateAd(userId, ad);
			out.println("<script>alert('주소 수정에 성공했습니다.'); location.href='edit';</script>");
            out.flush();
		}
		
		if(!pw.equals("")) {
			int i_pw=Integer.parseInt(pw);
			mypageService.updatePw(userId, i_pw);
			out.println("<script>alert('비밀번호 수정에 성공했습니다.'); location.href='edit';</script>");
            out.flush();
		}
	}

}
