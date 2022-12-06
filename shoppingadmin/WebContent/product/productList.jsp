<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" href="style/product.css" rel="stylesheet">
</head>
<body>

<div id="wrap" align="center">
	<h1>상품 리스트</h1>
	<table class="list">
		<tr>
			<th>번호</th>
			<th>코드</th>
			<th>이름</th>
			<th>가격</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${productList}" var="product" varStatus="s">
			<tr>
				<td>${s.count }</td>
				<td>${product.code}</td>
				<td>${product.name}</td>
				<td>${product.price }</td>
				<td>상품 수정</td>
				<td>상품 삭제</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" style="border:white; text-align:right">
				<a href="productWrite">상품 등록</a>
			</td>
		</tr>
	</table>
</div>

</body>
</html>