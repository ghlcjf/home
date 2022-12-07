package com.green.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ScoreDao;


@WebServlet("/idCheck")
public class IdCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		System.out.println(userid);
		ScoreDao dao = ScoreDao.getInstance();
		int result = dao.idCheck(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		request.getRequestDispatcher("member/idCheck.jsp").forward(request, response);
		
	}



}
