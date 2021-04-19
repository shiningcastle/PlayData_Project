// 모든 DAO를 일괄 관리하는 클래스
package baby.model;

import java.sql.SQLException;
import java.util.ArrayList;

import baby.exception.NotExistException;
import baby.model.dto.ChildDTO;
import baby.model.dto.OrdersDTO;
import baby.model.dto.ParentDTO;
import baby.model.dto.SitterDTO;

public class OrdersService {

	private static OrdersService instance = new OrdersService();

	private OrdersService() {
	}

	public static OrdersService getInstance() {
		return instance;
	}

	// Child 아이 부분
	public static void notExistChild(String childid) throws NotExistException, SQLException {
		ChildDTO child = ChildDAO.getChild(childid);
		if (child == null) {
			throw new NotExistException("해당하는 아이가 미 존재합니다.");
		}
	}

	public static boolean addChild(ChildDTO child) throws SQLException {
		return ChildDAO.addChild(child);
	}

	public boolean deleteChild(String childid) throws SQLException, NotExistException {
		notExistChild(childid);
		return ChildDAO.deleteChild(childid);
	}

	public static ChildDTO getChild(String childid) throws SQLException, NotExistException {
		ChildDTO child = ChildDAO.getChild(childid);
		if (child == null) {
			throw new NotExistException("해당하는 아이가 미 존재합니다.");
		}
		return child;
	}

	public static ArrayList<ChildDTO> getAllChilds() throws SQLException {
		return ChildDAO.getAllChilds();
	}

	// Parent 부모 부분
	public static void notExistParent(String parentid) throws NotExistException, SQLException {
		ParentDTO parent = ParentDAO.getParent(parentid);
		if (parent == null) {
			throw new NotExistException("해당하는 부모가 미 존재합니다.");
		}
	}

	public static boolean addParent(ParentDTO parent) throws SQLException {
		return ParentDAO.addParent(parent);
	}

	public boolean deleteParent(String parentid) throws SQLException, NotExistException {
		notExistParent(parentid);
		return ParentDAO.deleteParent(parentid);
	}

	public static ParentDTO getParent(String parentid) throws SQLException, NotExistException {
		ParentDTO parent = ParentDAO.getParent(parentid);
		if (parent == null) {
			throw new NotExistException("해당하는 부모가 미 존재합니다.");
		}
		return parent;
	}

	// 부모 고유 아이디 ParentId 로 이름 출력하기
	public static String getParentName(String parentid) throws SQLException, NotExistException {
		String parentname = ParentDAO.getParentName(parentid);
		if (parentname == null) {
			throw new NotExistException("해당하는 부모가 미 존재합니다.");
		}
		return parentname;
	}

	public static ArrayList<ParentDTO> getAllParents() throws SQLException {
		return ParentDAO.getAllParents();
	}

	// Sitter 시터 부분
	public static void notExistSitter(String sitterid) throws NotExistException, SQLException {
		SitterDTO sitter = SitterDAO.getSitter(sitterid);
		if (sitter == null) {
			throw new NotExistException("해당하는 시터가 미 존재합니다.");
		}
	}

	public static boolean addSitter(SitterDTO sitter) throws SQLException {
		return SitterDAO.addSitter(sitter);
	}

	public boolean deleteSitter(String sitterid) throws SQLException, NotExistException {
		notExistSitter(sitterid);
		return SitterDAO.deleteSitter(sitterid);
	}

	public static SitterDTO getSitter(String sitterid) throws SQLException, NotExistException {
		SitterDTO sitter = SitterDAO.getSitter(sitterid);
		if (sitter == null) {
			throw new NotExistException("해당하는 시터가 미 존재합니다.");
		}
		return sitter;
	}

	public static ArrayList<SitterDTO> getAllSitters() throws SQLException {
		return SitterDAO.getAllSitters();
	}

	public static ArrayList<SitterDTO> getLocAllSitters(String loc) throws SQLException {
		return SitterDAO.getLocAllSitters(loc);
	}

	// Orders 오더 부분

	public static void notExistOrders(int orderid) throws NotExistException, SQLException {
		OrdersDTO orders = OrdersDAO.getOrders(orderid);
		if (orders == null) {
			throw new NotExistException("해당하는 오더가 미 존재합니다.");
		}
	}

	public static boolean addOrders(OrdersDTO orders) throws SQLException {
		return OrdersDAO.addOrders(orders);
	}

	public static boolean addmatchedOrders(String parentid, String sitterid) throws SQLException {
		return OrdersDAO.addmatchedOrders(parentid, sitterid);
	}

	public static boolean updateOrderSitter(int orderid, String sitterid) throws SQLException, NotExistException {
		notExistOrders(orderid);
		return OrdersDAO.updateOrdersSitter(orderid, sitterid);
	}

	public static boolean updateProbonoUserReceive(int orderid, String parentid)
			throws SQLException, NotExistException {
		notExistOrders(orderid);
		return OrdersDAO.updateOrdersParent(orderid, parentid);
	}

	public static boolean deleteOrders(int orderid) throws SQLException, NotExistException {
		notExistOrders(orderid);
		return OrdersDAO.deleteOrders(orderid);
	}

	// OrderId 오더 아이디로 존재 유무 검색

	public static OrdersDTO getOrders(int orderid) throws SQLException, NotExistException {
		OrdersDTO orders = OrdersDAO.getOrders(orderid);
		if (orders == null) {
			throw new NotExistException("검색하는 오더가 미 존재합니다.");
		}
		return orders;
	}

	public static ArrayList<OrdersDTO> getAllOrders() throws SQLException {
		return OrdersDAO.getAllOrders();
	}

	public static ArrayList<SitterDTO> matchedSitters(String parentid, String duration, int hourlywage)
			throws SQLException, NotExistException {

		return SitterDAO.matchedSitters(parentid, duration, hourlywage);
	}

}
