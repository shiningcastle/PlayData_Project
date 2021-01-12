package workman.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import workman.model.dto.Company;
import workman.model.dto.Member;
import workman.model.util.PublicCommon;

public class MemberDAO {

	public static String mlogin(String id, String pw) {
		
		EntityManager em = PublicCommon.getEntityManager();
		
		String result = "success";
		String userid = null;
		String userpw = null;
		
		try {
			
			userid = (String) em.createNamedQuery("findmemid").setParameter("userid", id).getSingleResult();
			userpw = (String) em.createNamedQuery("findmempw").setParameter("userid", id).getSingleResult();
			
			if (!userpw.equals(pw)) {
				
				result = "pw";
				
			}
		} catch (Exception e) {
			
			result = "id";
			
		} finally {
			
			em.close();
			
		}
		
		return result;
	}

	public static String addMember(String userid, String companyname, String userpw, String username, String usernum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		String result = "success";

		try {
			
			Company company = em.find(Company.class, companyname);
			Member member = Member.builder().userid(userid).userpw(userpw).username(username).usernum(usernum).companyname(company).build();

			company.getMembers().add(member);
			
			em.persist(member);
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

	public static boolean updateMemberPw(String userid, String userpw) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Member member = em.find(Member.class, userid);
			member.setUserpw(userpw);
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

	public static boolean updateMemberName(String userid, String username) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Member member = em.find(Member.class, userid);
			member.setUsername(username);
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

	public static boolean updateMemberNum(String userid, String usernum) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Member member = em.find(Member.class, userid);
			member.setUsernum(usernum);
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

	public static boolean deleteMember(String userid) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		boolean result = false;

		try {

			Member member = em.find(Member.class, userid);
			em.remove(member);
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

	public static Member getMember(String userid) {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Member member = null;

		try {

			member = em.find(Member.class, userid);

		} catch (Exception e) {
			
			e.printStackTrace();

		} finally {

			em.close();

		}
		
		return member;
	}

	public static ArrayList<Member> getAllMember() {

		EntityManager em = PublicCommon.getEntityManager();

		ArrayList<Member> memlist = null;

		try {

			memlist = (ArrayList<Member>) em.createNativeQuery("select * from member", Member.class).getResultList();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			em.close();

		}
		
		return memlist;
	}

}
