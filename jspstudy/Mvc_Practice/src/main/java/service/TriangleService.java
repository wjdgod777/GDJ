package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public class TriangleService implements MyService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		double width = Integer.parseInt(request.getParameter("width"));
		double height = Integer.parseInt(request.getParameter("height"));
		
		request.setAttribute("width", width);
		request.setAttribute("height", height);
		request.setAttribute("area", width * height / 2);
		request.setAttribute("shape", "triangle");
		
		ActionForward af = new ActionForward();
		af.setView("views/output.jsp");
		af.setRedirect(false);
		
		return af;
	}

}
