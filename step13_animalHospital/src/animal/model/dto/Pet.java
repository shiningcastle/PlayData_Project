package animal.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Pet {
	
	private String petName;
	private String animalType;
	private String species;
	private String hairColor;
	private String sex;
	private String birthDay;
	private int age;
	
	@Override
	public String toString() {
		StringBuilder petBuilder = new StringBuilder();
		petBuilder.append("�ݷ����� �̸� : ");
		petBuilder.append(petName);
		petBuilder.append(", ��з� : ");
		petBuilder.append(animalType);
		petBuilder.append(", �� : ");
		petBuilder.append(species);
		petBuilder.append(", ���� : ");
		petBuilder.append(hairColor);
		petBuilder.append(", ���� : ");
		petBuilder.append(sex);
		petBuilder.append(", ����� : ");
		petBuilder.append(birthDay);
		petBuilder.append(", ���� : ");
		petBuilder.append(age);
		return petBuilder.toString();
	}
}

