package com.green.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MovieDao;
import com.green.dto.MovieDto;


@WebServlet("/movieList")
public class MovieListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDao dao = MovieDao.getInstance();
		List<MovieDto> lists = dao.selectAllMovieList();
		
		request.setAttribute("lists", lists);
		request.getRequestDispatcher("movie/movieList.jsp").forward(request, response);
		
		
		
	}



}
