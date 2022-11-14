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
<script type="text/javascript">
	$(function() {
		if('${recordPerPage}' != '') {
			$('#recordPerPage').val(${recordPerPage});
		} else {
			$('#recordPerPage').val(10);
		}
		
		$('#recordPerPage').change(function() {
			location.href = '${contextPath}/bbs/list?recordPerPage=' + $(this).val();
		});
	});
</script>
<style>
    @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css');
</style>
<style type="text/css">   
	tfoot td div {
		display: flex;
		justify-content: space-evenly;
	}
	tfoot td a {    
		text-decoration: none;
		color: #000;        
	}
	.lnk_remove {
		cursor: pointer;
	}
	.blind {
		display: none;
	}
</style>
</head>
<body>

	<div>
		<a href="${contextPath}/bbs/write">작성하러가기</a>
	</div>

	<div>
		<select id="recordPerPage">
			<option value="10">10</option>
			<option value="20">20</option>
			<option value="30">30</option>
		</select>
	</div>

	<div>
		<table border="1">
			<thead>
				<tr style="background-color:lightblue">
					<th>순번</th>
					<th>작성자</th>
					<th>제목</th>
					<th>IP</th>
					<th>작성일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="bbs" items="${bbsList}" varStatus="vs">
					<c:if test="${bbs.state == 1}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td>${bbs.writer}</td>
							<td>
								<!-- DEPTH에 따른 들여쓰기 -->
								<c:forEach begin="1" end="${bbs.depth}" step="1">
									&nbsp;&nbsp;
								</c:forEach>
								<!-- 답글은 [RE] 표시 -->
								<c:if test="${bbs.depth > 0}">
									[RE]
								</c:if>
								<!-- 제목 -->
								${bbs.title}
								<!-- 답글달기 버튼 -->
								<%--
									1단 답글로 운용하는 경우 아래와 같이 처리한다.
									<c:if test="${bbs.depth == 0}">
										<input type="button" value="답글" class="btn_reply_write">
									</c:if>	
								--%>
								<input type="button" value="답글" class="btn_reply_write">
								<script>
									$('.btn_reply_write').click(function() {
										$('.reply_write_tr').addClass('blind');
										$(this).parent().parent().next().removeClass('blind');
									});
								</script>
							</td>
							<td>${bbs.ip}</td>
							<td>${bbs.createDate}</td>
							<td style="text-align:center">
								<form method="post" action="${contextPath}/bbs/remove">
									<input type="hidden" name="bbsNo" value="${bbs.bbsNo}">
									<a id="lnk_remove${bbs.bbsNo}"><i class="fa-solid fa-trash-can"></i></a>
								</form>
								<script>
									$('#lnk_remove${bbs.bbsNo}').click(function() {
										if(confirm('삭제할까요?')) {
											$(this).parent().submit();
										}
									});
								</script>
							</td>
						</tr>
						<tr class="reply_write_tr blind">
							<td colspan="6">
								<form method="post" action="${contextPath}/bbs/reply/add">
									<div><input type="text" name="writer" placeholder="작성자" required></div>
									<div><input type="text" name="title" placeholder="제목" required></div>
									<div><button>답글달기</button></div>
									<input type="hidden" name="depth" value="${bbs.depth}">
									<input type="hidden" name="groupNo" value="${bbs.groupNo}">
									<input type="hidden" name="groupOrder" value="${bbs.groupOrder}">
								</form>
							</td>
						</tr>
					</c:if>
					<c:if test="${bbs.state == 0}">
						<tr>
							<td>${beginNo - vs.index}</td>
							<td colspan="5">삭제된 게시글입니다</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">
						<div>${paging}</div>
					</td>
				</tr>
			</tfoot>
		</table>
	</div>

</body>
</html>