<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<tbody>
			<tr>
				<td>순번</td>
				<td><input type="text" id="users" name="users" value="${geul.geulNo}"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${geul.users}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="title" value="${geul.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea id="content" name="content" rows="10" cols="50">${geul.content}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="등록" id="btn_write">
					<input type="button" value="목록" id="btn_list">
					<input type="button" value="삭제" id="btn_remove">
				</td>
			</tr>
		</tbody>
	</table>

</body>
</html>