package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	// ajax는 페이지 이동이 없음, MVC는 페이지 이동 가능
}
