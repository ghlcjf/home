package com.green.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 페이지로 연결해 주는 것이 목표
		// index.html의 a태그 get 요청을 받고 실행되는 메서드
		
		String url = "member/login.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jsp 로그인 버튼을 눌러 실행되는 함수의 반환값이 true
		// 그 이후에 submit이 동작해 실행되는 메서드
		
		request.setCharacterEncoding("UTF-8");
		
		// 어떤 페이지를 반환할지 결정하는 변수 > 초기값은 실패했을 경우를 가정하는 login.jsp
		String url = "member/login.jsp";
		
		
		// form의 정보 가져오기
		String userid = request.getParameter("userid");
		String userpw = request.getParameter("userpw");
		
		
		
		
		
	}

}
