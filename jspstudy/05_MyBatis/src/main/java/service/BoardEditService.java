package service;

import java.io.PrintWriter;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardEditService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Optional<String> opt = Optional.ofNullable(request.getParameter("boardNo"));
		int boardNo = Integer.parseInt(opt.orElse("0"));
		
		Board board = BoardDao.getInstance().selectBoardByNo(boardNo);
		
		if(board == null) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('" + boardNo + "번 게시글의 정보가 없습니다.')");  // 자바스크립트는 세미콜론(;) 없이도 작동함
			out.println("location.href='" + request.getContextPath() + "/board/list.do'");
			out.println("</script>");
			out.close();
		} else {
			request.setAttribute("board", board);
			
			ActionForward af = new ActionForward();
			af.setView("/board/edit.jsp");
			af.setRedirect(false);
			return af;
		}
		
		return null;  // Java 문법 때문에 남겨둔 코드(실행되지 않는 코드)
	}

}
