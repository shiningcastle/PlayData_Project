package animal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrivateInformation {
	
	/** �������� ����**/
	private Pet Pet;
	
	/** ��ȣ�� ���� ���� **/
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
		informationBuilder.append("[1. �ݷ����� ���� ]  ");
		informationBuilder.append(Pet);
		informationBuilder.append("\n[2. ��ȣ��    ���� ] ");
		informationBuilder.append(Protector);
		return informationBuilder.toString();
	}
}
