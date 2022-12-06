<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	
	String userName = request.getParameter("userName");
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	session.setAttribute("userName", userName);
	session.setAttribute("userId", userId);
	session.setAttribute("userPw", userPw);
	response.sendRedirect("login.jsp");
%>

</body>
</html>