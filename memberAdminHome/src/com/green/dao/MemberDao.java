package com.green.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MemberDao {
	// 데이터베이스 연동을 위한 클래스
	// 기능 클래스이므로 싱글턴 패턴 사용
	
	private MemberDao() {}
	
	private static MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance() {
		return dao;
	}
	
	//===================================================
	
	
	public Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc.oracle.thin:@localhost:1521:XE",
				"GREEN",
				"1234");
		return conn;
	}
	
	
	
	
	
	
}
