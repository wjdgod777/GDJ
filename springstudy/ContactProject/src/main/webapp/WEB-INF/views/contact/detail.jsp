<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(document).ready(function() {
		
		$('#btn_list').click(function() {
			
			location.href = '${contextPath}/con/list';
			
		});
		
		$('#btn_remove').click(function() {
			
			location.href = '${contextPath}/con/remove';
			
		});
		
	});
	
</script>
</head>
<body>

	<div>
		<h1>연락처 수정</h1>
			<form id="frm_contact" action="${contextPath}/con/modify" method="post">
				<input type="hidden" name="no" value="${contact.no}">
				<div>
					<label for="name">이름*</label><br>
					<input type="text" name="name" id="${contact.name}">
				</div><br>
				<div>
					<label for="tel">전화*</label><br>
					<input type="text" name="tel" id="${contact.tel}">
				</div><br>
				<div>
					<label for="addr">주소*</label><br>
					<input type="text" name="addr" id="${contact.addr}">
				</div><br>
				<div>
					<label for="email">이메일*</label><br>
					<input type="text" name="email" id="${contact.email}">
				</div><br>
				<div>
					<label for="note">비고</label><br>
					<input type="text" name="note" id="${contact.note}">
				</div><br>
				<div>
					<button>수정하기</button>
					<input type="button" value="삭제하기" id="btn_remove">
					<input type="button" value="전체연락처" id="btn_list">
				</div>
			</form>
	</div>

</body>
</html>