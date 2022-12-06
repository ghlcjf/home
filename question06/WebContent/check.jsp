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
	String storedName = (String)session.getAttribute("userName");
	String storedId = (String)session.getAttribute("userId");
	String storedPw = (String)session.getAttribute("userPw");
	
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	if(userId.equals(storedId) && userPw.equals(storedPw)){
		request.setAttribute("name", storedName);
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}else{
		response.sendRedirect("signup.html");
	}
%>
</body>
</html>