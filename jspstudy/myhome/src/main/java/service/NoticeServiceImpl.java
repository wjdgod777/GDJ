package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.Notice;
import repository.NoticeDao;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public ActionForward findAllNotices(HttpServletRequest request) {

		// 파라미터 page 확인
		// 파라미터 page가 없으면 page=1로 처리
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		// 전체 목록의 개수
		NoticeDao dao = NoticeDao.getInstance();
		int totalRecordCnt = dao.selectAllNoticesCnt();
		
		// 한 페이지에 표시할 목록의 개수(목록 하나를 record라고 하겠다.)
		int recordPerPage = 10;
		
		// 특정 page에 표시할 목록의 시작번호와 끝번호
		//			  begin  end
		// page = 1 : 1		 10
		// page = 2 : 11	 20
		// page = 3 : 21	 30
		// page = 4 : 31	 35
		int begin = (page - 1) * recordPerPage + 1;
		int end = begin + recordPerPage - 1;
		if(end > totalRecordCnt) {
			end = totalRecordCnt;
		}
		
		// begin + end를 Map로 만들어서 NoticeDao에게 전달해야 함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", begin);
		map.put("end", end);
		
		// begin에서 end사이 목록 가져오기
		List<Notice> notices = dao.selectAllNotices(map);
		
		// 목록을 forward하기 위해서 request에 저장
		request.setAttribute("notices", notices);
		
		// block 개념 이해하기
		// 1 block 당 3 page가 표시되는 상황
		// 전체 7페이지가 있는 상황
		// 			 beginPage endPage
		// 1 block : 1		   3			1	2	3
		// 2 block : 4		   6			4	5	6
		// 3 block : 7		   7			7
		
		// 각 block의 beginPage와 endPage를 알아내기 위한 과정
		// 1) 전체 page의 개수를 구한다.
		// 2) 1 block 당 표시할 page의 개수를 임의로 정한다. (pagePerBlock)
		// 3) 현재 page와 전체 page 개수와 1 block 당 표시할 page 개수로 beginPage를 구한다.
		// 4) beginPage를 이용해서 endPage를 구한다.
		// 5) endPage와 전체 page 개수를 비교해서 작은 값을 endPage로 확정한다.
		
		int totalPageCnt = totalRecordCnt / recordPerPage;
		if(totalRecordCnt % recordPerPage > 0) {
			totalPageCnt++;
		}  // 1)
		
		int pagePerBlock = 3;  // 2)
		
		int beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;  // 3)
		int endPage = beginPage + pagePerBlock -1;  // 4)
		if(endPage > totalPageCnt) {
			endPage = totalPageCnt;
		}  // 5)
		
		// 페이징 처리에 필요한 정보를 list.jsp로 전달
		request.setAttribute("page", page);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPageCnt", totalPageCnt);
		request.setAttribute("pagePerBlock", pagePerBlock);
		
		// notice 폴더의 list.jsp로 forward
		return new ActionForward("/notice/list.jsp", false);
		
	}

}
