package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.GeulDao;

public class GeulDetailService implements GeulService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("geulNo"));
		int geulNo = Integer.parseInt(opt.orElse("0"));
		
		request.setAttribute("geul", GeulDao.getInstance().selectGeulByNo(geulNo));
		
		ActionForward af = new ActionForward();
		af.setView("/geul/detail.jsp");
		af.setRedirect(false);
		return af;
		
	}

}
