<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null; //>> insert,delete,update처럼 가져올 필요 없으면 없어도 됨

	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String uId = "GREEN";
	String uPw = "1234";
	
	String name = "성길동"; // 실제 request.getParameter("name"); 형태로 가져옴
	String userid = "sung";
	String userpw = "1234";
	String email = "sung@naver.com";
	String phone = "010-1231-2312";
	int admin = 0; 
	// Integer.parseInt(request.getParameter("admin"));
	
	
	
	
	String sql = "INSERT INTO member "+
			"  VALUES(?,?,?,?,?,?)";
	
	
%>

<%

	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		conn = DriverManager.getConnection(url,uId,uPw);
		
		psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, name);
		psmt.setString(2, userid);
		psmt.setString(3, userpw);
		psmt.setString(4, email);
		psmt.setString(5, phone);
		psmt.setInt(6, admin);
		
		int num = psmt.executeUpdate();
		
		out.println(num+"명 회원가입 완료");
	}catch(Exception e){
		
	}finally{
		try{
			if(psmt!=null){psmt.close();}
			if(conn!=null){conn.close();}
		}catch(Exception e){
			
		}
	}
	
	

%>



</body>
</html>