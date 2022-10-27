package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Geul;
import repository.GeulDao;

public class GeulAddService implements GeulService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String users = request.getParameter("users");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Geul geul = new Geul();
		geul.setUsers(users);
		geul.setTitle(title);
		geul.setContent(content);
		
		int result = GeulDao.getInstance().insertGeul(geul);
		
		PrintWriter out = response.getWriter();
		if(result > 0) {
			out.println("<script>");
			out.println("alert('삽입 성공')");
			out.println("location.href='" + request.getContextPath() + "/geul/list.te'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('삽입 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		out.close();
		
		return null;
	}

}
