package com.shinhan.crud.fiter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.crud.dto.LoginDTO;

//@WebFilter("/*")
public class LoginCheckFilter extends HttpFilter implements Filter {
      
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("==================filter===============");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		
		HttpSession session = req.getSession();
		
		if(!req.getRequestURI().endsWith("main") && !req.getRequestURI().endsWith("login")) {
			session.setAttribute("lastRequest", req.getRequestURI());
			LoginDTO login = (LoginDTO)session.getAttribute("login");
			if(login == null) {
				//로그인되어있지 않으면 브라우저로 내려가서 로그인 창으로 재요청
				String path = req.getServletContext().getContextPath();
				rep.sendRedirect(path + "/main");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	 

}
