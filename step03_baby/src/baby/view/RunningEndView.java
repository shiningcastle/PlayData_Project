package baby.view;

import java.util.ArrayList;

import baby.model.dto.OrdersDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class RunningEndView {

	// 모든 검색 요청 출력
	public static void allListView(ArrayList alllist) {
		int length = alllist.size();
		for (int index = 0; index < length; index++) {
			System.out.println("검색정보 " + (index + 1) + " - " + alllist.get(index));
		}
		log.info("모든 검색 요청 출력 시도 총 " + length + "개의 결과");
	}

	// 모든 오더 출력
	public static void OrdersView(OrdersDTO orders) {
		System.out.println(orders);
		log.info("검색 오더 출력 :" + orders);
	}

	// 모든 출력
	public static void allView(Object all) {
		System.out.println(all);
		log.info("모든 출력:" + all);
	}

	// 이름을 가지고 와서 ""님 출력
	public static void nameView(Object name) {
		System.out.println("안녕하세요." + name + "님");
	}

	// 예외 상황 출력
	public static void showError(String message) {
		System.out.println(message);
		log.debug("예외 상황 발생 :" + message);
	}

	// 메세지 출력
	public static void showMessage(String message) {
		System.out.println("메세지 출력 :" + message);
	}
}
