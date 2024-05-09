package com.shinhan.crud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.shinhan.crud.dto.ShowDTO;
import com.shinhan.crud.service.ShowService;

/**
 * Servlet implementation class ShowSearchServlet
 */
@WebServlet("/search")
public class ShowSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		ShowService service = new ShowService();
		List<ShowDTO> datas=service.selectByName(name);
		request.setAttribute("searchList", datas);
		request.getRequestDispatcher("./main/search.jsp").forward(request, response);
 
		
		/*
		 * JSONObject searchList = new JSONObject(); JSONArray arr = new JSONArray();
		 * for(ShowDTO show:datas) { JSONObject obj = new JSONObject(); obj.put("name",
		 * show.getName()); obj.put("performer", show.getPerformer()); obj.put("image",
		 * show.getImage());
		 * 
		 * arr.add(obj); } searchList.put("searchList", arr); String json =
		 * searchList.toJSONString(); response.setCharacterEncoding("utf-8");
		 * response.getWriter().append(json);
		 * 
		 */
		
	}

}