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
		
		$('#btn_write').click(function(event) {
			location.href = '${contextPath}/geul/write.te'; 
		});
		
	});
</script>
</head>
<body>

	<a>총 게시글 : ${count}개</a>
	
	<table border="1">
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${count == null}">
				<tr>
					<td colspan="4">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${count != null}">
				<c:forEach items="${geuls}" var="b">
					<tr>
						<td>${b.geulNo}</td>
						<td>${b.users}</td>
						<td><a href="${contextPath}/geul/detail.te?geulNo=${b.geulNo}">${b.title}</a></td>
						<td>${b.createDate}</td>
					</tr>
				</c:forEach>
			</c:if>
			<tr>
				<td colspan="4"><input type="button" value="새글작성" id="btn_write"></td>
			</tr>
		</tbody>
	</table>

</body>
</html>