<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function() {
		
		/* $('#btn_write').click(function(event) {
			location.href = '${contextPath}/geul/add.te';
		}); */
		
		$('#btn_list').click(function(event) {
			location.href = '${contextPath}/geul/list.te';
		});
		
	});
	
</script>
</head>
<body>
	<div>
		<form id="frm_write" method="POST" action="${contextPath}/board/add.te">
			<table border="1">
				<tbody>
					<tr>
						<td>작성자</td>
						<td><input type="text" id="users" name="users" value="${users}"></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" id="title" name="title" value="${title}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea id="content" name="content" rows="10" cols="50"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="등록" id="btn_write">
							<input type="button" value="목록" id="btn_list">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
</body>
</html>