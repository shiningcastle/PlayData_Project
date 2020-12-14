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
		petBuilder.append("반려동물 이름 : ");
		petBuilder.append(petName);
		petBuilder.append(", 대분류 : ");
		petBuilder.append(animalType);
		petBuilder.append(", 종 : ");
		petBuilder.append(species);
		petBuilder.append(", 색상 : ");
		petBuilder.append(hairColor);
		petBuilder.append(", 성별 : ");
		petBuilder.append(sex);
		petBuilder.append(", 출생일 : ");
		petBuilder.append(birthDay);
		petBuilder.append(", 연령 : ");
		petBuilder.append(age);
		return petBuilder.toString();
	}
}

