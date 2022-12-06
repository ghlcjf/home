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
	public List<MovieDto> movieAllSelect() {
		List<MovieDto> lists = new ArrayList<>();
		
		String sql = "SELECT * FROM movieTbl ORDER BY code DESC";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
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
	public void movieInsert(MovieDto mto) {
		
		String sql = "INSERT INTO movieTbl VALUES  "
				+ "  (movie_seq.nextval,?,?,?,?,?,?)";
		
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
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, code);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				mto.setCode(rs.getInt("code"));
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

	
	
	
	
	
	
}
