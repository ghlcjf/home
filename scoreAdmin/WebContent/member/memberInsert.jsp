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
<div id="wrap">
<jsp:include page="../header.jsp"/>
<form action="memberInsert" method="post" name="frm">
	<table>
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="userid">
				<input type="hidden" name="idcheck">
				<button type="button" onclick="idCheck()">중복 체크</button>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="userpw">
			</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td>
				<input type="password" name="pwcheck">
			</td>
		</tr>
		<tr>
			<th>반</th>
			<td>
				<input type="text" name="ban">
			</td>
		</tr>
		<tr>
			<th>선택</th>
			<td>
				<input type="radio" name="type" value="S">학생
				<input type="radio" name="type" value="T">선생
			</td>
		</tr>
		<tr>
			<td>
				<button type="submit" onclick="return insertCheck()">회원가입</button>
				<button type="reset">다시 작성</button>
				<button type="button" onclick="location.href='index.jsp'">돌아가기</button>
			</td>
		</tr>
		
	</table>
</form>
<jsp:include page="../footer.jsp"/>

</div>
</body>
</html>