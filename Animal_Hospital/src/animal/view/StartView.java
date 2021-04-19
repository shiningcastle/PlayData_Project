package animal.view;

import animal.controller.PrivateInformationController;
import animal.model.dto.Pet;
import animal.model.dto.PrivateInformation;
import animal.model.dto.Protector;

public class StartView {

	public static void main(String[] args) {
		
		PrivateInformationController controller = PrivateInformationController.getInstance();
		
		System.out.println("\n*** 01. �湮�� ��� �ݷ����� ��� �˻� ***");
		controller.getpetList();
		
		System.out.println("\n*** 02. ������ �̸��� ������ �˻� ***");
		controller.getInformation("����");
		
		System.out.println("\n*** 03. ��ϵ��� ���� �ݷ����� �̸� �˻� ***"); // �������� ù �湮
		controller.getInformation("����");
		
		System.out.println("\n*** 04. ù �湮�� �ݷ����� DB��� ***");
		PrivateInformation newinformation = new PrivateInformation(new Pet("����", "cat","russian blue", "grey", "male", "071013", 13),
				(new Protector("������", 98563723, "����Ư����ġ�� ���ֽ� �ֿ���", "����")));
		
		System.out.println("\n*** 04-1. �űԵ�� �� �ݷ����� ��� �˻� ***");
		controller.getpetList();
	
		controller.insertInformation(newinformation);
		System.out.println("\n*** 04-2. ������ �� �ݷ����� ��� �˻� ***");
		controller.getpetList();
		
		System.out.println("\n*** 05. �ں��� ������ ��ȸ ***"); // �� �湮
		controller.getProtocol("�ں�");
		
		System.out.println("\n05-1. �̹� ����� ������Ʈ ������ �õ��� ��ȿ�� ������ ���ռ� ����");
		controller.insertInformation(newinformation);
		
		System.out.println("\n*** 06. �湮�̷��� �ִ� '����' ��ȣ���� ���� ���� �� ������ ���� �˻� **");
		System.out.println("06-1. ���� �� ������Ʈ �˻�");
		controller.getInformation("����");
		controller.updateInformationPet("����", new Protector("������", 41814875, "����Ư���� ������", "����"));
		System.out.println("06-2. ���� ��  ������Ʈ �˻�");
		controller.getInformation("����");
		
		System.out.println("\n*** 07. '����' ���� ���� �� ������ information �˻� ***");
		System.out.println("\n07-1. ���� �� ������Ʈ �˻� ");
		controller.getInformation("����");
		controller.deleteInformation("����");
		
		System.out.println("\n07-2. ���� �� ������Ʈ �˻� ");
		controller.getInformation("����");
		
		System.out.println("\n07-3. ������ ������Ʈ ���� ��õ� �� ��ȿ�� ������ ���ռ� ����");
		controller.deleteInformation("����");
		
	}

}
