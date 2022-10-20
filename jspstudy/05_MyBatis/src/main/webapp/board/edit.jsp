<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardNo}번 게시글 편집 화면</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function() {
		
		$('#frm_edit').submit(function(event) {
			if($('#title').val() == '') { 
				alert('제목은 필수입니다.');
				$('#title').focus();
				event.preventDefault();
				return;
			}
		});
		
		$('#btn_list').click(function(event) {
			location.href = '${contextPath}/board/list.do';
		});
		
	});

</script>
</head>
<body>

	<h1>게시글 편집 화면</h1>
	<div>
		<form method="POST" action="${contextPath}/board/modify.do" id="frm_edit">
			<div>
				<label for="title">제목</label>
				<input type="text" name="title" id="title" value="${board.title}">
			</div>
			<div>
				<label for="content">내용</label><br>
				<textarea name="content" id="content" rows="5" cols="30">${board.content}</textarea>
			</div>
			<input type="hidden" name="boardNo" value="${board.boardNo}">
			<div>
				<input type="submit" value="수정완료">
				<input type="reset" value="작성취소">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div>
	
	<%-- <h1>게시글 편집 화면</h1>
	<div>
		<form method="POST" action="${contextPath}/board/modify.do" id="frm_edit">
			<div>
				게시글 번호 : ${board.boardNo}
				<input type="hidden" name="boardNo" value="${board.boardNo}">
			</div>
			<div>
				게시글 제목 : <input type="text" name="title" id="title" value="${board.title}">
			</div>
			<div>
				게시글 내용<br>
				<textarea name="content" id="content" rows="5" cols="30">${board.content}</textarea>
				
			</div>
			<div>
				작성일자 : ${board.createDate}
			</div>
			<div>
				<input type="submit" value="수정">
				<input type="button" value="목록" id="btn_list">
			</div>
		</form>
	</div> --%>

</body>
</html>