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
		petlist.add(new PrivateInformation(new Pet("토토", "dog","푸들", "white", "female", "150607", 5),
				(new Protector("조윤혜", 41841840, "서울시 광진구 광장동", "토토"))));
		petlist.add(new PrivateInformation(new Pet("자봉", "dog", "요크셔테리어", "brown", "male", "141214", 6),
				(new Protector("장수진", 21061840, "경기도 의정부시 청학동", "자봉"))));
		petlist.add(new PrivateInformation(new Pet("임금", "hamster","golden", "white", "female", "180107", 2),
				(new Protector("강윤조", 52891836, "경기도 구리시 교문동", "임금"))));
		petlist.add(new PrivateInformation(new Pet("리온", "cat","korean short hair", "brown", "female", "150329", 5),
				(new Protector("장예은", 45679876, "경기도 구리시 교문동", "리온"))));
			}
	public static PetDB getInstance() {
		return instance;
	}
	
	public void insertInformation(PrivateInformation newInformation) {
		petlist.add(newInformation);
	}
}
