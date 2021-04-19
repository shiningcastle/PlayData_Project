package workman.model;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.util.PublicCommon;
import workman.model.dto.ParttimeEval;

public class ParttimeEvalDAO {

	public static boolean addPTEval(String userid, String companyname, String[] pclist, String[] wagelist,
			String[] envlist, String[] inclist, String opinion) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Member member = em.find(Member.class, userid);
			Company company = em.find(Company.class, companyname);

			String proscons = String.join(",", pclist);
			String wagedelay = String.join(",", wagelist);
			String environment = String.join(",", envlist);
			String incline = String.join(",", inclist);

			ParttimeEval pteval = ParttimeEval.builder().userid(member).companyname(company).proscons(proscons)
					.wagedelay(wagedelay).environment(environment).incline(incline).opinion(opinion).build();

			member.getParttimeevals().add(pteval);
			company.getParttimeevals().add(pteval);

			em.persist(pteval);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}

		return result;
	}

	public static boolean updatePTEval(int evalnum, String[] pclist, String[] wagelist, String[] envlist,
			String[] inclist, String opinion) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, evalnum);

			String proscons = String.join(",", pclist);
			String wagedelay = String.join(",", wagelist);
			String environment = String.join(",", envlist);
			String incline = String.join(",", inclist);

			pteval.setProscons(proscons);
			pteval.setWagedelay(wagedelay);
			pteval.setEnvironment(environment);
			pteval.setIncline(incline);
			pteval.setOpinion(opinion);

			tx.commit();
			result = true;

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}

		return result;
	}

	public static boolean deletePTEval(int evalnum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeEval pteval = em.find(ParttimeEval.class, evalnum);

			em.remove(pteval);
			tx.commit();

			result = true;

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}

		return result;
	}

	public static ParttimeEval getPTEval(int evalnum) {

		EntityManager em = PublicCommon.getEntityManager();

		ParttimeEval pteval = null;

		try {

			pteval = em.find(ParttimeEval.class, evalnum);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			em.close();

		}

		return pteval;
	}

	public static ArrayList<ParttimeEval> getAllComPTEval(String companyname) {

		EntityManager em = PublicCommon.getEntityManager();

		ArrayList<ParttimeEval> ptevallist = null;

		try {
			ptevallist = (ArrayList<ParttimeEval>) em
					.createNativeQuery("select * from parttimeeval where company_name = ?", ParttimeEval.class)
					.setParameter(1, companyname).getResultList();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			em.close();

		}

		return ptevallist;
	}
}
