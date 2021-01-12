package workman.model;

import java.util.ArrayList;

import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.dto.ParttimeEval;
import workman.model.dto.ParttimeList;

public class WorkmanService {

//	 company

	public static String clogin(String name, String pw) {
		return CompanyDAO.clogin(name, pw);
	}

	public static String addCompany(String companyname, String companypw, String category, String companyloc,
			String companynum) {
		return CompanyDAO.addCompany(companyname, companypw, category, companyloc, companynum);
	}

	public static boolean updateCompanyPW(String companyname, String companypw) {

		return CompanyDAO.updateCompanyPW(companyname, companypw);
	}

	public static boolean updateCompanyCategory(String companyname, String category) {

		return CompanyDAO.updateCompanyCategory(companyname, category);
	}

	public static boolean updateCompanyNum(String companyname, String companynum) {

		return CompanyDAO.updateCompanyNum(companyname, companynum);
	}

	public static boolean updateCompanyLoc(String companyname, String companyloc) {

		return CompanyDAO.updateCompanyLoc(companyname, companyloc);
	}

	public static boolean deleteCompany(String companyname) {

		return CompanyDAO.deleteCompany(companyname);
	}

	public static Company getCompany(String companyname) {

		return CompanyDAO.getCompany(companyname);
	}

	public static ArrayList<Company> getAllCompany() {

		return CompanyDAO.getAllCompany();
	}

	// member

	public static String mlogin(String id, String pw) {
		return MemberDAO.mlogin(id, pw);
	}

	public static String addMember(String userid, String companyname, String userpw, String username, String usernum) {
		return MemberDAO.addMember(userid, companyname, userpw, username, usernum);
	}

	public static boolean updateMemberPW(String userid, String userpw) {

		return MemberDAO.updateMemberPw(userid, userpw);
	}

	public static boolean updateMemberName(String userid, String username) {

		return MemberDAO.updateMemberName(userid, username);
	}

	public static boolean updateMemberNum(String userid, String usernum) {

		return MemberDAO.updateMemberNum(userid, usernum);
	}

	public static boolean deleteMember(String userid) {

		return MemberDAO.deleteMember(userid);
	}

	public static Member getMember(String userid) {

		return MemberDAO.getMember(userid);
	}

	public static ArrayList<Member> getAllMember() {

		return MemberDAO.getAllMember();

	}

	// parttimelist (add가 회원과 기업만 boolean 아니고 string 반환, 이것들만 성공메세지 페이지로 가기 위해)

	public static boolean addPTList(String companyname, String worktime, int hourlywage, String workperiod,
			String objective) {
		return ParttimelistDAO.addPTList(companyname, worktime, hourlywage, workperiod, objective);
	}

	public static boolean updatePTListWorktime(int listnum, String worktime) {

		return ParttimelistDAO.updatePTListWorktime(listnum, worktime);
	}

	public static boolean updatePTListHourlywage(int listnum, int hourlywage) {

		return ParttimelistDAO.updatePTListHourlywage(listnum, hourlywage);
	}

	public static boolean updatePTListWorkperiod(int listnum, String workperiod) {

		return ParttimelistDAO.updatePTListWorkperiod(listnum, workperiod);
	}

	public static boolean updatePTListObjective(int listnum, String objective) {

		return ParttimelistDAO.updatePTListObjective(listnum, objective);
	}

	public static boolean deletePTList(int listnum) {

		return ParttimelistDAO.deletePTList(listnum);
	}

	public static ParttimeList getPTList(int listnum) {

		return ParttimelistDAO.getPTList(listnum);
	}

	public static ArrayList<ParttimeList> getAllPTList() {

		return ParttimelistDAO.getAllPTList();
	}

	// parttimeeval

	public static boolean addPTEval(String userid, String companyname, String[] pclist, String[] wagelist,
			String[] envlist, String[] inclist, String opinion) {

		return ParttimeEvalDAO.addPTEval(userid, companyname, pclist, wagelist, envlist, inclist, opinion);
	}

	public static boolean updatePTEval(int evalnum, String[] pclist, String[] wagelist, String[] envlist,
			String[] inclist, String opinion) {

		return ParttimeEvalDAO.updatePTEval(evalnum, pclist, wagelist, envlist, inclist, opinion);
	}

	public static boolean deletePTEval(int evalnum) {

		return ParttimeEvalDAO.deletePTEval(evalnum);
	}

	public static ParttimeEval getPTEval(int evalnum) {

		return ParttimeEvalDAO.getPTEval(evalnum);

	}

	public static ArrayList<ParttimeEval> getAllComPTEval(String companyname) {

		return ParttimeEvalDAO.getAllComPTEval(companyname);
	}

}
