package workman.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import workman.model.ParttimeEvalDAO;

@Slf4j
public class ViewAddAction {

	private static ViewAddAction instance = new ViewAddAction();
	private ViewAddAction() {};
	public static ViewAddAction getInstance() {
		return instance;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error.jsp";
		
		try {
//			request.setAttribute("add", ParttimeEvalDAO.getAllComPTEval(companyname));
			url = "form.jsp";
		} catch (Exception s) {
			request.setAttribute("msg", s.getMessage());
			log.info("폼 보여주기 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}