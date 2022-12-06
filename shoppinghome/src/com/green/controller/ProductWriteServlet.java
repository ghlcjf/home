package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDao;
import com.green.dto.ProductDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/productWrite")
public class ProductWriteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼으로 이동
		
		request.getRequestDispatcher("product/productWrite.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 받은 데이터
		
		request.setCharacterEncoding("UTF-8");
		
		// 업로드 준비
		// 경로
		String url = "C:\\UploadImage";
		// 사이즈
		int fileSize = 100*1024*1024;
		// 인코딩 타입
		String encType = "UTF-8";
		
		MultipartRequest multipart = new MultipartRequest(
				request,url,fileSize,encType,new DefaultFileRenamePolicy());
		
		
		ProductDto pto = new ProductDto();
		pto.setName(multipart.getParameter("name"));
		pto.setPrice(Integer.parseInt(multipart.getParameter("price")));
		pto.setPictureurl(multipart.getFilesystemName("pictureurl"));
		pto.setDescription(multipart.getParameter("description"));
		
		ProductDao dao = ProductDao.getInstance();
		dao.insertProduct(pto);
		
		response.sendRedirect("productList");
		
		
	}

}
