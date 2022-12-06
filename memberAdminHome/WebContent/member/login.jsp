<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./script/member.js"></script>
</head>
<body>

<h3>로그인 페이지</h3>


<form action="login" method="post" name="">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userid"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="userpw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit" onclick="return loginCheck()">로그인</button>&nbsp;&nbsp;
				<button type="reset">취소</button>&nbsp;&nbsp;
				<button type="button" onclick="">회원가입</button>&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td colspan="2">${message}</td>
		</tr>
		
	</table>
	
</form>

</body>
</html>