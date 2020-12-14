package animal.view;

import java.util.ArrayList;

import animal.model.dto.PrivateInformation;
import animal.model.dto.Protocol;

public class EndView {
	
	// 진행중인 특정 프로젝트 출력
		public static void informationView(PrivateInformation information) {
			if (information != null) {
				System.out.println(information);
			} else {
				System.out.println("검색한 정보가 존재하지 않습니다.");
			}
		}
		
		
		
		public static void protocolView(Protocol p) {
			if (p != null) {
				System.out.println(p);
			} else {
				System.out.println("검색한 정보가 존재하지 않습니다.");
			}
		}
		

		// 진행중인 모든 프로젝트 출력
		public static void informationListView(ArrayList<PrivateInformation> allanimalInformation) {
			for (PrivateInformation information : allanimalInformation) {
				System.out.println(information);
			}
		}
		
		public static void protocolListView(ArrayList<Protocol> allanimalprotocol) {
			for (Protocol p : allanimalprotocol) {
				System.out.println(p);
			}
		}

		// 예외가 아닌 단순 메세지 출력
		public static void messageView(String message) {
			System.out.println(message);
		}



}
