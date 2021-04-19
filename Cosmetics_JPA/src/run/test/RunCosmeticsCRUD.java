package run.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import model.domain.Component;
import model.domain.Connection;
import model.domain.Cosmetics;
import util.PublicCommon;

@Slf4j
public class RunCosmeticsCRUD {

	// CREATE
		public static void createComponent(EntityManager em, String comname, String function, int risk, String harmful) {
			Component com = Component.builder().comname(comname).function(function).riskdegree(risk).harmful(harmful)
					.con(new ArrayList<>()).build();
			em.persist(com);
			
			log.info("관계자 - 화장품 성분 " + comname + " 추가");
		}

		public static void createCosmetics(EntityManager em, String cosname, String category, int price, String capacity) {
		
			Cosmetics cos = Cosmetics.builder().cosname(cosname).category(category).price(price).capacity(capacity)
					.con(new ArrayList<>()).build();

			em.persist(cos);
			System.out.println(cos.getCosname() + "이 판매 상품 목록에 추가되었습니다");
			
			log.info("관계자 - 판매 상품 " + cosname + " 추가");
		}

		public static void createConnection(EntityManager em, int comid, int cosid) {

			Component com = getComponent(em, comid);
			Cosmetics cos = getCosmetics(em, cosid);

			Connection con = Connection.builder().com(com).cos(cos).build();

			com.getCon().add(con);
			cos.getCon().add(con);

			em.persist(con);
			em.persist(com);
			em.persist(cos);
			
			log.info("관계자 - 화장품 " + cosid + "번 성분 추가");

		}

	
	//UPDATE
	
	// 관리자용 검색창
	// 통합 관리창
	public static void seeAll(EntityManager em, int cosid, int comid) {
		if (cosid == 1 && comid == 0) {

			String jpql1 = "select c from Cosmetics c";

			List<Cosmetics> cosmetics = em.createQuery(jpql1, Cosmetics.class).getResultList();

			for (int i = 0; i < cosmetics.size(); i++) {
				System.out.println(cosmetics.get(i));
			}
		}

		else if (cosid == 0 && comid == 1) {

			String jpql2 = "select c from Component c";

			List<Component> components = em.createQuery(jpql2, Component.class).getResultList();

			for (int i = 0; i < components.size(); i++) {
				System.out.println(components.get(i));

			}
		}

		else {

			System.out.println("");
		} log.info("관계자  - 화장품 " + cosid + "번 또는 성분 " + comid + "번 정보 조회");
	}

	// 성분 ID로 성분 조회 
		public static Component getComponent(EntityManager em, int comid) {
			
			String jpql = "select c from Component c where c.comid = :blank";
			
			TypedQuery<Component> query = em.createQuery(jpql, Component.class);
			query.setParameter("blank", comid);

			Component com = query.getSingleResult();
			
			log.info("고객 - 성분 " + comid + "번 확인");
			return com;
			
		}
		
	// 성분 이름으로  성분 조회
		//Native query(=JPQL 문법 말고 원래 SQL문법으로 JPA처럼 사용) 사용해서 이름으로 해당값 조회
		// 성분 이름은 겹치는게 없음
	public static void findComponentbyName(EntityManager em, String comname) {
		try {
			
			Component com = (Component) em
					.createNativeQuery("select * from component where com_name = ?", Component.class)
					.setParameter(1, comname).getSingleResult();
			
			System.out.println("----- 해당 성분 정보 -----");
			System.out.println(com);
			
			System.out.println("----- 해당 성분을 함유한 제품-----");
			
			for (int i = 0; i < com.getCon().size(); i++) {
				System.out.println(com.getCon().get(i).getCos().getCosname() + " ( " + "id = "
						+ com.getCon().get(i).getCos().getCosid() + " )");
			
			}
			
		} catch (Exception e) {
			System.out.println("해당 이름의 성분은 미존재합니다");
			
		} log.info("고객 - 화장품 성분 조회 : " + comname);
	}
		
