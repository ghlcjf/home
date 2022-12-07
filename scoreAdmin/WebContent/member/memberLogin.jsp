<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>
<div id="wrap">
<jsp:include page="../header.jsp"/>
<form action="memberLogin" method="post" name="frm">
	<table>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="userid" value="${userid}"><br>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="userpw"><br>
			</td>
		</tr>
		<tr>
			<td>
				<button type="submit" onclick="return loginCheck()">로그인</button>
				<button type="reset">다시 작성</button>
				<button type="button" onclick="location.href='memberInsert'">회원가입</button>
			</td>
		</tr>
		<c:choose>
			<c:when test="${not empty msg}">
				<tr>
					<td colspan="2">${msg}</td>
				</tr>
			</c:when>
		</c:choose>
		
	</table>
</form>
<jsp:include page="../footer.jsp"/>

</div>
</body>
</html>