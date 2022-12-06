package com.green.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDao;
import com.green.dto.MovieDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/movieUpdate")
public class MovieUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		MovieDao dao = MovieDao.getInstance();
		MovieDto mto = dao.movieSelect(code);
		
		request.setAttribute("movie", mto);
		request.getRequestDispatcher("movie/movieUpdate.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 업로드 준비 : 경로, 사이즈, 인코딩 타입
		
		String url = "C:\\UploadImage";
		int fileSize = 100*1024*1024;
		String encType = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(
				request,
				url,
				fileSize,
				encType,
				new DefaultFileRenamePolicy()); 
		String pictureurl = multi.getFilesystemName("pictureurl");
		if(pictureurl==null) {
			pictureurl = multi.getParameter("originPic");
		}
		
		MovieDto mto = new MovieDto();
		mto.setCode(Integer.parseInt(multi.getParameter("code")));
		mto.setName(multi.getParameter("name"));
		mto.setDirector(multi.getParameter("director"));
		mto.setActor(multi.getParameter("actor"));
		mto.setPictureurl(pictureurl);
		mto.setStar(Integer.parseInt(multi.getParameter("star")));
		mto.setStory(multi.getParameter("story"));
		
		MovieDao dao = MovieDao.getInstance();
		dao.movieUpdate(mto);
		
		response.sendRedirect("movieList");
				
				
				
	}

}