	// 화장품 전체 리스트 보기
	public static void seeCosmeticsAll(EntityManager em) {

		String jpql = "select c from Cosmetics c";

		List<Cosmetics> c = em.createQuery(jpql, Cosmetics.class).getResultList();

		System.out.println("----- 전체 상품 리스트 -----");
	
		for (int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i));
		}  log.info("고객 - 전체 화장품 리스트 조회");
	}

	public static Cosmetics getCosmetics(EntityManager em, int cosid) {

		String jpql = "select c from Cosmetics c where c.cosid = :blank";

		TypedQuery<Cosmetics> query = em.createQuery(jpql, Cosmetics.class);
		query.setParameter("blank", cosid);

		Cosmetics cos = query.getSingleResult();

		log.info("고객 - 화장품 " + cosid + "번 조회");
		return cos;
		
	}

	public static void findComponentbyHarmful(EntityManager em, String harmful) {

		List<Component> comlist = em.createNativeQuery("select * from component where harmful = ?", Component.class)
				.setParameter(1, harmful).getResultList();

		if (comlist.size() != 0) {

			System.out.println("----- 해당 성분 정보 -----");
			for (int i = 0; i < comlist.size(); i++) {

				System.out.println(comlist.get(i));

			}

			System.out.println("----- 해당 성분을 함유한 제품-----");
			// comlist 사이즈와 안에 con객체 안에 들어간 사이즈는 다름 for문 두번 돌려서 다 추출
			for (int i = 0; i < comlist.size(); i++) {

				for (int j = 0; j < comlist.get(i).getCon().size(); j++) {

					System.out.println(comlist.get(i).getCon().get(j).getCos().getCosname() + " ( " + "id = "
							+ comlist.get(i).getCon().get(j).getCos().getCosid() + " )");

				}

				System.out.println("---------------");

			}

		} else {

			System.out.println("해당 성분은 미존재합니다");

		} log.info("고객 - 화장품 위험 성분 조회 : " + harmful);
	}
	
	
	// SELECT
	public static void findComponentbyId(EntityManager em, int comid) {

		Component com = em.find(Component.class, comid);

		if (com != null) {

			System.out.println("----- 해당 성분 정보 -----");
			System.out.println(com);

			System.out.println("----- 해당 성분을 함유한 제품-----");
			for (int i = 0; i < com.getCon().size(); i++) {

				System.out.println(com.getCon().get(i).getCos().getCosname() + " ( " + "id = "
						+ com.getCon().get(i).getCos().getCosid() + " )");

			}

		} else {

			System.out.println("해당 id의 성분은 미존재합니다");

		} log.info("관계자 - 성분 " + comid + "번 조회");
	}

	public static void findCosmeticsbyId(EntityManager em, int cosid) {

		Cosmetics cos = em.find(Cosmetics.class, cosid);

		if (cos != null) {

			System.out.println("----- 해당 제품 정보 -----");
			System.out.println(cos);

			System.out.println("----- 해당 제품에 함유된 성분-----");
			for (int i = 0; i < cos.getCon().size(); i++) {

				System.out.println(cos.getCon().get(i).getCom().getComname() + " ( " + "id = "
						+ cos.getCon().get(i).getCom().getComid() + " )");
			}

		} else {

			System.out.println("해당 id의 화장품은 미존재합니다");

		} log.info("관계자 - 화장품 " + cosid + "번의 포함 성분 조회");

	}

	// 해당 가격 이하의 전 상품 모두 출력
	public static void findCosmeticstbyPrice(EntityManager em, int price) {
		List<Cosmetics> coslist = em.createNativeQuery("select * from cosmetics where price <= ?", Cosmetics.class)
				.setParameter(1, price).getResultList();
		if (coslist.size() != 0) {
			System.out.println("----- 해당 화장품 정보 -----");
			for (int i = 0; i < coslist.size(); i++) {
				System.out.println(coslist.get(i));
			}
			System.out.println("----- 해당 화장품에 함유된 성분-----");
			for (int i = 0; i < coslist.size(); i++) {
				for (int j = 0; j < coslist.get(i).getCon().size(); j++) {
					System.out.println(coslist.get(i).getCon().get(j).getCom().getComname() + " ( " + "id = "
							+ coslist.get(i).getCon().get(j).getCom().getComid() + " )");
				}
				System.out.println("---------------");
			}
			
		} else {
			System.out.println("해당 이름의 화장품은 미존재합니다");
			
		} log.info("고객 - " + price + "원 미만 가격 조회");
	}

	// Native query(=JPQL 문법 말고 원래 SQL문법으로 JPA처럼 사용) 사용해서 이름으로 해당값 조회
	// 화장품 이름은 겹치는게 없음
	public static void findCosmeticstbyName(EntityManager em, String cosname) {
	
		Cosmetics cos = (Cosmetics) em.createNativeQuery("select * from cosmetics where cos_name = ?", Cosmetics.class)
				.setParameter(1, cosname).getSingleResult();
		
		if (cos != null) {
		
			System.out.println("----- 해당 화장품 정보 -----");
			System.out.println(cos);
			
			System.out.println("----- 해당 화장품에 함유된 성분-----");
				for (int i = 0; i < cos.getCon().size(); i++) {
				System.out.println(cos.getCon().get(i).getCom().getComname() + " ( " + "id = "
						+ cos.getCon().get(i).getCom().getComid() + " )");
			}
				
		} else {
			System.out.println("해당 이름의 화장품은 미존재합니다");
		
		} log.info("고객 - 화장품 " + cosname + " 검색");
	}

	// UPDATE

	//성분의 위험도 숫자  업데이트 변경
	// UPDATE ComponentRisk
	public static void updateComponentRisk(EntityManager em, int comid, int riskdegree) {
	
		Component com = em.find(Component.class, comid);
	
		if (com != null) {
	
			if (com.getRiskdegree() == 0) {
				System.out.println("위험도 변경 전 : " + com);
		
				com.setRiskdegree(riskdegree);
				System.out.println("위험도 변경 후 : " + com);
				System.out.println("<주의> 해당 성분이 유해한 성분으로 지정되었습니다");
			
			} else {
			
				System.out.println("위험도 변경 전 : " + com);
				com.setRiskdegree(riskdegree);
			
				if (com.getRiskdegree() == 0) {
				
					System.out.println("위험도 변경 후 : " + com);
					System.out.println("<주의> 해당 성분이 무해한 성분으로 지정되었습니다");
				
				} else {
				
					System.out.println("위험도 변경 후 : " + com);
			
				} 
			}
		
		} else {
		
			System.out.println("해당하는 id의 성분을 찾을 수 없습니다");
			System.out.println("해당 성분의 위험도 변경 실패");
		
		} log.info("관계자 - 성분 " + comid + "의 위험도 수정 : " + riskdegree);
	}

	// UPDATE - 상품 성분 변경
	public static void updateConbyCosmetics(EntityManager em, int beforecomid, int aftercomid, int cosid) {

		Cosmetics cos = em.find(Cosmetics.class, cosid);

		if (cos != null) {

			for (int i = 0; i < cos.getCon().size(); i++) {

				if (cos.getCon().get(i).getCom().getComid() == beforecomid) {

					Connection con = cos.getCon().get(i);
					Component com = em.find(Component.class, aftercomid);

					System.out.println(
							"변경 전 Connection id : " + con.getId() + " 성분 : " + con.getCom() + " 제품 : " + con.getCos());
					con.setCom(com);
					System.out.println(
							"변경 후 Connection id : " + con.getId() + " 성분 : " + con.getCom() + " 제품 : " + con.getCos());

				} 

			}

		} else {

			System.out.println("해당하는 id의 화장품을 찾을 수 없습니다");
			System.out.println("화장품 성분 변경 실패");

		} log.info("관계자 - "+ cosid + "의 성분 " + beforecomid + "에서 " + aftercomid + "로 변경");
	}

	// UPDATE - 상품 가격 변경
	public static void updateCosmeticPriceById(EntityManager em, int cosid, int price) {
		Cosmetics cos = em.find(Cosmetics.class, cosid);

		// before update
		System.out.println("가격 update 전 : " + cos);

		// after update
		cos.setPrice(price);
		System.out.println("가격 update 후 : " + cos);
	}

	// UPDATE - 상품 이름 변경
	public static void updateCosmeticNameById(EntityManager em, int cosid, String cosname) {
		Cosmetics cos = em.find(Cosmetics.class, cosid);

		// before update
		System.out.println("이름 update 전 : " + cos);

		// after update
		cos.setCosname(cosname);
		System.out.println("이름 update 후 : " + cos);
		
		log.info("관계자 - "+ cosid + "번의 상품명" +  cosname + "으로 변경");
	}
	
	// UPDATE - 상품 용량 변경
	public static void updateCosmetiCapacityById(EntityManager em, int cosid, String capacity) {
		Cosmetics cos = em.find(Cosmetics.class, cosid);

		// before update
		System.out.println("용량 update 전 : " + cos);

		// after update
		cos.setCapacity(capacity);
		System.out.println("용량 update 후 : " + cos);
		
		log.info("관계자 - "+ cosid + "번의 상품용량 " +  capacity + "로 변경");
	}


	// DELETE Component
		// Component ID만 가지고 해당 관련된 Connection과 Cosmetics 일괄 제거
		// Component 삭제시 해당 케이스에 연결된 Connection을 전부 삭제해줘야 삭제 가능
		// 삭제 시 순서 : 관련 Connection값들  먼저 삭제 - 관련 Component 값들 삭제가 불가능해서 null, 0으로 바꿔줌, 관련 Cosmetics값들 삭제
	
		public static void deleteComponent(EntityManager em, int comid) {

			Component com = em.find(Component.class, comid);
			
			System.out.println(com.getComname() + "이 성분 정보 목록에서 삭제되었습니다");
			
			for (int i = 0; i < com.getCon().size(); i++) {
				
				int conid = com.getCon().get(i).getId();
				Connection con = em.find(Connection.class, conid);
				em.remove(con);
								
				int cosid = com.getCon().get(i).getCos().getCosid();
				Cosmetics cos = em.find(Cosmetics.class, cosid);
				
				for (int j = 0; j < cos.getCon().size(); j++) {
	
					if (cos.getCon().get(j).getCom().getComid() == comid) {
						
						cos.getCon().get(j).getCom().setComid(0);
						cos.getCon().get(j).getCom().setComname(null);
					
						em.remove(cos.getCon().get(j));
						
					}
					
				}
		
				em.remove(com.getCon().get(i));
				em.remove(com);
			} log.info("관계자 - 성분 "+ comid + "번 삭제");
		}
		
	@Test
	public void runJPQLTest() {

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {

			createComponent(em, "파라벤", "산화방지제", 1, "YES");
			createComponent(em, "미네랄 오일", "피부컨디셔닝제", 1, "YES");
			createComponent(em, "물", "수분", 0, "NO");
			createComponent(em, "시어버터", "유분", 0, "NO");
			createComponent(em, "모로칸오일", "유분, 주름 방지", 0, "NO");

			createCosmetics(em, "퓨어 클렌징 오일", "클렌징", 19900, "400ml");
			createCosmetics(em, "데일리보습크림", "크림", 27800, "200ml");
			createCosmetics(em, "에센셜 마스크", "마스크팩", 8900, "11EA");
			createCosmetics(em, "탱글수분크림", "크림", 39000, "100ml");
			createCosmetics(em, "아크네 수딩크림", "크림", 25200, "130ml");
			createCosmetics(em, "ATOZ 아토피", "크림", 29200, "190ml");
			createCosmetics(em, "올클리어 토너", "스킨/토너", 30000, "700ml");
			createCosmetics(em, "잡티OUT  세럼", "세럼", 39500, "80ml");
			createCosmetics(em, "바이오 트리플 앰플", "세럼", 35000, "150ml");
			createCosmetics(em, "딸기  세럼플러스", "세럼", 31500, "125ml");

			createConnection(em, 1, 1);
			createConnection(em, 3, 1);
			createConnection(em, 1, 2);
			createConnection(em, 2, 2);
			createConnection(em, 3, 3);
			createConnection(em, 1, 4);
			createConnection(em, 3, 4);
			createConnection(em, 1, 5);
			createConnection(em, 2, 5);
			createConnection(em, 3, 5);
			createConnection(em, 2, 6);
			createConnection(em, 3, 6);
			createConnection(em, 2, 7);
			createConnection(em, 3, 7);
			createConnection(em, 3, 8);
			createConnection(em, 4, 8);
			createConnection(em, 5, 8);
			createConnection(em, 1, 9);
			createConnection(em, 2, 9);
			createConnection(em, 3, 9);
			createConnection(em, 4, 9);
			createConnection(em, 5, 9);
			createConnection(em, 3, 10);
			createConnection(em, 4, 10);
			createConnection(em, 5, 10);

//1. 화장품 회사(김연지)		
			System.out.println("==== 성분 리스트 보기 ====");
			seeAll(em, 0, 1);
			System.out.println();

//			System.out.println("==== 성분 리스트에서 '페놀' 찾기 ====");
//			findComponentbyName(em, "페놀");
//			System.out.println();		

//			System.out.println("==== 성분 리스트에 페놀 추가 ====");
//			createComponent(em, "페놀", "방부제", 0, "NO");
//			seeAll(em, 0, 1);
//			System.out.println();

//			System.out.println("==== '퓨어 클렌징 오일'의 성분을 '파라벤'에서 '페놀'로 변경 ====");
//			updateConbyCosmetics(em, 1, 6, 1);
//			System.out.println();
//
//			System.out.println("==== '파라벤'이 들어간 화장품 목록 확인 ====");
//			findComponentbyName(em, "파라벤");
//			System.out.println();

//			System.out.println("==== '파라벤'의 유해물질 위험도 3으로 상승 ====");
//			updateComponentRisk(em, 1, 3);
//			System.out.println();
//			
//			System.out.println("==== '모로칸 오일'의 유해물질 위험도 0에서 1으로 상승 ====");
//			updateComponentRisk(em, 5, 1);
//			System.out.println();
//			
//			System.out.println("==== '물'의 전체 정보를 성분리스트에서 삭제 ====");
//			deleteComponent(em, 3);
//			System.out.println();
			
//2. 화장품 판매처 (고은비)
			// 상품 리스트 보기
//			System.out.println("==== 전체 상품 리스트 보기 ====");
//			seeCosmeticsAll(em);
//			System.out.println();

//			System.out.println("====  '퓨어 클렌징 오일' 가격 변경 ====");
//			updateCosmeticPriceById(em, 1, 15900);
//			System.out.println();

//			System.out.println("====  '아크네 클리어 수딩 크림' 이름 및 용량 변경 ====");
//			updateCosmeticNameById(em, 5, "아크네 클리어 수딩 크림 1+1");
//			updateCosmetiCapacityById(em, 5, "260ml");
//			System.out.println();

//			System.out.println("====  '니베아 립밤 민트초코향' 상품 추가 ====");
//			createCosmetics(em, "니베아 립밤 민트초코향", "립밤", 5000, "20ml");
//			createConnection(em, 6, 11);
//			createConnection(em, 4, 11);
//			System.out.println();


//3. 고객용 (권희성)
			
//			// 상품 리스트 보기
//			System.out.println("==== 판매중인 화장품 전체 목록 보기 ====");
//			seeCosmeticsAll(em);
//			System.out.println();

//			System.out.println("==== 유해물질 없는 화장품 목록 보기 ====");
//			findComponentbyHarmful(em, "NO");
//			System.out.println();

//			System.out.println("==== 화장품 이름으로 화장품 정보 찾기 ====");
//			findCosmeticstbyName(em, "퓨어 클렌징 오일");
//			System.out.println();
			
//			System.out.println("==== 5000원 이하 가격대의 화장품 찾기 ====");
//			findCosmeticstbyPrice(em, 5000);

			tx.commit();

		} catch (Exception e) {

			em.getTransaction().rollback();
			e.printStackTrace();

		} finally {

			em.close();
		}

	}
}
