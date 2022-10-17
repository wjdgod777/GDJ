package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.CircleService;
import service.MyService;
import service.RectangleService;
import service.TriangleService;


@WebServlet("*.do")


public class MyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		
		MyService myService = null;
		
		ActionForward actionForward = null;
		
		switch(command) {
		case "triangle.do":
			myService = new TriangleService();
			break;
		case "rectangle.do":
			myService = new RectangleService();
			break;
		case "circle.do":
			myService = new CircleService();
			break;
		case "input.do":
			actionForward = new ActionForward();
			actionForward.setView("views/input.jsp");
			actionForward.setRedirect(false);
			break;
		}
		
		if(myService != null) {
			actionForward = myService.execute(request, response);
		}
		
		if(actionForward != null) {
			if(actionForward.isRedirect()) {
				response.sendRedirect(actionForward.getView());
			} else {
				request.getRequestDispatcher(actionForward.getView()).forward(request, response);
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
