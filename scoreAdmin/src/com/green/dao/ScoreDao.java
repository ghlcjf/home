package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.green.db.DBManager;
import com.green.dto.ScoreDto;

public class ScoreDao {
	
	private ScoreDao() {}
	private static ScoreDao dao = new ScoreDao();
	public static ScoreDao getInstance() {
		return dao;
	}
	public int idCheck(String userid) {
		int result = -1;
		String sql = "SELECT userid FROM memberTbl "
				+ " WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}else {
				result = 0;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
				
		
		
		return result;
	}
	public void memberInsert(ScoreDto sto) {
		
		String sql = "INSERT INTO memberTbl "
				+ " VALUES (member_seq.nextval, ?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sto.getUserid());
			psmt.setString(2, sto.getName());
			psmt.setString(3, sto.getUserpw());
			psmt.setString(4, sto.getBan());
			psmt.setString(5, sto.getType());
			
			psmt.executeUpdate();
			System.out.println("데이터");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
		
		
	}
	public int loginCheck(ScoreDto sto) {
		int num = -999;
		
		String sql = "SELECT userpw FROM memberTbl "
				+ " WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sto.getUserid());
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				
				if(rs.getString("userpw").equals(sto.getUserpw()) &&
						rs.getString("userid").equals(sto.getUserid())) {
					num = 1;
					System.out.println(num);
				}else {
					num = 0;
					System.out.println(num);
				}
				
			}else {
				
				num = -1;
				System.out.println(num);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		return num;
	}
	
	
	
	public ScoreDto getMember(ScoreDto sto) {
		
		ScoreDto member = new ScoreDto();
		
		String sql = "SELECT * FROM memberTbl WHERE userid=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sto.getUserid());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				member.setCode(rs.getInt("code"));
				member.setUserid(rs.getString("userid"));
				member.setName(rs.getString("name"));
				member.setUserpw(rs.getString("userpw"));
				member.setBan(rs.getString("ban"));
				member.setType(rs.getString("type"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt, rs);
		}
		
		
		System.out.println("리턴");
		return member;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
