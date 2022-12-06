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
		
		request.getRequestDispatcher("product/productWrite.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Write 폼에서 받은 데이터를 데이터 베이스에 보내기
		
		request.setCharacterEncoding("UTF-8");
		
		// 업로드 준비 : 경로, 사이즈, 인코딩 타입
		String url = "C:\\UploadImage";
		int fileSize = 100*1024*1024;
		String encType = "UTF-8";
		
		// 파일 업로드를 위한 객체
		MultipartRequest multi = new MultipartRequest(
				request,
				url,
				fileSize,
				encType,
				new DefaultFileRenamePolicy());
		//=> 객체 생성과 함께 업로드 완료
		
		
		// 나머지 정보 데이터베이스로 보내기 위해 데이터 포장하기
		ProductDto pto = new ProductDto();
		pto.setName(multi.getParameter("name"));
		pto.setPrice(Integer.parseInt(multi.getParameter("price")));
		pto.setPictureurl(multi.getFilesystemName("pictureurl"));
		pto.setDescription(multi.getParameter("description"));
		
		ProductDao dao = ProductDao.getInstance();
		// 데이터베이스로 포장한 pto 꼭 보내기
		dao.insertProduct(pto);
		
		// 상품 등록이 완료됐으면 리스트 보여주기 위해 리스트 서블릿으로
		response.sendRedirect("productList");
		
		
		
		
		
	}

}
