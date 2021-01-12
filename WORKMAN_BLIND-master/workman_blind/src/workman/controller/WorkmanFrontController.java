package workman.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;
import workman.model.CompanyDAO;
import workman.model.WorkmanService;
import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.dto.ParttimeEval;

@Slf4j
@WebServlet("/workman")
public class WorkmanFrontController extends HttpServlet {

	public WorkmanFrontController() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String command = request.getParameter("command");
		
		try {
			
			if ((String) session.getAttribute("id") == null && !(command.equals("clogin") || !(command.equals("mlogin")))
					&& !(command.equals("companyinsert") || !(command.equals("memberinsert")))) {
			
				request.setAttribute("msg", "로그인하세요");
				request.getRequestDispatcher("view/error.jsp").forward(request, response);
			
			} else {

				if (command.equals("clogin")) {
					clogin(request, response);

				} else if (command.equals("mlogin")) {
					mlogin(request, response);

				} else if (command.equals("main")) {
					main(request, response);

				} else if (command.equals("logout")) {
					logout(request, response);

				} else if (command.equals("companyall")) {
					companyall(request, response);

				} else if (command.equals("company")) {
					company(request, response);

				} else if (command.equals("companyinsert")) {
					companyinsert(request, response);

				} else if (command.equals("companyupdatereq")) {
					companyupdatereq(request, response);

				} else if (command.equals("companyupdate")) {
					companyupdate(request, response);

				} else if (command.equals("companydelete")) {
					companydelete(request, response);

				} else if (command.equals("member")) {
					member(request, response);

				} else if (command.equals("memberinsert")) {
					memberinsert(request, response);

				} else if (command.equals("memberupdatereq")) {
					memberupdatereq(request, response);

				} else if (command.equals("memberupdate")) {
					memberupdate(request, response);

				} else if (command.equals("memberdelete")) {
					memberdelete(request, response);

				} else if (command.equals("ptlistall")) {
					ptlistall(request, response);

				} else if (command.equals("ptlist")) {
					ptlist(request, response);

				} else if (command.equals("ptlistinsert")) {
					ptlistinsert(request, response);

				} else if (command.equals("ptlistupdate")) {
					ptlistupdate(request, response);

				} else if (command.equals("ptlistdelete")) {
					ptlistdelete(request, response);

				} else if (command.equals("ptevalallcom")) {
					ptevalallcom(request, response);
					
				} else if (command.equals("ptevalcom")) {
					ptevalcom(request, response);

				} else if (command.equals("ptevalinsert")) {
					ptevalinsert(request, response);

				} else if (command.equals("ptevalupdatereq")) {
					ptevalupdatereq(request, response);

				} else if (command.equals("ptevalupdate")) {
					ptevalupdate(request, response);

				} else if (command.equals("ptevaldelete")) {
					ptevaldelete(request, response);
					
				} else {
					
					request.setAttribute("msg", "유효하지 않은 command입니다.");
					request.getRequestDispatcher("view/error.jsp").forward(request, response);
				
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("view/error.jsp").forward(request, response);
		
		}
	}

	private void main(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("main.jsp").forward(req, res);
		
	}

	private void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getRequestDispatcher("logout.jsp").forward(req, res);
	
	}

	public void clogin(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("id");
		String pw = req.getParameter("pw");
		String url = "view/error.jsp";
		
		HttpSession session = req.getSession();
		try {
			
			String loginresult = WorkmanService.clogin(name, pw);
			if (loginresult.equals("success")) {
				
				session.setAttribute("id", name);
				session.setAttribute("pw", pw);
				session.setAttribute("type", 1);
				
				ArrayList<Company> allcompany = WorkmanService.getAllCompany();
				session.setAttribute("allcompany", allcompany);
				
				url = "main.jsp";
				log.info(name + " 로그인 성공");
				
			} else if (loginresult.equals("id")) {
				
				req.setAttribute("msg", "ID를 다시 확인해주세요");
				
			} else if (loginresult.equals("pw")) {
				
				req.setAttribute("msg", "비밀번호를 다시 확인해주세요");
				
			}
		} catch (Exception e) {
			req.setAttribute("msg", "DB 조회 실패");
		}
		req.getRequestDispatcher(url).forward(req, res);
	}

