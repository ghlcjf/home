<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>

<div id="wrap" align="center">
	<form action="productWrite" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="name" size="80"></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="number" name="price" min="0"></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="pictureurl"></td>
			</tr>
			<tr>
				<th>설명</th>
				<td><textarea rows="10" cols="80" name="description"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit">등록</button>
					<button type="reset">다시 작성</button>
					<button type="button" onclick="location.href='productList'">목록으로</button>
				</td>
			</tr>
		</table>
	
	</form>
</div>

</body>
</html>