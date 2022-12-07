package com.green.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ScoreDao;
import com.green.dto.ScoreDto;


@WebServlet("/memberInsert")
public class MemberInsertServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("member/memberInsert.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ScoreDto sto = new ScoreDto();
		
		sto.setUserid(request.getParameter("userid"));
		sto.setName(request.getParameter("name"));
		sto.setUserpw(request.getParameter("userpw"));
		sto.setBan(request.getParameter("ban"));
		sto.setType(request.getParameter("type"));
		
		
		ScoreDao dao = ScoreDao.getInstance();
		dao.memberInsert(sto);
		
		String userid = request.getParameter("userid");
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("member/memberLogin.jsp").forward(request, response);
		
	}

}
