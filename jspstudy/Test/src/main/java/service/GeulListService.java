package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.GeulDao;

public class GeulListService implements GeulService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setAttribute("geuls", GeulDao.getInstance().selectAllGeuls());
		request.setAttribute("count", GeulDao.getInstance().selectAllGealsCount());
		
		ActionForward af = new ActionForward();
		af.setView("/geul/list.jsp");
		af.setRedirect(false);
		return af;
		
	}

}
