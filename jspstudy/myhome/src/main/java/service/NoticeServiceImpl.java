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
		
		// notice 폴더의 list.jsp로 forward
		return new ActionForward("/notice/list.jsp", false);
		
	}

}
