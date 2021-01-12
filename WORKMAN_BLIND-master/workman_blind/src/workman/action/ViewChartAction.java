package workman.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ViewChartAction {

	private static ViewChartAction instance = new ViewChartAction();
	private ViewChartAction() {};
	public static ViewChartAction getInstance() {
		return instance;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "view/error.jsp";
		
		try {
			url = "chart.jsp";
		} catch (Exception s) {
			request.setAttribute("msg", s.getMessage());
			log.info("차트 보여주기 실패");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}