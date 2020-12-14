package animal.view;

import java.util.ArrayList;

import animal.model.dto.PrivateInformation;
import animal.model.dto.Protocol;

public class EndView {
	
	// �������� Ư�� ������Ʈ ���
		public static void informationView(PrivateInformation information) {
			if (information != null) {
				System.out.println(information);
			} else {
				System.out.println("�˻��� ������ �������� �ʽ��ϴ�.");
			}
		}
		
		
		
		public static void protocolView(Protocol p) {
			if (p != null) {
				System.out.println(p);
			} else {
				System.out.println("�˻��� ������ �������� �ʽ��ϴ�.");
			}
		}
		

		// �������� ��� ������Ʈ ���
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

		// ���ܰ� �ƴ� �ܼ� �޼��� ���
		public static void messageView(String message) {
			System.out.println(message);
		}



}