	public void companyall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		try {

			request.getSession().setAttribute("companyall", WorkmanService.getAllCompany());

		} catch (Exception s) {

			request.setAttribute("msg", "모든 회사 조회 실패");
			log.info("모든 기업회원 조회 에러 발생");

		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "view/error.jsp";

		try {

			request.getSession().setAttribute("company", WorkmanService.getCompany(request.getParameter("companyname")));

		} catch (Exception s) {

			request.setAttribute("msg", "기업회원 조회 에러 발생");
			log.info("기업회원 조회 에러 발생");
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void companyinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String name = request.getParameter("companyname");
		String pw = request.getParameter("companypw");
		String category = request.getParameter("category");
		String loc = request.getParameter("companyloc");
		String num = request.getParameter("companynum");

		try {
			
			String result = WorkmanService.addCompany(name, pw, category, loc, num);
			
			if (result.equals("success")) {

				request.getSession().setAttribute("company", WorkmanService.getCompany(name));
				request.setAttribute("msg", "기업회원 가입 완료");
				url = "comcrud/comsuccess.jsp";

			} else {
				
				request.setAttribute("msg", "다시 시도하세요");
				
			}
		} catch (Exception s) {

			request.setAttribute("msg", "기업회원 가입 실패");
			log.info("기업회원 가입 실패");
			
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	public void companyupdatereq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";
		
		try {

			request.getSession().setAttribute("company",
					WorkmanService.getCompany(String.valueOf(request.getSession().getAttribute("id"))));
			url = "comcrud/companyupdate.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "기업회원 정보 갱신 요청 실패");
			log.info("기업회원 정보 갱신 요청 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void companyupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String name = request.getParameter("companyname");
		String pw = request.getParameter("companypw");
		String category = request.getParameter("category");
		String loc = request.getParameter("companyloc");
		String num = request.getParameter("companynum");

		try {

			if (WorkmanService.updateCompanyPW(name, pw) && WorkmanService.updateCompanyCategory(name, category)
					&& WorkmanService.updateCompanyLoc(name, loc) && WorkmanService.updateCompanyNum(name, num)) {

				request.setAttribute("msg", "기업회원 갱신 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도 하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "기업회원 정보 갱신 실패");
			log.info("기업회원 정보 갱신 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void companydelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String name = String.valueOf(request.getSession().getAttribute("id"));

		try {

			if (WorkmanService.deleteCompany(name)) {

				request.setAttribute("msg", "기업회원 삭제 성공");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "기업회원 삭제 실패");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "기업회원 삭제 실패");
			log.info("기업회원 삭제 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	// member

	public void mlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String url = "view/error.jsp";
		HttpSession session = request.getSession();

		try {

			String loginresult = WorkmanService.mlogin(id, pw);

			if (loginresult.equals("success")) {

				session.setAttribute("id", id);
				session.setAttribute("pw", pw);
				session.setAttribute("type", 2);

				Member user = WorkmanService.getMember(id);
				String comname = user.getCompanyname().getCompanyname();
				session.setAttribute("comname", comname);
				
				ArrayList<Company> allcompany = WorkmanService.getAllCompany();
				session.setAttribute("allcompany", allcompany);
				
				session.setAttribute("ptlistall", WorkmanService.getAllPTList());

				url = "main.jsp";

			} else if (loginresult.equals("id")) {

				request.setAttribute("msg", "ID를 다시 확인해주세요");

			} else if (loginresult.equals("pw")) {

				request.setAttribute("msg", "비밀번호를 다시 확인해주세요");

			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void member(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "view/error.jsp";

		try {

			request.getSession().setAttribute("member", WorkmanService.getMember(request.getParameter("Userid")));
			url = "parTimeListView.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "일반 회원 조회 에러 발생");
			log.info("일반 회원 조회 에러 발생");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void memberinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String id = request.getParameter("userid");
		String comname = request.getParameter("companyname");
		String pw = request.getParameter("userpw");
		String name = request.getParameter("username");
		String num = request.getParameter("usernum");

		try {

			String result = WorkmanService.addMember(id, comname, pw, name, num);

			if (result.equals("success")) {

				request.getSession().setAttribute("member", WorkmanService.getMember(id));
				request.setAttribute("msg", "일반회원 가입 성공");
				url = "memcrud/meminssuccess.jsp";

			} else {
				
				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "일반회원 가입 실패");
			log.info("일반회원 가입 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberupdatereq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";
		HttpSession session = request.getSession();

		try {

			session.setAttribute("member", WorkmanService.getMember(String.valueOf(session.getAttribute("id"))));
			url = "memcrud/memberupdate.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "일반회원 정보 갱신 요청 실패");
			log.info("일반회원 정보 갱신 요청 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		String name = request.getParameter("username");
		String num = request.getParameter("usernum");

		try {

			if (WorkmanService.updateMemberPW(id, pw) && WorkmanService.updateMemberName(id, name)
					&& WorkmanService.updateMemberNum(id, num)) {

				request.setAttribute("msg", "일반회원 갱신 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "일반회원 정보 갱신 실패");
			log.info("일반회원 정보 갱신 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void memberdelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";
		String id = String.valueOf(request.getSession().getAttribute("id"));

		try {

			if (WorkmanService.deleteMember(id)) {

				request.setAttribute("msg", "일반회원 삭제 성공");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "일반회원 삭제 실패");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "회원 삭제 실패");
			log.info("일반회원 삭제 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	// PTLIST

	public void ptlistall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		try {

			request.getSession().setAttribute("ptlistall", WorkmanService.getAllPTList());
			url = "plcrud/plview.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "전체 알바 구인글 조회 에러 발생");
			log.info("전체 알바 구인글 조회 에러 발생");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "view/error.jsp";
		HttpSession session = request.getSession();

		try {

			session.setAttribute("ptlist",
					WorkmanService.getPTList(Integer.valueOf((String) request.getParameter("listnum"))));
			session.setAttribute("company", WorkmanService.getCompany((String) request.getParameter("companyname")));
			url = "plcrud/plviewone.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "해당 알바 구인 글 조회 에러 발생");
			log.info("해당 알바 구인 글 조회 에러 발생");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void ptlistinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String name = request.getParameter("companyname");
		String time = request.getParameter("worktime");
		int wage = Integer.valueOf(request.getParameter("hourlywage"));
		String period = request.getParameter("workperiod");
		String objective = request.getParameter("objective");

		try {

			if (WorkmanService.addPTList(name, time, wage, period, objective)) {

				request.setAttribute("msg", "알바 구인글 등록 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "알바 구인글 등록 실패");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "알바 구인글 등록 실패");
			log.info("알바 구인글 등록 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptlistupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		int listnum = Integer.valueOf(request.getParameter("listnum"));
		String time = request.getParameter("worktime");
		int wage = Integer.valueOf(request.getParameter("hourlywage"));
		String period = request.getParameter("workperiod");
		String objective = request.getParameter("objective");

		try {

			if (WorkmanService.updatePTListWorktime(listnum, time)
					&& WorkmanService.updatePTListHourlywage(listnum, wage)
					&& WorkmanService.updatePTListWorkperiod(listnum, period)
					&& WorkmanService.updatePTListObjective(listnum, objective)) {

				request.setAttribute("msg", "알바 구인글 갱신 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "알바 구인 글 갱신 실패");
			log.info("알바 구인 글 갱신 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptlistdelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		int listnum = Integer.valueOf(request.getParameter("listnum"));

		try {

			if (WorkmanService.deletePTList(listnum)) {

				request.setAttribute("msg", "알바 구인글 삭제 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "알바 구인 글 삭제 실패");
			log.info("알바 구인 글 삭제 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptevalcom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		int evalnum = Integer.valueOf(request.getParameter("evalnum"));

		try {

			request.getSession().setAttribute("ptevalcom", WorkmanService.getPTEval(evalnum));
			url = "pecrud/peviewone.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "특정 알바 리뷰글 조회 에러 발생");
			log.info("특정 알바 리뷰글 조회 에러 발생");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptevalallcom(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String name = request.getParameter("companyname");

		try {

			ArrayList<ParttimeEval> ptevallist = WorkmanService.getAllComPTEval(name);

			request.getSession().setAttribute("ptevalallcom", ptevallist);
			url = "pecrud/peview.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "해당 기업 모든 리뷰 글 조회 실패");
			log.info("해당 기업 모든 리뷰 글 조회 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void ptevalinsert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		String id = request.getParameter("userid");
		String comname = request.getParameter("companyname");
		String[] pclist = request.getParameterValues("proscons");
		String[] wagelist = request.getParameterValues("wagedelay");
		String[] envlist = request.getParameterValues("environment");
		String[] inclist = request.getParameterValues("incline");
		String opinion = request.getParameter("opinion");

		try {

			if (WorkmanService.addPTEval(id, comname, pclist, wagelist, envlist, inclist, opinion)) {

				request.setAttribute("msg", "알바 리뷰글 등록 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "알바 리뷰글 등록 실패");
			log.info("알바 리뷰 글 등록 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptevalupdatereq(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		int evalnum = Integer.valueOf(request.getParameter("evalnum"));

		try {

			request.getSession().setAttribute("peupdate", WorkmanService.getPTEval(evalnum));
			url = "pecrud/peupdate.jsp";

		} catch (Exception s) {

			request.setAttribute("msg", "알바 리뷰 글 갱신 요청 실패");
			log.info("알바 리뷰 글 갱신 요청 실패");
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptevalupdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		int evalnum = Integer.valueOf(request.getParameter("evalnum"));
		String[] pclist = request.getParameterValues("proscons");
		String[] wagelist = request.getParameterValues("wagedelay");
		String[] envlist = request.getParameterValues("environment");
		String[] inclist = request.getParameterValues("incline");
		String opinion = request.getParameter("opinion");

		try {

			if (WorkmanService.updatePTEval(evalnum, pclist, wagelist, envlist, inclist, opinion)) {

				request.setAttribute("msg", "알바 리뷰글 갱신 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "알바 리뷰글 갱신 실패");
			log.info("알바 리뷰글 갱신 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}

	public void ptevaldelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "view/error.jsp";

		int evalnum = Integer.valueOf(request.getParameter("evalnum"));

		try {

			if (WorkmanService.deletePTEval(evalnum)) {

				request.setAttribute("msg", "알바 리뷰글 삭제 완료");
				url = "view/message.jsp";

			} else {

				request.setAttribute("msg", "다시 시도하세요");

			}
		} catch (Exception s) {

			request.setAttribute("msg", "알바 리뷰글 삭제 실패");
			log.info("알바 리뷰글 삭제 실패");

		}

		request.getRequestDispatcher(url).forward(request, response);
	}
}
