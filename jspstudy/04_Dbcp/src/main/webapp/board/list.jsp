<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 전체 목록</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	
	// ready 이벤트
	// 문서를 모두 확인한 뒤 처리하는 window.onload 이벤트를 대신하는 jQuery 이벤트
	
	$(document).ready(function() {  // 태그 위에 스크립트가 있으려면 필수적인 요소
		$('#btn_write').click(function(event) {
			location.href = '${contextPath}/board/write.do'
		});
	});

</script>
</head>
<body>

	<h1>게시글 목록 보기</h1>
	<div>
		<input type="button" value="새 게시글 작성하러 가기" id="btn_write">
	</div>
	
	<hr>
	
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>게시글번호</th>
					<th>제목</th>
					<th>작성일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${boards}" var="board">
					<tr>
						<td style="text-align:center">${board.board_no}</td>
						<td style="text-align:center"><a href="${contextPath}/board/detail.do?board_no=${board.board_no}">${board.title}</a></td>
						<td style="text-align:center">${board.create_date}</td>
						<td style="text-align:center">
							<a href=""><i class="fa-solid fa-x"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>