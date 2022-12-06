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


@WebServlet("/movieInsert")
public class MovieInsertServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("movie/movieInsert.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		MovieDto mto = new MovieDto();
		
		// 업로드 준비 : 경로, 사이즈, 인코딩 타입
		String url = "C:\\UploadImage";
		int fileSize = 100*1024*1024;
		String encType ="UTF-8";
		
		MultipartRequest multi = new MultipartRequest(
				request, url, fileSize, encType, new DefaultFileRenamePolicy());
		
		
		mto.setName(multi.getParameter("name"));
		mto.setDirector(multi.getParameter("director"));
		mto.setActor(multi.getParameter("actor"));
		mto.setPictureurl(multi.getFilesystemName("pictureurl"));
		mto.setStar(Integer.parseInt(multi.getParameter("star")));
		mto.setStory(multi.getParameter("story"));
		MovieDao dao = MovieDao.getInstance();
		dao.movieInsert(mto);
		
		
		response.sendRedirect("movieList");
		
	}

}
