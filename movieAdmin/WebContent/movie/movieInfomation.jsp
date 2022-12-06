<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 상세보기 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>
<div id="wrap">
<h1>영화 상세보기 페이지</h1>
	<table>
		<tr>
			<td rowspan="7">
				<c:choose>
				<c:when test="${empty movie.pictureurl}">
					<img src="/upload/no_image.jpg">
				</c:when>
				<c:otherwise>
					<img src="/upload/${movie.pictureurl}">
				</c:otherwise>
			</c:choose>
			</td>
			
		</tr>
		<tr>
			<th>영화 코드</th>
			<td>${movie.code}</td>
		</tr>
		<tr>
			<th>영화 제목</th>
			<td>${movie.name}</td>
		</tr>
		<tr>
			<th>영화 감독</th>
			<td>${movie.director}</td>
		</tr>
		<tr>
			<th>주연 배우</th>
			<td>${movie.actor}</td>
		</tr>
		<tr>
			<th>별점</th>
			<td>${movie.star}</td>
		</tr>
		<tr>
			<th>줄거리</th>
			<td>${movie.story}</td>
		</tr>
		<tr>
			<td colspan="3">
				<a href="movieUpdate?code=${movie.code}">영화 정보 수정하기</a>
				<a href="movieDelete?code=${movie.code}">영화 삭제하기</a>
				<a href="movieList">목록으로 돌아가기</a>
			</td>
		</tr>
	</table>
</div>

</body>
</html>