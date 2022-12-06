<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

String url = "jdbc:oracle:thin:@localhost:1521:XE";
String uId = "GREEN";
String uPw = "1234";

String sql = "SELECT * FROM member";
%>
<table border="1">
	<tr>
		<td>이름</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이메일</td>
		<td>전화번호</td>
		<td>권한</td>
	</tr>
<%


	try{
		// 1. jdbc 드라이버 로딩..
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 연결객체 생성..
		conn = DriverManager.getConnection(url,uId,uPw);
		
		// 3. 쿼리문 수행 위한 객체
		stmt = conn.createStatement();
		
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+rs.getString("name")+"</td>");
			out.println("<td>"+rs.getString("userid")+"</td>");
			out.println("<td>"+rs.getString("userpw")+"</td>");
			out.println("<td>"+rs.getString("email")+"</td>");
			out.println("<td>"+rs.getString("phone")+"</td>");
			out.println("<td>"+rs.getString("admin")+"</td>");
			out.println("</tr>");
		}
	}catch(Exception e){
		
	}finally{
		try{
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			if(conn!=null){conn.close();}
		}catch(Exception e){
			
		}
	}
	
%>
</table>
</body>
</html>