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

	/** ��ϵ� (�湮�̷��� �ִ�) ��� �ݷ����� �� ��ȣ�� ���� ��ȯ
	 * @return
	 */
	public ArrayList<PrivateInformation> getPetList() {
		return PetInformationData.getPetlist();
	}
	
	/**��ϵ� (�湮�̷��� �ִ�) ��� �ݷ������� �������� ��ȯ
	 * @return
	 */
	public ArrayList<Protocol> getProtocolList() {
		return recordData.getProtocolList();
	}
	
	/** �ݷ����� �̸��� �������� �ش� PetDB(�ֿϵ��� �� ��ȣ�� ����) ��ȯ
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
	
	/** �ݷ����� �̸��� �������� �ش� ProtocolDB(������) ��ȯ
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

	/** �ű� �湮�� �ݷ����� ���� ���
	 * - petName(�ݷ����� �̸�)�� �̹� ������ ��� Duplicationexception ó��
	 * @param newinformation
	 * @throws DuplicateException
	 * @throws NullPointerException
	 */
	public void informationInsert(PrivateInformation newinformation) throws DuplicateException, NullPointerException {
		if (getInformation(newinformation.getPet().getPetName()) != null) {
			 throw new DuplicateException("�̹� ��ϵ� �ݷ������Դϴ�.");
		} else {
			PetInformationData.insertInformation(newinformation);
		}
	}
	
	/** �ݷ������� ��ȣ�� ���� ����
	 * - petName�� �����Ѵٸ�, ��������
	 * @param petName
	 * @param p
	 * @throws NotExistException
	 */
	public void informationPetUpdate(String petName, Protector p) throws NotExistException {
		PrivateInformation information = getInformation(petName);
		
		if(information == null) {
			throw new NotExistException("�ùٸ� ������ �Է����ּ���.");	//�޽��� ���� �����ؾ��� 
		} else {
			information.setProtector(p);
		}
	}
	
	/** �ݷ����� �� ��ȣ�� ����(PrivateInformation) ����
	 * - petName���� �ش� ������ ����
	 * @param petName
	 * @throws Exception
	 */
	public void informationDelete (String petName) throws NullPointerException {
		PrivateInformation information = getInformation(petName);
		ArrayList<PrivateInformation> petList = getPetList();
		if(petName == null) {
			throw new NullPointerException("�ݷ����� �̸��� �Է����ּ���.");
		}else {
			petList.remove(information);
		}
	}
	
}