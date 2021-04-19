package workman.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import workman.model.ParttimeEvalDAO;

@Slf4j
public class ViewUtubeAction {

	private static ViewUtubeAction instance = new ViewUtubeAction();
	private ViewUtubeAction() {};
	public static ViewUtubeAction getInstance() {
		return instance;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error.jsp";
		
		try {
			url = "utube.jsp";
		} catch (Exception s) {
			request.setAttribute("msg", s.getMessage());
			log.info("유튜브 실행 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}