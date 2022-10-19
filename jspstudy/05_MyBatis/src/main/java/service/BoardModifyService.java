package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardModifyService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		// DB로 보낼 Board 생성
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setBoardNo(boardNo);
		
		// DB로 Board 보내서 수정
		int result = BoardDao.getInstance().updateBoard(board);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('게시글이 수정되었습니다.')");
			out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('게시글 수정이 실패했습니다.')");
			out.println("history.back()");  // history.go(-1)
			out.println("</script>");
		}
		out.close();
		
		return null;
	}

}
