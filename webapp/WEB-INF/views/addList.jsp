<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="./add" id="add">
		<table border="1" width="510">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea form="add" rows="10" cols="65"
						name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
	<br>
	<c:forEach items="${list}" var="vo">
		<table border="1" width="510">
			<tr>
				<td>${vo.no}</td>
				<td>${vo.name}</td>
				<td>${vo.regDate}</td>
				<td><a
					href="http://localhost:8088/guestbook3/deleteform?no=${vo.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${vo.content}</td>
			</tr>
		</table>
		<br>
	</c:forEach>
</body>
</html>