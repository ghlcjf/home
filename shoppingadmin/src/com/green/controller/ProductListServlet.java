package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ProductDao;
import com.green.dto.ProductDto;


@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 상품 리스트를 받아오기 위해 데이터베이스와 연결
		ProductDao dao = ProductDao.getInstance();
		
		// dao에서 상품목록을 가져오는 메서드 실행 후 lists에 담아
		List<ProductDto> lists = dao.selectAllProducts();
		
		// request 요청으로 보내주기
		request.setAttribute("productList", lists);
		request.getRequestDispatcher("product/productList.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
