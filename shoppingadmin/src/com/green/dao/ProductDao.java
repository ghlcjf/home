package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.dto.ProductDto;

public class ProductDao {
	
	private ProductDao () {}
	
	private static ProductDao dao = new ProductDao();
	public static ProductDao getInstance() {
		return dao;
	}
	//----------------------------------------------------------
	public List<ProductDto> selectAllProducts() {
		List<ProductDto> lists = new ArrayList<>();
		
		String sql = "SELECT * FROM productTbl ORDER BY code DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			System.out.println("리스트 추가");
			while(rs.next()) {
				ProductDto pto = new ProductDto();
				pto.setCode(rs.getInt("code"));
				pto.setName(rs.getString("name"));
				pto.setPrice(rs.getInt("price"));
				pto.setPictureurl(rs.getString("pictureurl"));
				pto.setDescription(rs.getString("description"));
				
				lists.add(pto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		
		return lists;
	}
	
	
	public void insertProduct(ProductDto pto) {
	
		String sql = "INSERT INTO productTbl  "
				+ "  VALUES (product_seq.nextval,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pto.getName());
			psmt.setInt(2, pto.getPrice());
			psmt.setString(3, pto.getPictureurl());
			psmt.setString(4, pto.getDescription());
			
			psmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
		
	}
	

}
