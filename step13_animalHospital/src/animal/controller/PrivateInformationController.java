package animal.controller;

import java.util.ArrayList;

import animal.exception.DuplicateException;
import animal.exception.NotExistException;
import animal.model.dto.PrivateInformation;
import animal.model.dto.Protector;
import animal.model.dto.Protocol;
import animal.service.PrivateInformationService;
import animal.view.EndView;
import animal.view.FailView;

public class PrivateInformationController {

	private static PrivateInformationController instance = new PrivateInformationController();
	private PrivateInformationService service = PrivateInformationService.getInstance();

	private PrivateInformationController() {
	}

	public static PrivateInformationController getInstance() {
		return instance;
	}

	private ArrayList<PrivateInformation> petList = service.getPetList();
	private ArrayList<Protocol> protocolList = service.getProtocolList();

	public void getpetList() {
		if (petList.size() != 0) {
			EndView.informationListView(petList);
		} else {
			EndView.messageView("�ݷ����� ������ �������� �ʽ��ϴ�.");
		}
	}
	
	public void getprotocolList() {
		if (protocolList.size() != 0) {
			EndView.protocolListView(protocolList);
		} else {
			EndView.messageView("�Ƿ��� ������ �������� �ʽ��ϴ�.");
		}
	}

	public void getInformation(String petName) {
		if (petName != null) {
			PrivateInformation information = service.getInformation(petName);
			EndView.informationView(information);
		} else {
			FailView.failMessageView("�ݷ����� �̸��� �Է����ּ���.");
		}
	}
	
	public void getProtocol(String petName) {
		if (service.getprotocol(petName).size() != 0) {
			EndView.protocolListView(service.getprotocol(petName));
		} else {
			FailView.failMessageView("�ݷ����� ���̸��� �Է����ּ���.");
		}
	}
	
	/** �ű� �湮�� �ݷ����� ���� ���
	 * @param newInformation
	 */
	public void insertInformation(PrivateInformation newInformation) {
			try {
				service.informationInsert(newInformation);
			} catch (DuplicateException e) {
				FailView.failMessageView("�̹� ��ϵ� �ݷ������Դϴ�."); //
			} catch (NullPointerException e) {
				FailView.failMessageView("���� �����ϰ��� �ϴ� �̸��� �Է������� ��ȿ�մϴ�. ��Ȯ�����ּ���");
		}
	}
	
	/** �ݷ������� ��ȣ�� ���� ����
	 * @param petName
	 * @param p
	 */
	public void updateInformationPet(String petName, Protector p) {
		if (petName != null) {
			try {
				service.informationPetUpdate(petName, p);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			EndView.messageView("�����ϰ��� �ϴ� ��ȣ�� ������ ��ȿ�մϴ�. �� Ȯ�� ���ּ���.");
		}
	}

	/** �ݷ����� �� ��ȣ�� ����(PrivateInformation) ����
	 * @param petName
	 */
	public void deleteInformation(String petName) {
		if (petName != null) {
			try {
				service.informationDelete(petName);
				EndView.messageView(petName + " ������ ���������� �����Ͽ����ϴ�.");
			} catch (Exception e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			EndView.messageView("�������� �ʴ� �ݷ����� �̸��Դϴ�.");
		}
	}

}