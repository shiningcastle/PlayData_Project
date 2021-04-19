package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.util.PublicCommon;
import workman.model.dto.ParttimeList;

public class ParttimelistDAO {
	
	public static boolean addPTList(String companyname, String worktime, int hourlywage, String workperiod, String objective) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;
		
		try {
			
			Company com = CompanyDAO.getCompany(companyname);
			ParttimeList ptlist = ParttimeList.builder().companyname(com).worktime(worktime).hourlywage(hourlywage).workperiod(workperiod).objective(objective).build();
			
			
			com.getParttimelists().add(ptlist);
			em.persist(ptlist);
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


	public static boolean updatePTListWorktime(int listnum, String worktime) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, listnum);

			ptlist.setWorktime(worktime);
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

	public static boolean updatePTListHourlywage(int listnum, int hourlywage) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, listnum);

			ptlist.setHourlywage(hourlywage);
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
	
	public static boolean updatePTListWorkperiod(int listnum, String workperiod) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, listnum);

			ptlist.setWorkperiod(workperiod);
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
	
	public static boolean updatePTListObjective(int listnum, String objective) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, listnum);

			ptlist.setObjective(objective);
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

	public static boolean deletePTList(int listnum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			ParttimeList ptlist = em.find(ParttimeList.class, listnum);

			em.remove(ptlist);
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

	public static ParttimeList getPTList(int listnum) {

		EntityManager em = PublicCommon.getEntityManager();

		ParttimeList ptlist = null;

		try {

			ptlist = (ParttimeList) em.createNamedQuery("findptlist").setParameter("listnum", listnum).getSingleResult();
			
		} catch (Exception e) {

			e.printStackTrace();
			
		} finally {
			em.close();

		}
		
		return ptlist;
	}

	public static ArrayList<ParttimeList> getAllPTList() {

		EntityManager em = PublicCommon.getEntityManager();

		ArrayList<ParttimeList> ptlist = null;

		try {
			
			ptlist = (ArrayList<ParttimeList>) em.createNativeQuery("select * from parttimelist", ParttimeList.class)
					.getResultList();
			
		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {
			
			em.close();

		}
		
		return ptlist;
	}

}
