<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 페이지</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>

<div id="wrap">
	<form action="movieInsert" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>영화 제목</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
			<tr>
				<th>영화 감독</th>
				<td>
					<input type="text" name="director">
				</td>
			</tr>
			<tr>
				<th>주연 배우</th>
				<td>
					<input type="text" name="actor">
				</td>
			</tr>
			<tr>
				<th>스틸컷</th>
				<td>
					<input type="file" name="pictureurl">
				</td>
			</tr>
			<tr>
				<th>별점</th>
				<td>
					<input type="number" name="star">
				</td>
			</tr>
			<tr>
				<th>줄거리</th>
				<td>
					<textarea rows="10" cols="80" name="story"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록하기</button>
					<button type="reset">다시 작성</button>
					<button type="button" onclick="location.href='movieList'">목록으로 돌아가기</button>
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>