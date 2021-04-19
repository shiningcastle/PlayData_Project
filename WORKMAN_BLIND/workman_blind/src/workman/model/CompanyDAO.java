package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

import workman.model.dto.Company;
import workman.model.util.PublicCommon;

public class CompanyDAO {

	public static String clogin(String name, String pw) {
		
		EntityManager em = PublicCommon.getEntityManager();
		
		String result = "success";
		String comname = null;
		String compw = null;
	
		try {
			
			comname = (String) em.createNamedQuery("findcomname").setParameter("companyname", name).getSingleResult();
			compw = (String) em.createNamedQuery("findcompw").setParameter("companyname", name).getSingleResult();
			
			if (!compw.equals(pw)) {
				
				result = "pw";
				
			}
		} catch (Exception e) {
			
			result = "id";
			
		} finally {
			
			em.close();
			
		}
		
		return result;
	}

	public static String addCompany(String companyname, String companypw, String category, String companyloc,
			String companynum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String result = "success";

		try {

			Company company = Company.builder().companyname(companyname).companypw(companypw).companyloc(companyloc)
					.companynum(companynum).category(category).build();

			em.persist(company);
			tx.commit();

		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();
			result = "fail";

		} finally {

			em.close();
			

		}
		
		return result;
	}
	
	public static boolean updateCompanyPW(String companyname, String companypw) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Company company = em.find(Company.class, companyname);

			company.setCompanypw(companypw);
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

	public static boolean updateCompanyCategory(String companyname, String category) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Company company = em.find(Company.class, companyname);

			company.setCategory(category);
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
	
	
	public static boolean updateCompanyNum(String companyname, String companynum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Company company = em.find(Company.class, companyname);

			company.setCompanynum(companynum);
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

	public static boolean updateCompanyLoc(String companyname, String companyloc) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Company company = em.find(Company.class, companyname);

			company.setCompanyloc(companyloc);
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

	public static boolean deleteCompany(String companyname) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;
		
		String sql = "delete from company where company_name=?";

		try {
			
			int deletesuccess = em.createNativeQuery(sql).setParameter(1, companyname).executeUpdate();

			if (deletesuccess == 1) {
				
				result = true;
				
			}
			
			tx.commit();


		} catch (Exception e) {

			tx.rollback();
			e.printStackTrace();

		} finally {

			em.close();

		}
		
		return result;
	}
	
	public static Company getCompany(String companyname) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		Company company = null;

		try {

			company = em.find(Company.class, companyname);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			em.close();

		}
		
		return company;
	}

	public static ArrayList<Company> getAllCompany() {

		EntityManager em = PublicCommon.getEntityManager();

		ArrayList<Company> comlist = null;

		try {
			
			comlist = (ArrayList<Company>) em.createNativeQuery("select * from company", Company.class).getResultList();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			em.close();

		}
		
		return comlist;	
	}

}
