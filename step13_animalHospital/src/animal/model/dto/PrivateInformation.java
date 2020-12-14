package animal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrivateInformation {
	
	/** 동물관련 정보**/
	private Pet Pet;
	
	/** 보호자 관련 정보 **/
	private Protector Protector;
	
	public PrivateInformation() {}
	public PrivateInformation(Pet Pet, Protector Protector) {
		this.Pet = Pet;
		this.Protector = Protector;
		}
	
	public Pet getPet() {
		return Pet;
	}
	public Protector getProtector() {
		return Protector;
	}
	
	public String toString() {
		StringBuilder informationBuilder = new StringBuilder();
		informationBuilder.append("[1. 반려동물 정보 ]  ");
		informationBuilder.append(Pet);
		informationBuilder.append("\n[2. 보호자    정보 ] ");
		informationBuilder.append(Protector);
		return informationBuilder.toString();
	}
}
