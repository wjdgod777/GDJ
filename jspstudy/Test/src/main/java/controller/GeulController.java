package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import service.GeulAddService;
import service.GeulDetailService;
import service.GeulListService;
import service.GeulService;

@WebServlet("*.te")

public class GeulController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlMapping = requestURI.substring(contextPath.length());
		
		GeulService service = null;
		
		ActionForward af = null;
		
		switch(urlMapping) {
		case "/geul/list.te":
			service = new GeulListService();
			break;
		case "/geul/add.te":
			service = new GeulAddService();
			break;
		case "/geul/detail.te":
			service = new GeulDetailService();
			break;
		case "/geul/write.te":
			af=new ActionForward();
			af.setView("/geul/write.jsp");
			af.setRedirect(false);
			break;
		}
		
		try {
			if(service != null) {
				af = service.execute(request, response);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getView());
			} else {
				request.getRequestDispatcher(af.getView()).forward(request, response);
			}
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
