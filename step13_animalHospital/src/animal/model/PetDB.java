package animal.model;

import java.util.ArrayList;

import animal.model.dto.Pet;
import animal.model.dto.PrivateInformation;
import animal.model.dto.Protector;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PetDB {

	private static PetDB instance = new PetDB();
	private ArrayList<PrivateInformation> petlist= new ArrayList<PrivateInformation>();
	
	private PetDB() {
		petlist.add(new PrivateInformation(new Pet("����", "dog","Ǫ��", "white", "female", "150607", 5),
				(new Protector("������", 41841840, "����� ������ ���嵿", "����"))));
		petlist.add(new PrivateInformation(new Pet("�ں�", "dog", "��ũ���׸���", "brown", "male", "141214", 6),
				(new Protector("�����", 21061840, "��⵵ �����ν� û�е�", "�ں�"))));
		petlist.add(new PrivateInformation(new Pet("�ӱ�", "hamster","golden", "white", "female", "180107", 2),
				(new Protector("������", 52891836, "��⵵ ������ ������", "�ӱ�"))));
		petlist.add(new PrivateInformation(new Pet("����", "cat","korean short hair", "brown", "female", "150329", 5),
				(new Protector("�忹��", 45679876, "��⵵ ������ ������", "����"))));
			}
	public static PetDB getInstance() {
		return instance;
	}
	
	public void insertInformation(PrivateInformation newInformation) {
		petlist.add(newInformation);
	}
}
