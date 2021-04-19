package workman.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import workman.action.ViewChartAction;
import workman.action.ViewReviewAction;
import workman.action.ViewUtubeAction;

@Slf4j
@WebServlet("/make")
public class ViewController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String command = request.getParameter("command");
		
		if(command != null) {
			if(command.equals("ptreview")) {
				ViewReviewAction action = ViewReviewAction.getInstance();

				action.service(request, response);
			}
			if(command.equals("utube")) {
				ViewUtubeAction action = ViewUtubeAction.getInstance();
				action.service(request, response);
			} 
			if(command.equals("chart")) {
				ViewChartAction action = ViewChartAction.getInstance();
				action.service(request, response);
			} 
			
		}
	}
}