package baby.view;

import java.util.Scanner;

import baby.controller.OrdersController;

public class RunningStartView {

	public static void main(String[] args) {

		search();
		
		System.out.println("------ 새로운 오더 아이디가 들어갔는지 확인 ------");
		OrdersController.getAllOrders();

	}

	private static void search() {
		OrdersController controller = OrdersController.getInstance();

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("안녕하세요 권시터에 오신걸 환영합니다.");

			System.out.print("\nID 를 입력해주세요. : ");
			String parentid = sc.nextLine();

			controller.getParentName(parentid);

			// Parent data에서 네임 추출
			System.out.println("\n어느 기간동안 필요하신가요? 1.장기, 2.단기, 3.1일, 4.입주");
			String duration = sc.nextLine();

			System.out.println("예상하는 시터 페이를 입력해주세요. (예: 10000)");
			int hourlywage = Integer.parseInt(sc.nextLine());

			System.out.println("딱 맞는 근처 시터들의 정보입니다.");
			controller.matchedSitters(parentid, duration, hourlywage);

			System.out.print("원하시는 시터의 id를 입력해주세요. : ");
			String sitterid = sc.nextLine();
			controller.addmatchedOrders(parentid, sitterid);

		} catch (Exception s) {
			s.printStackTrace();
			throw s;
		}
	}

}
