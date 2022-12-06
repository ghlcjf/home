<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	String adminId = "admin";
	String adminPw = "1234";
	String storedId = "green";
	String storedPw = "5678";
	String storedName = "구그린";
%>

<%
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	if(userId.equals(adminId) && userPw.equals(adminPw)){
		request.getRequestDispatcher("admin.html").forward(request, response);
	}else if(userId.equals(storedId) && userPw.equals(storedPw)){
		session.setAttribute("name", storedName);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}else{
		response.sendRedirect("loginForm.jsp");
	}
%>

</body>
</html>