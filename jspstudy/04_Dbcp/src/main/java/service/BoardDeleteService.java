package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Board;
import repository.BoardDao;

public class BoardDeleteService implements BoardService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String str = request.getParameter("board_no");     // 파라미터가 board_no
		Optional<String> opt = Optional.ofNullable(str);   // 파라미터가 null일 수 있다.
		int board_no = Integer.parseInt(opt.orElse("0"));  // 파라미터가 null면 "0"을 써라
		
		Board board = BoardDao.getInstance().selectBoardByNo(board_no);
		
		request.setAttribute("board", board);
		
		// 어디로 / 어떻게
		ActionForward af = new ActionForward();
		af.setView("/board/detail.jsp");  // webapp/board/detail.jsp를 의미함
		af.setRedirect(true);  // 포워드
		return af;
		
	}

}
