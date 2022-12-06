package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.dto.MovieDto;

public class MovieDao {
	
	private MovieDao () {}
	private static MovieDao dao = new MovieDao();
	
	public static MovieDao getInstance() {
		return dao;
	}

	public List<MovieDto> selectAllMovieList() {
		List<MovieDto> lists = new ArrayList<>();
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM movieTbl ORDER BY code DESC";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MovieDto mto = new MovieDto();
				mto.setCode(rs.getInt("code"));
				mto.setName(rs.getString("name"));
				mto.setDirector(rs.getString("director"));
				mto.setActor(rs.getString("actor"));
				mto.setPictureurl(rs.getString("pictureurl"));
				mto.setStar(rs.getInt("star"));
				mto.setStory(rs.getString("story"));
				
				lists.add(mto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		
		return lists;
	}

	public MovieDto movieInfomation(int code) {
		// TODO Auto-generated method stub
		
		MovieDto mto = new MovieDto();
		String sql = "SELECT * FROM movieTbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, code);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mto.setCode(code);
				mto.setName(rs.getString("name"));
				mto.setDirector(rs.getString("director"));
				mto.setActor(rs.getString("actor"));
				mto.setPictureurl(rs.getString("pictureurl"));
				mto.setStar(rs.getInt("star"));
				mto.setStory(rs.getString("story"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return mto;
	}

	public void movieDelete(int code) {
		
		String sql = "DELETE FROM MovieTbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, code);
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public MovieDto movieSelect(int code) {
		MovieDto mto = new MovieDto();
		
		String sql = "SELECT * FROM movieTbl WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs= null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, code);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mto.setCode(code);
				mto.setName(rs.getString("name"));
				mto.setDirector(rs.getString("director"));
				mto.setActor(rs.getString("actor"));
				mto.setPictureurl(rs.getString("pictureurl"));
				mto.setStar(rs.getInt("star"));
				mto.setStory(rs.getString("story"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return mto;
	}

	public void movieUpdate(MovieDto mto) {
		
		String sql = "UPDATE movieTbl SET name=?, director=?, actor=?, "
				+ " pictureurl=?, star=?, story=?  "
				+ "  WHERE code=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mto.getName());
			psmt.setString(2, mto.getDirector());
			psmt.setString(3, mto.getActor());
			psmt.setString(4, mto.getPictureurl());
			psmt.setInt(5, mto.getStar());
			psmt.setString(6, mto.getStory());
			psmt.setInt(7, mto.getCode());
			
			psmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}

	public void movieInsert(MovieDto mto) {
		System.out.println("이거 동작");
		String sql = "INSERT INTO movieTbl VALUES  "
				+ "  (movie_seq.NEXTVAL,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mto.getName());
			psmt.setString(2, mto.getDirector());
			psmt.setString(3, mto.getActor());
			psmt.setString(4, mto.getPictureurl());
			psmt.setInt(5, mto.getStar());
			psmt.setString(6, mto.getStory());
			psmt.executeUpdate();
			
		}catch(Exception e) {
			
		}finally {
			DBManager.close(conn, psmt);
		}
		
		
	}

}
