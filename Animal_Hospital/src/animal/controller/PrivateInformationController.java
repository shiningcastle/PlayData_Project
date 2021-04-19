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
			EndView.messageView("반려동물 정보가 존재하지 않습니다.");
		}
	}
	
	public void getprotocolList() {
		if (protocolList.size() != 0) {
			EndView.protocolListView(protocolList);
		} else {
			EndView.messageView("의료기록 정보가 존재하지 않습니다.");
		}
	}

	public void getInformation(String petName) {
		if (petName != null) {
			PrivateInformation information = service.getInformation(petName);
			EndView.informationView(information);
		} else {
			FailView.failMessageView("반려동물 이름을 입력해주세요.");
		}
	}
	
	public void getProtocol(String petName) {
		if (service.getprotocol(petName).size() != 0) {
			EndView.protocolListView(service.getprotocol(petName));
		} else {
			FailView.failMessageView("반려동물 펫이름을 입력해주세요.");
		}
	}
	
	/** 신규 방문한 반려동물 정보 등록
	 * @param newInformation
	 */
	public void insertInformation(PrivateInformation newInformation) {
			try {
				service.informationInsert(newInformation);
			} catch (DuplicateException e) {
				FailView.failMessageView("이미 등록된 반려동물입니다."); //
			} catch (NullPointerException e) {
				FailView.failMessageView("새로 저장하고자 하는 이름의 입력정보가 무효합니다. 재확인해주세요");
		}
	}
	
	/** 반려동물의 보호자 정보 수정
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
			EndView.messageView("수정하고자 하는 보호자 정보가 무효합니다. 재 확인 해주세요.");
		}
	}

	/** 반려동물 및 보호자 정보(PrivateInformation) 삭제
	 * @param petName
	 */
	public void deleteInformation(String petName) {
		if (petName != null) {
			try {
				service.informationDelete(petName);
				EndView.messageView(petName + " 정보를 정상적으로 삭제하였습니다.");
			} catch (Exception e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			EndView.messageView("존재하지 않는 반려동물 이름입니다.");
		}
	}

}