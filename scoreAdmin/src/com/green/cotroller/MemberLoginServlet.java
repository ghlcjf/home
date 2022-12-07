package com.green.cotroller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.ScoreDao;
import com.green.dto.ScoreDto;


@WebServlet("/memberLogin")
public class MemberLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("member/memberLogin.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ScoreDto sto = new ScoreDto();
		
		sto.setUserid(request.getParameter("userid"));
		sto.setUserpw(request.getParameter("userpw"));

		ScoreDao dao = ScoreDao.getInstance();
		
		int num = dao.loginCheck(sto);
		String msg = "";
		
		if(num==-1) {
			msg = "아이디를 찾을 수 없습니다. 확인 후 다시 입력해 주세요.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("member/memberLogin.jsp").forward(request, response);
		}else if(num==0) {
			msg = "비밀번호가 틀렸습니다. 확인 후 다시 입력해 주세요.";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("member/memberLogin.jsp").forward(request, response);
		}else {
			ScoreDto member = dao.getMember(sto);
			request.setAttribute("sto", member);
			if(member.getType().equals("T")) {// 주소 확인하기
				request.getRequestDispatcher("member/teacher.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("member/student.jsp").forward(request, response);
			}
			
		}
		
		
	}

}
