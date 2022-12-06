<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>

<div id="wrap">

	<table class="list">
		<tr>
			<th>번호</th>
			<th>코드</th>
			<th>영화 제목</th>
			<th>영화 감독</th>
			<th>주연 배우</th>
			<th>별점</th>
			<th>줄거리</th>
		</tr>
		<c:forEach items="${lists}" var="movie" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${movie.code}</td>
				<td><a href="movieInfomation?code=${movie.code}">${movie.name}</a></td>
				<td>${movie.director}</td>
				<td>${movie.actor}</td>
				<td>${movie.star}</td>
				<td>${movie.story}</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="7">
				<a href="movieInsert">영화정보등록</a>
			</td>
			
			
		</tr>
	</table>
</div>

</body>
</html>