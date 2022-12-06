<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 정보 수정 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>

<div id="wrap">
	<h1>영화 정보 수정</h1>
	<form action="movieUpdate" method="post" enctype="multipart/form-data">
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
					<input type="hidden" name="code" value="${movie.code}">
				</td>
				
			</tr>
			<tr>
				<th>영화 제목</th>
				<td>
					<input type="text" name="name" value="${movie.name}">
				</td>
			</tr>
			<tr>
				<th>영화 감독</th>
				<td>
					<input type="text" name="director" value="${movie.director}">
				</td>
			</tr>
			<tr>
				<th>주연 배우</th>
				<td>
					<input type="text" name="actor" value="${movie.actor}">
				</td>
			</tr>
			<tr>
				<th>스틸컷</th>
				<td>
					<input type="file" name="pictureurl">
					(주의 : 수정할 때만 사진을 등록해 주세요.)
					<input type="hidden" name="originPic" value="${movie.pictureurl}">
				</td>
			</tr>
			<tr>
				<th>별점</th>
				<td>
					<input type="number" name="star" value="${movie.star}">
				</td>
			</tr>
			<tr>
				<th>줄거리</th>
				<td>
					<textarea rows="10" cols="80" name="story">${movie.story}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<button type="submit">수정하기</button>
					<button type="reset">다시 작성</button>
					<button type="button" onclick="location.href='movieList'">목록으로 돌아가기</button>
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>