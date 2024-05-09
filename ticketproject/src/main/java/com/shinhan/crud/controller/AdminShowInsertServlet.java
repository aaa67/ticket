package com.shinhan.crud.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.crud.dto.LoginDTO;
import com.shinhan.crud.dto.ShowDTO;
import com.shinhan.crud.service.ShowService;
import com.shinhan.crud.util.DateUtil;

@WebServlet("/admin/show")
public class AdminShowInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("showInsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		//서버의 경로
		String path = getServletContext().getRealPath(".");
		File currentDirPath = new File(path+"/upload");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath); //폴더경로 지정
		factory.setSizeThreshold(1024 * 1024); //사이즈 지정

		ServletFileUpload upload = new ServletFileUpload(factory);
		ShowDTO show = new ShowDTO();
		try {
			List items = upload.parseRequest(request); //request로 넘어온 정보를 다 받아옴
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					//FormField: 일반 입력, 글씨 읽기
					//입력 text field
					//System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					
					if(fileItem.getFieldName().equals("performer")) show.setPerformer(fileItem.getString(encoding));
					if(fileItem.getFieldName().equals("name")) show.setName(fileItem.getString(encoding));
					if(fileItem.getFieldName().equals("time")) show.setTime(fileItem.getString(encoding));
					if(fileItem.getFieldName().equals("location")) show.setLocation(fileItem.getString(encoding));
					if(fileItem.getFieldName().equals("age")) show.setAge(Integer.parseInt(fileItem.getString(encoding)));
				} else {
					//이미지 읽기
					if(fileItem.getFieldName().equals("image")) show.setImage(fileItem.getName());
					
					//System.out.println("getFieldName:" + fileItem.getFieldName());
					//System.out.println("getName:" + fileItem.getName());
					//System.out.println("getSize:" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						String fileName = fileItem.getName().substring(idx + 1); //파일 이름 얻기
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile); //파일 저장
					} // end if
				} // end if
			} // end for
			//DB에 저장하기
			int result = new ShowService().addShow(show);
			System.out.println(result + "건 추가");
			response.sendRedirect("main");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
