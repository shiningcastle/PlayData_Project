package animal.service;

import java.util.ArrayList;
import animal.exception.DuplicateException;
import animal.exception.NotExistException;
import animal.model.PetDB;
import animal.model.ProtocolDB;
import animal.model.dto.PrivateInformation;
import animal.model.dto.Protector;
import animal.model.dto.Protocol;

public class PrivateInformationService {

	private static PrivateInformationService instance = new PrivateInformationService();
	private PetDB PetInformationData = PetDB.getInstance();
	private ProtocolDB recordData = ProtocolDB.getInstance();

	private PrivateInformationService() {}

	public static PrivateInformationService getInstance() {
		return instance;
	}

	/** 등록된 (방문이력이 있는) 모든 반려동물 및 보호자 정보 반환
	 * @return
	 */
	public ArrayList<PrivateInformation> getPetList() {
		return PetInformationData.getPetlist();
	}
	
	/**등록된 (방문이력이 있는) 모든 반려동물의 진료기록을 반환
	 * @return
	 */
	public ArrayList<Protocol> getProtocolList() {
		return recordData.getProtocolList();
	}
	
	/** 반려동물 이름을 기준으로 해당 PetDB(애완동물 및 보호자 정보) 반환
	 * @param petname
	 * @return
	 */
	public PrivateInformation getInformation(String petname) {
		ArrayList<PrivateInformation> petlist = getPetList();

		for (PrivateInformation temp : petlist) {
			if (temp.getPet().getPetName().equals(petname)) {
				return temp;
			}
		}
		return null;
	}
	
	/** 반려동물 이름을 기준으로 해당 ProtocolDB(진료기록) 반환
	 * @param petname
	 * @return
	 */
	public ArrayList<Protocol> getprotocol(String petname) {
		ArrayList<Protocol> protocollist = getProtocolList();
		ArrayList<Protocol> searchedList = new ArrayList<Protocol>();
		
		for (Protocol temp : protocollist) {
			if (temp.getPetName().equals(petname)) {
				searchedList.add(temp);
			}
		}
		return searchedList;
	}

	/** 신규 방문한 반려동물 정보 등록
	 * - petName(반려동물 이름)이 이미 존재할 경우 Duplicationexception 처리
	 * @param newinformation
	 * @throws DuplicateException
	 * @throws NullPointerException
	 */
	public void informationInsert(PrivateInformation newinformation) throws DuplicateException, NullPointerException {
		if (getInformation(newinformation.getPet().getPetName()) != null) {
			 throw new DuplicateException("이미 등록된 반려동물입니다.");
		} else {
			PetInformationData.insertInformation(newinformation);
		}
	}
	
	/** 반려동물의 보호자 정보 수정
	 * - petName이 존재한다면, 정보수정
	 * @param petName
	 * @param p
	 * @throws NotExistException
	 */
	public void informationPetUpdate(String petName, Protector p) throws NotExistException {
		PrivateInformation information = getInformation(petName);
		
		if(information == null) {
			throw new NotExistException("올바른 정보를 입력해주세요.");	//메시지 내용 수정해야함 
		} else {
			information.setProtector(p);
		}
	}
	
	/** 반려동물 및 보호자 정보(PrivateInformation) 삭제
	 * - petName으로 해당 정보를 삭제
	 * @param petName
	 * @throws Exception
	 */
	public void informationDelete (String petName) throws NullPointerException {
		PrivateInformation information = getInformation(petName);
		ArrayList<PrivateInformation> petList = getPetList();
		if(petName == null) {
			throw new NullPointerException("반려동물 이름을 입력해주세요.");
		}else {
			petList.remove(information);
		}
	}
	
}